package com.example.ControleGastos.controller;

import com.example.ControleGastos.model.Gasto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/gastos")
public class GastoController {

    private final List<Gasto> gastos = new ArrayList<>();
    private long proximoId = 1;

    @GetMapping
    public List<Gasto> listar() {
        return gastos;
    }

    @PostMapping
    public Gasto criar(@RequestBody Gasto gasto) {
        gasto.setId(proximoId++);
        gastos.add(gasto);
        return gasto;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        for (Gasto gasto : gastos) {
            if (gasto.getId() == id) {
                gastos.remove(gasto);
            }
        }
    }
    @GetMapping("/{id}")
    public Gasto obterGasto(@PathVariable long id) {
        for (Gasto gasto : gastos) {
            if (gasto.getId() == id) {
                return gasto;
            }
        }
        return null;
    }
}
