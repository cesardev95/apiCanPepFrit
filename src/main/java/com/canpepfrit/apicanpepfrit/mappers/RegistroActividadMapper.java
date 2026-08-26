package com.canpepfrit.apicanpepfrit.mappers;

import com.canpepfrit.apicanpepfrit.DTOS.RegistroActividadDTO;
import com.canpepfrit.apicanpepfrit.DTOS.RegistroActividadRequestDTO;
import com.canpepfrit.apicanpepfrit.models.RegistroActividad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")

public interface RegistroActividadMapper {
    RegistroActividadDTO toDTO(RegistroActividad registroActividad);
    List<RegistroActividadDTO> toDTOList(List<RegistroActividad> registros);

    @Mapping(target = "alojamiento", ignore = true)
    @Mapping(target = "empleado", ignore = true)
    RegistroActividad toEntity(RegistroActividadRequestDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "alojamiento", ignore = true)
    @Mapping(target = "empleado", ignore = true)
    void updateEntityFromDTO(RegistroActividadRequestDTO dto, @MappingTarget RegistroActividad entity);
    List<RegistroActividad> toEntityList(List<RegistroActividadRequestDTO> registrosDTO);

    RegistroActividad toEntityFromDTO(RegistroActividadDTO dto);
    List<RegistroActividad> toEntityListFromDTO(List<RegistroActividadDTO> dtos);


}
