package com.example.ControleGastos.repository;

import com.example.ControleGastos.model.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GastoRepository extends JpaRepository<Gasto, Long> {
    List<Gasto> findByVisitante(String visitante);
    Optional<Gasto> findByIdAndVisitante(Long id, String visitante);
    long countByVisitante(String visitante);
}
