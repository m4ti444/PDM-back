package com.example.pdm_back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pdm_back.model.Rol;
import com.example.pdm_back.repository.RolRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    @SuppressWarnings("null")
    public Rol findById(Integer id) {
        return rolRepository.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    @SuppressWarnings("null")
    public void deleteById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("id no puede ser nulo");
        }
        rolRepository.deleteById(id);
    }
}
