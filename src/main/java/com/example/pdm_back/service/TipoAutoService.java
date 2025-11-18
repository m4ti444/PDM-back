package com.example.pdm_back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pdm_back.model.TipoAuto;
import com.example.pdm_back.repository.TipoAutoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
@SuppressWarnings("null")
public class TipoAutoService {
    @Autowired
    private TipoAutoRepository tipoAutoRepository;

    public List<TipoAuto> findAll() {
        return tipoAutoRepository.findAll();
    }

    public TipoAuto findById(Integer id) {
        TipoAuto tipoAuto = tipoAutoRepository.findById(id).orElse(null);
        return tipoAuto;
    }

    public TipoAuto save(TipoAuto tipoAuto) {
        return tipoAutoRepository.save(tipoAuto);
    }

    public TipoAuto partialUpdate(TipoAuto tipoAuto){
        TipoAuto existingTipoAuto = tipoAutoRepository.findById(tipoAuto.getId()).orElse(null);
        if (existingTipoAuto != null) {
            if (tipoAuto.getTipo() != null) {
                existingTipoAuto.setTipo(tipoAuto.getTipo());
            }

            if (tipoAuto.getAutos() != null) {
                existingTipoAuto.setAutos(tipoAuto.getAutos());
            }
            return tipoAutoRepository.save(existingTipoAuto);
        }
        return null;
    }

    public void deleteById(Integer id) {
        tipoAutoRepository.deleteById(id);
    }
}