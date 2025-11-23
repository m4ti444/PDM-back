package com.example.pdm_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pdm_back.model.EstadoVenta;

@Repository
public interface EstadoVentaRepository extends JpaRepository<EstadoVenta, Integer> {
}