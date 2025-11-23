package com.example.pdm_back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pdm_back.model.Auto;
import com.example.pdm_back.repository.AutoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
@SuppressWarnings("null")
public class AutoService {

    @Autowired
    private AutoRepository autoRepository;

    public List<Auto> findAll() {
        return autoRepository.findAll();
    }

    public Auto findById(Integer id) {
        Auto auto = autoRepository.findById(id).orElse(null);
        return auto;
    }

    public Auto save(Auto auto) {
        return autoRepository.save(auto);
    }

    public Auto partialUpdate(Auto auto){
        Auto existingAuto = autoRepository.findById(auto.getId()).orElse(null);
        if (existingAuto != null) {
            if (auto.getModelo() != null) {
                existingAuto.setModelo(auto.getModelo());
            }

            if (auto.getMarca() != null) {
                existingAuto.setMarca(auto.getMarca());
            }

            if (auto.getCombustible() != null) {
                existingAuto.setCombustible(auto.getCombustible());
            }

            if (auto.getOrigen() != null) {
                existingAuto.setOrigen(auto.getOrigen());
            }

            if (auto.getColor() != null) {
                existingAuto.setColor(auto.getColor());
            }

            if (auto.getUrl() != null) {
                existingAuto.setUrl(auto.getUrl());
            }

            if (auto.getTipoAuto() != null) {
                existingAuto.setTipoAuto(auto.getTipoAuto());
            }
            return autoRepository.save(existingAuto);
        }
        return null;
    }

    public void deleteById(Integer id) {
        autoRepository.deleteById(id);
    }




}