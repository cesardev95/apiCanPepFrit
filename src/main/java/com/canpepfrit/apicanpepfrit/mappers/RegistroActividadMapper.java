package com.canpepfrit.apicanpepfrit.mappers;

import com.canpepfrit.apicanpepfrit.DTOS.RegistroActividadDTO;
import com.canpepfrit.apicanpepfrit.models.RegistroActividad;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")

public interface RegistroActividadMapper {
    RegistroActividadDTO toDTO(RegistroActividad registroActividad);
    RegistroActividad toEntity(RegistroActividadDTO registroActividadDTO);
    List<RegistroActividadDTO> toDTOList(List<RegistroActividad> registros);
    List<RegistroActividad> toEntityList(List<RegistroActividadDTO> registrosDTO);
}
