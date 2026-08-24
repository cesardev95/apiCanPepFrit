package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

import java.util.Date;

@Data
public class RegistroActividadDTO {
    private Long id;
    private EmpleadoDTO empleadoDTO;
    private AlojamientoDTO alojamientoDTO;
    private int horas;
    private Date fecha;
}
