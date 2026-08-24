package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

import java.util.List;

@Data
public class EmpleadoDTO {
    private Long id;
    private String nombre;
    private String telefono;
    private List<RegistroActividadDTO> registros;
}
