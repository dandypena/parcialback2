package com.example.parcial2.controller;

import com.example.parcial2.entity.Cine;
import com.example.parcial2.repository.CineRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cines")
public class CineController {

    private final CineRepository cineRepository;

    public CineController(CineRepository cineRepository) {
        this.cineRepository = cineRepository;
    }

    // Crear cine
    @PostMapping
    public ResponseEntity<Cine> crearCine(@Valid @RequestBody Cine cine) {
        Cine nuevo = cineRepository.save(cine);
        return ResponseEntity.ok(nuevo);
    }

    // Listar todos los cines
    @GetMapping
    public List<Cine> listarCines() {
        return cineRepository.findAll();
    }

    // Buscar cine por id
    @GetMapping("/{id}")
    public ResponseEntity<Cine> obtenerCine(@PathVariable Long id) {
        return cineRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    // Actualizar cine
    @PutMapping("/{id}")
    public ResponseEntity<Cine> actualizarCine(@PathVariable Long id, @Valid @RequestBody Cine cineDetalles) {
        return cineRepository.findById(id)
                .map(cine -> {
                    cine.setNombre(cineDetalles.getNombre());
                    cine.setNit(cineDetalles.getNit());
                    Cine actualizado = cineRepository.save(cine);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }


    // Eliminar cine
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCine(@PathVariable Long id) {
        return cineRepository.findById(id)
                .map(cine -> {
                    cineRepository.delete(cine);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

