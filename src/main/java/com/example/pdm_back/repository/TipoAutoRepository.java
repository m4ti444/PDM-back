package com.example.pdm_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pdm_back.model.TipoAuto;

@Repository
public interface TipoAutoRepository extends JpaRepository<TipoAuto, Integer> {
}