package com.example.parcial2.repository;

import com.example.parcial2.entity.Cine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CineRepository extends JpaRepository<Cine, Long> {

    // Consulta personalizada: buscar cines por nombre que contenga un texto
    @Query("SELECT c FROM Cine c WHERE LOWER(c.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Cine> buscarPorNombre(String nombre);
}

