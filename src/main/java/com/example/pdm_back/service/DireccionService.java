package com.example.pdm_back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pdm_back.model.Direccion;
import com.example.pdm_back.repository.DireccionRepository;


import jakarta.transaction.Transactional;

@Service
@Transactional
@SuppressWarnings("null")
public class DireccionService {
    @Autowired
    private DireccionRepository direccionRepository;

    public List<Direccion> findAll() {
        return direccionRepository.findAll();
    }

    public Direccion findById(Integer id) {
        Direccion direccion = direccionRepository.findById(id).orElse(null);
        return direccion;
    }

    public Direccion save(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    public Direccion partialUpdate(Direccion direccion){
        Direccion existingDireccion = direccionRepository.findById(direccion.getId()).orElse(null);
        if (existingDireccion != null) {
            if (direccion.getNombre() != null) {
                existingDireccion.setNombre(direccion.getNombre());
            }

            if(direccion.getNumero() != null) {
                existingDireccion.setNumero(direccion.getNumero());
            }

            if(direccion.getComuna() != null) {
                existingDireccion.setComuna(direccion.getComuna());
            }

            if(direccion.getUsuario() != null) {
                existingDireccion.setUsuario(direccion.getUsuario());
            }
            return direccionRepository.save(existingDireccion);
        }
        return null;
    }

    public void deleteById(Integer id) {
        direccionRepository.deleteById(id);
    }
}