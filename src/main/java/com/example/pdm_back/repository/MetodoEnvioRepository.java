package com.example.pdm_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pdm_back.model.MetodoEnvio;

@Repository
public interface MetodoEnvioRepository extends JpaRepository<MetodoEnvio, Integer> {
}