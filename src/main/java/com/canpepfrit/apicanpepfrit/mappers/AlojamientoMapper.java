package com.canpepfrit.apicanpepfrit.mappers;

import com.canpepfrit.apicanpepfrit.DTOS.AlojamientoDTO;
import com.canpepfrit.apicanpepfrit.models.Alojamiento;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlojamientoMapper {
    Alojamiento toDTO(Alojamiento alojamiento);
    AlojamientoDTO toEntity(AlojamientoDTO alojamientoDTO);

    List<AlojamientoDTO> toDTOList(List<Alojamiento> alojamientoList);
}
