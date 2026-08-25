package com.canpepfrit.apicanpepfrit.mappers;

import com.canpepfrit.apicanpepfrit.DTOS.AlojamientoDTO;
import com.canpepfrit.apicanpepfrit.models.Alojamiento;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ReservaMapper.class, RegistroActividadMapper.class})
public interface AlojamientoMapper {
    AlojamientoDTO toDTO(Alojamiento alojamiento);
    Alojamiento toEntity(AlojamientoDTO alojamientoDTO);
    List<AlojamientoDTO> toDTOList(List<Alojamiento> alojamientoList);

    void updateEntityFromDTO(AlojamientoDTO dto, @MappingTarget Alojamiento entity);
}
