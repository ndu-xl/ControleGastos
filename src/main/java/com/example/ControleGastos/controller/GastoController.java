package com.example.ControleGastos.controller;

import com.example.ControleGastos.model.Gasto;
import com.example.ControleGastos.service.GastoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/gastos")
public class GastoController {

    private final GastoService service;

    public GastoController(GastoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Gasto> listar(@RequestHeader("X-Visitante")UUID visitante) {
        return service.listar(visitante.toString());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Gasto criar(@Valid @RequestBody Gasto gasto, @RequestHeader("X-Visitante")UUID visitante) {
        return service.criar(gasto, visitante.toString());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id, @RequestHeader("X-Visitante")UUID visitante) {
        service.deletar(id, visitante.toString());
    }

    @GetMapping("/{id}")
    public Gasto buscarPorId(@PathVariable Long id, @RequestHeader("X-Visitante")UUID visitante) {
        return service.buscarPorId(id, visitante.toString());
    }

    @PutMapping("/{id}")
    public Gasto atualizar(@PathVariable Long id, @Valid @RequestBody Gasto gasto, @RequestHeader("X-Visitante")UUID visitante) {
        return service.atualizar(id, gasto, visitante.toString());
    }

}
