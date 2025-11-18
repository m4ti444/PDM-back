package com.example.pdm_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pdm_back.model.Comuna;

@Repository
public interface ComunaRepository extends JpaRepository<Comuna, Integer> {
}