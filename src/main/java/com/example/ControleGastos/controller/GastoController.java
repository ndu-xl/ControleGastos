package com.example.ControleGastos.controller;

import com.example.ControleGastos.model.Gasto;
import com.example.ControleGastos.service.GastoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gastos")
public class GastoController {

    private final GastoService service;

    public GastoController(GastoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Gasto> listar() {
        return service.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Gasto criar(@Valid @RequestBody Gasto gasto) {
        return service.criar(gasto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
    @GetMapping("/{id}")
    public Gasto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
    @PutMapping("/{id}")
    public Gasto atualizar(@PathVariable Long id, @Valid @RequestBody Gasto gasto) {
        return service.atualizar(id, gasto);
    }

}
