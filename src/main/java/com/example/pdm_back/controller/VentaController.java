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

import com.example.pdm_back.model.Venta;
import com.example.pdm_back.model.EstadoVenta;
import com.example.pdm_back.model.MetodoPago;
import com.example.pdm_back.model.MetodoEnvio;
import com.example.pdm_back.service.VentaService;
import com.example.pdm_back.service.EstadoVentaService;
import com.example.pdm_back.service.MetodoPagoService;
import com.example.pdm_back.service.MetodoEnvioService;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @Autowired
    private EstadoVentaService estadoVentaService;

    @Autowired
    private MetodoPagoService metodoPagoService;

    @Autowired
    private MetodoEnvioService metodoEnvioService;

    @GetMapping
    public ResponseEntity<List<Venta>> getAllVentas() {
        List<Venta> ventas = ventaService.findAll();
        if (ventas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ventas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable Integer id) {
        Venta venta = ventaService.findById(id);
        if (venta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(venta);
    }

    @PostMapping
    public ResponseEntity<Venta> createVenta(@RequestBody Venta venta) {
        if (venta.getEstadoVenta() == null || venta.getEstadoVenta().getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        if (venta.getMetodoPago() == null || venta.getMetodoPago().getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        if (venta.getMetodoEnvio() == null || venta.getMetodoEnvio().getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        EstadoVenta estadoVenta = estadoVentaService.findById(venta.getEstadoVenta().getId());
        MetodoPago metodoPago = metodoPagoService.findById(venta.getMetodoPago().getId());
        MetodoEnvio metodoEnvio = metodoEnvioService.findById(venta.getMetodoEnvio().getId());
        if (estadoVenta == null || metodoPago == null || metodoEnvio == null) {
            return ResponseEntity.badRequest().build();
        }
        venta.setId(null);
        venta.setEstadoVenta(estadoVenta);
        venta.setMetodoPago(metodoPago);
        venta.setMetodoEnvio(metodoEnvio);
        Venta createdVenta = ventaService.save(venta);
        return ResponseEntity.status(201).body(createdVenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> updateNave(@PathVariable Integer id, @RequestBody Venta venta) {
        venta.setId(id);
        Venta updatedVenta = ventaService.save(venta);
        if (updatedVenta == null) {
            return ResponseEntity.notFound().build();  
        }
        return ResponseEntity.ok(updatedVenta);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Venta> partialUpdateVenta(@PathVariable Integer id, @RequestBody Venta venta) {
        Venta existingVenta = ventaService.findById(id);
        if (existingVenta == null) {
            return ResponseEntity.notFound().build();  
        }
        return ResponseEntity.ok(ventaService.partialUpdate(venta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Integer id) {
        ventaService.deleteById(id);
        return ResponseEntity.noContent().build();  
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }
}
