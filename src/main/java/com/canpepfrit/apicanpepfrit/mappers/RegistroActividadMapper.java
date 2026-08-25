package com.canpepfrit.apicanpepfrit.mappers;

import com.canpepfrit.apicanpepfrit.DTOS.RegistroActividadDTO;
import com.canpepfrit.apicanpepfrit.DTOS.RegistroActividadRequestDTO;
import com.canpepfrit.apicanpepfrit.models.Alojamiento;
import com.canpepfrit.apicanpepfrit.models.Empleado;
import com.canpepfrit.apicanpepfrit.models.RegistroActividad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
@Mapper(componentModel = "spring")

public interface RegistroActividadMapper {
    RegistroActividadDTO toDTO(RegistroActividad registroActividad);
    List<RegistroActividadDTO> toDTOList(List<RegistroActividad> registros);

    @Mapping(target = "alojamiento", source = "idAlojamiento")
    @Mapping(target = "empleado", source = "idEmpleado")
    RegistroActividad toEntity(RegistroActividadRequestDTO dto);

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "alojamiento", source = "idAlojamiento")
    @Mapping(target = "empleado", source = "idEmpleado")
    void updateEntityFromDTO(RegistroActividadRequestDTO dto, @MappingTarget RegistroActividad entity);
    List<RegistroActividad> toEntityList(List<RegistroActividadRequestDTO> registrosDTO);

    RegistroActividad toEntityFromDTO(RegistroActividadDTO dto);
    List<RegistroActividad> toEntityListFromDTO(List<RegistroActividadDTO> dtos);

    default Alojamiento mapAlojamiento(Long id){
        if(id ==null) return null;
        Alojamiento a = new Alojamiento();
        a.setId(id);
        return a;
    }

    default Empleado mapEmpleado(Long id){
        if(id==null) return null;
        Empleado e = new Empleado();
        e.setId(id);
        return e;
    }

}
