package com.canpepfrit.apicanpepfrit.mappers;

import com.canpepfrit.apicanpepfrit.DTOS.AlojamientoDTO;
import com.canpepfrit.apicanpepfrit.DTOS.ClienteDTO;
import com.canpepfrit.apicanpepfrit.DTOS.EmpleadoDTO;
import com.canpepfrit.apicanpepfrit.DTOS.EmpleadoLightDTO;
import com.canpepfrit.apicanpepfrit.models.Alojamiento;
import com.canpepfrit.apicanpepfrit.models.Cliente;
import com.canpepfrit.apicanpepfrit.models.Empleado;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper {
    EmpleadoDTO toDTO(Empleado empleado);
    Empleado toEntity(EmpleadoDTO empleadoDTO);

    EmpleadoLightDTO toLightDTO(Empleado empleado);

    List<EmpleadoDTO> toDTOList(List<Empleado> empleados);

    void updateEntityFromDTO(EmpleadoDTO dto, @MappingTarget Empleado entity);

}
