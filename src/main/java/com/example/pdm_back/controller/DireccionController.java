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

import com.example.pdm_back.model.Direccion;
import com.example.pdm_back.model.Usuario;
import com.example.pdm_back.model.Comuna;
import com.example.pdm_back.service.DireccionService;
import com.example.pdm_back.service.UsuarioService;
import com.example.pdm_back.service.ComunaService;


@RestController
@RequestMapping("/api/direcciones")
public class DireccionController {
    @Autowired
    private DireccionService direccionService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ComunaService comunaService;

    @GetMapping
    public ResponseEntity<List<Direccion>> getAllDirecciones() {
        List<Direccion> direcciones = direccionService.findAll();
        if (direcciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(direcciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direccion> getDireccionById(@PathVariable Integer id) {
        Direccion direccion = direccionService.findById(id);
        if (direccion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(direccion);
    }

    @PostMapping
    public ResponseEntity<Direccion> createDireccion(@RequestBody Direccion direccion) {
        if (direccion.getUsuario() == null || direccion.getUsuario().getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        if (direccion.getComuna() == null || direccion.getComuna().getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        Usuario usuario = usuarioService.findById(direccion.getUsuario().getId());
        Comuna comuna = comunaService.findById(direccion.getComuna().getId());
        if (usuario == null || comuna == null) {
            return ResponseEntity.badRequest().build();
        }
        direccion.setId(null);
        direccion.setUsuario(usuario);
        direccion.setComuna(comuna);
        Direccion createdDireccion = direccionService.save(direccion);
        return ResponseEntity.status(201).body(createdDireccion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Direccion> updateDireccion(@PathVariable Integer id, @RequestBody Direccion direccion) {
        direccion.setId(id);
        Direccion updatedDireccion = direccionService.save(direccion);
        if (updatedDireccion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedDireccion);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Direccion> updatePartialDireccion(@PathVariable Integer id, @RequestBody Direccion direccion) {
        direccion.setId(id);
        Direccion updatedDireccion = direccionService.partialUpdate(direccion);
        if (updatedDireccion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedDireccion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDireccion(@PathVariable Integer id) {
        direccionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
