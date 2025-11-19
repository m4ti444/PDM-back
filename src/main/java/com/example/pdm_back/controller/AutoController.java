package com.example.pdm_back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.pdm_back.model.Auto;
import com.example.pdm_back.service.AutoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/autos")
public class AutoController {
    @Autowired
    private AutoService autoService;

    @GetMapping
    public ResponseEntity<List<Auto>> getAllAutos() {
        List<Auto> autos = autoService.findAll();
        if (autos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(autos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auto> getAutoById(@PathVariable Integer id) {
        Auto auto = autoService.findById(id);
        if (auto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(auto);
    }

    @PostMapping
    public ResponseEntity<Auto> createAuto(@RequestBody Auto auto) {
        auto.setId(null);
        Auto createdAuto = autoService.save(auto);
        return ResponseEntity.status(201).body(createdAuto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Auto> updateNave(@PathVariable Integer id, @RequestBody Auto auto) {
        auto.setId(id);
        Auto updatedAuto = autoService.save(auto);
        if (updatedAuto == null) {
            return ResponseEntity.notFound().build();  
        }
        return ResponseEntity.ok(updatedAuto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Auto> partialUpdateAuto(@PathVariable Integer id, @RequestBody Auto auto) {
        Auto existingAuto = autoService.findById(id);
        if (existingAuto == null) {
            return ResponseEntity.notFound().build();  
        }
        return ResponseEntity.ok(autoService.partialUpdate(auto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuto(@PathVariable Integer id) {
        autoService.deleteById(id);
        return ResponseEntity.noContent().build();  
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }

}