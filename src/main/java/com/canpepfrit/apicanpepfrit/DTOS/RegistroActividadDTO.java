package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class RegistroActividadDTO {
    private Long id;
    private EmpleadoLightDTO empleado;
    private AlojamientoLightDTO alojamiento;
    private int horas;
    private LocalDate fecha;
}
