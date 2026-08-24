package com.canpepfrit.apicanpepfrit.mappers;

import com.canpepfrit.apicanpepfrit.DTOS.ReservaDTO;
import com.canpepfrit.apicanpepfrit.models.Reserva;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservaMapper {
    ReservaDTO toDTO(Reserva reserva);
    Reserva toEntity(ReservaDTO reservaDTO);
    List<ReservaDTO> toDTOList(List<Reserva> reservas);
}
