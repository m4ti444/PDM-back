package com.example.pdm_back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pdm_back.model.MetodoEnvio;
import com.example.pdm_back.repository.MetodoEnvioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
@SuppressWarnings("null")
public class MetodoEnvioService {
    @Autowired
    private MetodoEnvioRepository metodoEnvioRepository;

    public List<MetodoEnvio> findAll() {
        return metodoEnvioRepository.findAll();
    }

    public MetodoEnvio findById(Integer id) {
        MetodoEnvio metodoEnvio = metodoEnvioRepository.findById(id).orElse(null);
        return metodoEnvio;
    }

    public MetodoEnvio save(MetodoEnvio metodoEnvio) {
        return metodoEnvioRepository.save(metodoEnvio);
    }

    public MetodoEnvio partialUpdate(MetodoEnvio metodoEnvio){
        MetodoEnvio existingMetodoEnvio = metodoEnvioRepository.findById(metodoEnvio.getId()).orElse(null);
        if (existingMetodoEnvio != null) {
            if (metodoEnvio.getMetodoEnvio() != null) {
                existingMetodoEnvio.setMetodoEnvio(metodoEnvio.getMetodoEnvio());
            }
            return metodoEnvioRepository.save(existingMetodoEnvio);
        }
        return null;
    }

    public void deleteById(Integer id) {
        metodoEnvioRepository.deleteById(id);
    }
}