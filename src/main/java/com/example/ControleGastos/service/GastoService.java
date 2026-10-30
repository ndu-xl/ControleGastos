package com.example.ControleGastos.service;

import com.example.ControleGastos.exception.GastoNaoEncontradoException;
import com.example.ControleGastos.model.Gasto;
import com.example.ControleGastos.repository.GastoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GastoService {
    private final GastoRepository repository;

    public GastoService(GastoRepository repository) {
        this.repository = repository;
    }

    public List<Gasto> listar() {
        return repository.findAll();
    }

    public Gasto criar(Gasto gasto) {
        gasto.setId(null);
        if (gasto.getData() == null) {
            gasto.setData(LocalDate.now());
        }
        return repository.save(gasto);
    }

    public Gasto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new GastoNaoEncontradoException(id));
    }

    public void deletar(Long id){
        Gasto gasto = buscarPorId(id);
        repository.delete(gasto);
    }

    public Gasto atualizar(Long id, Gasto gasto) {
        Gasto gastoAtualizado = buscarPorId(id);
        gastoAtualizado.setCategoria(gasto.getCategoria());
        gastoAtualizado.setDescricao(gasto.getDescricao());
        gastoAtualizado.setData(
                gasto.getData() == null ? LocalDate.now() : gasto.getData()
        );
        gastoAtualizado.setValor(gasto.getValor());
        return repository.save(gastoAtualizado);
    }
}
