package com.example.parcial2.controller;

import com.example.parcial2.entity.Sala;
import com.example.parcial2.repository.SalaRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salas")
public class SalaController {

    private final SalaRepository salaRepository;

    public SalaController(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    // Crear sala
    @PostMapping
    public ResponseEntity<Sala> crearSala(@Valid @RequestBody Sala sala) {
        Sala nueva = salaRepository.save(sala);
        return ResponseEntity.ok(nueva);
    }

    // Listar todas las salas
    @GetMapping
    public List<Sala> listarSalas() {
        return salaRepository.findAll();
    }

    // Buscar sala por id
    @GetMapping("/{id}")
    public ResponseEntity<Sala> obtenerSala(@PathVariable Long id) {
        return salaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar sala
    @PutMapping("/{id}")
    public ResponseEntity<Sala> actualizarSala(@PathVariable Long id, @Valid @RequestBody Sala salaDetalles) {
        return salaRepository.findById(id)
                .map(sala -> {
                    sala.setNombre(salaDetalles.getNombre());
                    sala.setCapacidad(salaDetalles.getCapacidad());
                    sala.setTipo(salaDetalles.getTipo());
                    Sala actualizado = salaRepository.save(sala);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar sala
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSala(@PathVariable Long id) {
        return salaRepository.findById(id)
                .map(sala -> {
                    salaRepository.delete(sala);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
