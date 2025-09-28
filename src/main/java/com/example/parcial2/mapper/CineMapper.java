package com.example.parcial2.mapper;

import com.example.parcial2.entity.Cine;
import com.example.parcial2.dto.CineDTO;

public class CineMapper {

    public static CineDTO toDTO(Cine cine) {
        if (cine == null) {
            return null;
        }

        String ciudad = (cine.getDetalle() != null) ? cine.getDetalle().getCiudad() : null;

        return new CineDTO(
                cine.getId(),
                cine.getNombre(),
                cine.getNit(),
                ciudad
        );
    }

    public static Cine toEntity(CineDTO dto) {
        if (dto == null) {
            return null;
        }

        Cine cine = new Cine();
        cine.setId(dto.getId());
        cine.setNombre(dto.getNombre());
        cine.setNit(dto.getNit());

        // Nota: no seteamos DetalleCine aquí porque DTO no lo trae completo
        return cine;
    }
}
