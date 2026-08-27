package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
public class ReservaRequestDTO {
    private Long id;
    private Long idCliente;
    private Long idAlojamiento;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private BigDecimal precio;
}
