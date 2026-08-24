package com.canpepfrit.apicanpepfrit.mappers;

import com.canpepfrit.apicanpepfrit.DTOS.EmpleadoDTO;
import com.canpepfrit.apicanpepfrit.models.Empleado;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper {
    EmpleadoDTO toDTO(Empleado empleado);
    Empleado toEntity(EmpleadoDTO empleadoDTO);

    List<EmpleadoDTO> toDTOList(List<Empleado> empleados);
}
