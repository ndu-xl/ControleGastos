package com.example.ControleGastos.controller;

import com.example.ControleGastos.model.Gasto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/gastos")
public class GastoController {

    private final List<Gasto> gastos = new ArrayList<>();
    private Long proximoId = 1;
}
