package com.example.ControleGastos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100, message = "A descrição tem que ter no máximo 100 caracteres")
    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    @Positive(message = "O valor deve ser maior que zero")
    private double valor;

    @Size(max = 50, message = "A categoria tem que ter no máximo 50 caracteres")
    @NotBlank(message = "A categoria é obrigatória")
    private String categoria;

    @PastOrPresent(message = "A data não pode ser futura")
    private LocalDate data;

    @JsonIgnore
    @Column(length = 36)
    private String visitante;

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
