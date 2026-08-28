package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class RegistroActividadRequestDTO {
    private Long id;
    private Long idEmpleado;
    private Long idAlojamiento;
    private int horas;
    private LocalDate fecha;
    private int precioHora;
}
