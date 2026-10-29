package com.example.ControleGastos.controller;

import com.example.ControleGastos.model.Gasto;
import com.example.ControleGastos.repository.GastoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gastos")
public class GastoController {

    private final GastoRepository repository;

    public GastoController(GastoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Gasto> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Gasto criar(@RequestBody Gasto gasto) {
        return repository.save(gasto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
    @GetMapping("/{id}")
    public Gasto buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
}
