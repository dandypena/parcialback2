package com.example.parcial2.controller;

import com.example.parcial2.entity.DetalleCine;
import com.example.parcial2.repository.DetalleCineRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles")
public class DetalleCineController {

    private final DetalleCineRepository detalleCineRepository;

    public DetalleCineController(DetalleCineRepository detalleCineRepository) {
        this.detalleCineRepository = detalleCineRepository;
    }

    // Crear detalle
    @PostMapping
    public ResponseEntity<DetalleCine> crearDetalle(@Valid @RequestBody DetalleCine detalle) {
        DetalleCine nuevo = detalleCineRepository.save(detalle);
        return ResponseEntity.ok(nuevo);
    }

    // Listar todos los detalles
    @GetMapping
    public List<DetalleCine> listarDetalles() {
        return detalleCineRepository.findAll();
    }

    // Buscar detalle por id
    @GetMapping("/{id}")
    public ResponseEntity<DetalleCine> obtenerDetalle(@PathVariable Long id) {
        return detalleCineRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar detalle
    @PutMapping("/{id}")
    public ResponseEntity<DetalleCine> actualizarDetalle(@PathVariable Long id, @Valid @RequestBody DetalleCine detalleNuevo) {
        return detalleCineRepository.findById(id)
                .map(detalle -> {
                    detalle.setDireccion(detalleNuevo.getDireccion());
                    detalle.setCiudad(detalleNuevo.getCiudad());
                    detalle.setTelefono(detalleNuevo.getTelefono());
                    DetalleCine actualizado = detalleCineRepository.save(detalle);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar detalle
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetalle(@PathVariable Long id) {
        return detalleCineRepository.findById(id)
                .map(detalle -> {
                    detalleCineRepository.delete(detalle);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
