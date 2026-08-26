package com.canpepfrit.apicanpepfrit.mappers;

import com.canpepfrit.apicanpepfrit.DTOS.ReservaDTO;
import com.canpepfrit.apicanpepfrit.DTOS.ReservaRequestDTO;
import com.canpepfrit.apicanpepfrit.models.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservaMapper {
    ReservaDTO toDTO(Reserva reserva);

    Reserva toEntityFromDTO(ReservaDTO reservaDTO);

    List<ReservaDTO> toDTOList(List<Reserva> reservas);

    List<Reserva> toEntityList(List<ReservaDTO> reservasDTO);

    List<Reserva> toEntityListFromRequest(List<ReservaRequestDTO> dtos);

    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "alojamiento", ignore = true)
    Reserva toEntity(ReservaRequestDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "alojamiento", ignore = true)
    Reserva updateEntityFromRequest(ReservaRequestDTO dto, @MappingTarget Reserva entity);


}
