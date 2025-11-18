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

import com.example.pdm_back.model.EstadoVenta;
import com.example.pdm_back.service.EstadoVentaService;

@RestController
@RequestMapping("/api/estados-venta")
public class EstadoVentaController {
    @Autowired
    private EstadoVentaService estadoVentaService;

    @GetMapping
    public ResponseEntity<List<EstadoVenta>> getAllEstadoVentas() {
        List<EstadoVenta> estadoVentas = estadoVentaService.findAll();
        if (estadoVentas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estadoVentas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoVenta> getEstadoVentaById(@PathVariable Integer id) {
        EstadoVenta estadoVenta = estadoVentaService.findById(id);
        if (estadoVenta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estadoVenta);
    }

    @PostMapping
    public ResponseEntity<EstadoVenta> createEstadoVenta(@RequestBody EstadoVenta estadoVenta) {
        EstadoVenta createdEstadoVenta = estadoVentaService.save(estadoVenta);
        return ResponseEntity.status(201).body(createdEstadoVenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoVenta> updateEstadoVenta(@PathVariable Integer id, @RequestBody EstadoVenta estadoVenta) {
        estadoVenta.setId(id);
        EstadoVenta updatedEstadoVenta = estadoVentaService.save(estadoVenta);
        if (updatedEstadoVenta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedEstadoVenta);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EstadoVenta> updatePartialEstadoVenta(@PathVariable Integer id, @RequestBody EstadoVenta estadoVenta) {
        estadoVenta.setId(id);
        EstadoVenta updatedEstadoVenta = estadoVentaService.partialUpdate(estadoVenta);
        if (updatedEstadoVenta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedEstadoVenta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstadoVenta(@PathVariable Integer id) {
        estadoVentaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}