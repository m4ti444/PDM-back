package com.example.pdm_back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pdm_back.model.Region;
import com.example.pdm_back.repository.RegionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
@SuppressWarnings("null")
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    public Region findById(Integer id) {
        Region region = regionRepository.findById(id).orElse(null);
        return region;
    }

    public Region save(Region region) {
        return regionRepository.save(region);
    }

    public Region partialUpdate(Region region){
        Region existingRegion = regionRepository.findById(region.getId()).orElse(null);
        if (existingRegion != null) {
            if (region.getNombre() != null) {
                existingRegion.setNombre(region.getNombre());
            }

            if (region.getComunas() != null) {
                existingRegion.setComunas(region.getComunas());
            }
            return regionRepository.save(existingRegion);
        }
        return null;
    }

    public void deleteById(Integer id) {
        regionRepository.deleteById(id);
    }
}