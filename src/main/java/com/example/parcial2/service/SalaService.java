package com.example.parcial2.service;

import com.example.parcial2.entity.Sala;
import com.example.parcial2.repository.SalaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SalaService {

    private final SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    @Transactional
    public Sala guardarSala(Sala sala) {
        return salaRepository.save(sala);
    }
}
