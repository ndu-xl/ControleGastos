package com.example.ControleGastos.repository;

import com.example.ControleGastos.model.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastoRepository extends JpaRepository<Gasto, Long> {
}
