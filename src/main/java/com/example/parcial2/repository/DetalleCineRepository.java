package com.example.parcial2.repository;

import com.example.parcial2.entity.DetalleCine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface DetalleCineRepository extends JpaRepository<DetalleCine, Long> {

    // Consulta personalizada: obtener detalles de cine por ciudad
    @Query("SELECT d FROM DetalleCine d WHERE LOWER(d.ciudad) = LOWER(:ciudad)")
    List<DetalleCine> buscarPorCiudad(String ciudad);
}
