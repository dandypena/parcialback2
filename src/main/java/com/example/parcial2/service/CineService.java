package com.example.parcial2.service;

import com.example.parcial2.entity.Cine;
import com.example.parcial2.dto.CineDTO;
import com.example.parcial2.mapper.CineMapper;
import com.example.parcial2.repository.CineRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CineService {

    private final CineRepository cineRepository;

    public CineService(CineRepository cineRepository) {
        this.cineRepository = cineRepository;
    }

    @Transactional
    public CineDTO guardarCine(CineDTO cineDTO) {
        // Convertir DTO a entidad
        Cine cine = CineMapper.toEntity(cineDTO);

        // Guardar en DB
        Cine guardado = cineRepository.save(cine);

        // Retornar DTO del cine guardado
        return CineMapper.toDTO(guardado);
    }
}

