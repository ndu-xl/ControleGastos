package com.example.ControleGastos.service;

import com.example.ControleGastos.exception.GastoNaoEncontradoException;
import com.example.ControleGastos.exception.RegraDeNegocio;
import com.example.ControleGastos.model.Gasto;
import com.example.ControleGastos.repository.GastoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GastoService {
    private final GastoRepository repository;
    private static final int LIMITE_POR_VISITANTE = 50;
    private static final double VALOR_MAXIMO = 1_000_000;

    private void validarRegras(Gasto gasto) {
        if (gasto.getValor() > VALOR_MAXIMO) {
            throw new RegraDeNegocio("O valor máximo é R$1.000.000,00");
        }
    }

    public GastoService(GastoRepository repository) {
        this.repository = repository;
    }

    public List<Gasto> listar(String visitante) {
        return repository.findByVisitante(visitante);
    }

    public Gasto criar(Gasto gasto, String visitante) {
        validarRegras(gasto);
        if (repository.countByVisitante(visitante) >= LIMITE_POR_VISITANTE) {
            throw new RegraDeNegocio("Limite de "+LIMITE_POR_VISITANTE+" gastos na demonstração. Exclua algum para adicionar outro.");
        }
        if (gasto.getData() == null) {
            gasto.setData(LocalDate.now());
        }
        gasto.setId(null);
        gasto.setVisitante(visitante);
        return repository.save(gasto);
    }

    public Gasto buscarPorId(Long id, String visitante) {
        return repository.findByIdAndVisitante(id, visitante)
                .orElseThrow(() -> new GastoNaoEncontradoException(id));
    }

    public void deletar(Long id, String visitante){
        Gasto gasto = buscarPorId(id, visitante);
        repository.delete(gasto);
    }

    public Gasto atualizar(Long id, Gasto gasto, String visitante) {
        Gasto gastoAtualizado = buscarPorId(id, visitante);
        gastoAtualizado.setCategoria(gasto.getCategoria());
        gastoAtualizado.setDescricao(gasto.getDescricao());
        gastoAtualizado.setData(
                gasto.getData() == null ? LocalDate.now() : gasto.getData()
        );
        gastoAtualizado.setValor(gasto.getValor());
        validarRegras(gastoAtualizado);
        return repository.save(gastoAtualizado);
    }
}
