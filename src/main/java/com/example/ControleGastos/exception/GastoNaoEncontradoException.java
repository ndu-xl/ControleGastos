package com.example.ControleGastos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GastoNaoEncontradoException extends RuntimeException{
    public GastoNaoEncontradoException(Long id) {
        super("Gasto "+id+" não encontrado");
    }
}
