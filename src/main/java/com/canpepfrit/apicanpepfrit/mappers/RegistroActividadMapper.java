package com.canpepfrit.apicanpepfrit.mappers;

import com.canpepfrit.apicanpepfrit.DTOS.RegistroActividadDTO;
import com.canpepfrit.apicanpepfrit.models.RegistroActividad;

import java.util.List;

public interface RegistroActividadMapper {
    RegistroActividadDTO toDTO(RegistroActividad registroActividad);
    RegistroActividad toEntity(RegistroActividadDTO registroActividadDTO);
    List<RegistroActividadDTO> toDTOList(RegistroActividad registros);
}
