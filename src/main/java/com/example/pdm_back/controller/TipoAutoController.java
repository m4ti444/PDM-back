package com.example.pdm_back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pdm_back.model.TipoAuto;
import com.example.pdm_back.service.TipoAutoService;

@RestController
@RequestMapping("/api/tipos-auto")
public class TipoAutoController {
    @Autowired
    private TipoAutoService tipoAutoService;

    @GetMapping
    public ResponseEntity<List<TipoAuto>> getAllTipoAutos() {
        List<TipoAuto> tipoAutos = tipoAutoService.findAll();
        if (tipoAutos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tipoAutos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoAuto> getTipoAutoById(@PathVariable Integer id) {
        TipoAuto tipoAuto = tipoAutoService.findById(id);
        if (tipoAuto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tipoAuto);
    }

    @PostMapping
    public ResponseEntity<TipoAuto> createTipoAuto(@RequestBody TipoAuto tipoAuto) {
        TipoAuto createdTipoAuto = tipoAutoService.save(tipoAuto);
        return ResponseEntity.status(201).body(createdTipoAuto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoAuto> updateTipoAuto(@PathVariable Integer id, @RequestBody TipoAuto tipoAuto) {
        tipoAuto.setId(id);
        TipoAuto updatedTipoAuto = tipoAutoService.save(tipoAuto);
        if (updatedTipoAuto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTipoAuto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TipoAuto> updatePartialTipoAuto(@PathVariable Integer id, @RequestBody TipoAuto tipoAuto) {
        tipoAuto.setId(id);
        TipoAuto updatedTipoAuto = tipoAutoService.partialUpdate(tipoAuto);
        if (updatedTipoAuto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTipoAuto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoAuto(@PathVariable Integer id) {
        tipoAutoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}