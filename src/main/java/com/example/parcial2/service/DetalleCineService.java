package com.example.parcial2.service;

import com.example.parcial2.entity.DetalleCine;
import com.example.parcial2.repository.DetalleCineRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DetalleCineService {

    private final DetalleCineRepository detalleCineRepository;

    public DetalleCineService(DetalleCineRepository detalleCineRepository) {
        this.detalleCineRepository = detalleCineRepository;
    }

    @Transactional
    public DetalleCine guardarDetalle(DetalleCine detalleCine) {
        return detalleCineRepository.save(detalleCine);
    }
}

