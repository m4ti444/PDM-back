package com.example.pdm_back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pdm_back.model.EstadoVenta;
import com.example.pdm_back.repository.EstadoVentaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
@SuppressWarnings("null")
public class EstadoVentaService {
    @Autowired
    private EstadoVentaRepository estadoVentaRepository;

    public List<EstadoVenta> findAll() {
        return estadoVentaRepository.findAll();
    }

    public EstadoVenta findById(Integer id) {
        EstadoVenta estadoVenta = estadoVentaRepository.findById(id).orElse(null);
        return estadoVenta;
    }

    public EstadoVenta save(EstadoVenta estadoVenta) {
        return estadoVentaRepository.save(estadoVenta);
    }

    public EstadoVenta partialUpdate(EstadoVenta estadoVenta){
        EstadoVenta existingEstadoVenta = estadoVentaRepository.findById(estadoVenta.getId()).orElse(null);
        if (existingEstadoVenta != null) {
            if (estadoVenta.getEstadoVenta() != null) {
                existingEstadoVenta.setEstadoVenta(estadoVenta.getEstadoVenta());
            }
            return estadoVentaRepository.save(existingEstadoVenta);
        }
        return null;
    }

    public void deleteById(Integer id) {
        estadoVentaRepository.deleteById(id);
    }
}