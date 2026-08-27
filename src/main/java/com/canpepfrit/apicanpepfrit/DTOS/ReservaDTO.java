package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ReservaDTO {
    private Long id;
    private ClienteLightDTO cliente;
    private AlojamientoLightDTO alojamiento;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private BigDecimal precio;
}
