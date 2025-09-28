package com.example.parcial2.repository;

import com.example.parcial2.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface SalaRepository extends JpaRepository<Sala, Long> {

    // Consulta personalizada: buscar salas por tipo (2D, 3D, IMAX)
    @Query("SELECT s FROM Sala s WHERE LOWER(s.tipo) = LOWER(:tipo)")
    List<Sala> buscarPorTipo(String tipo);
}

