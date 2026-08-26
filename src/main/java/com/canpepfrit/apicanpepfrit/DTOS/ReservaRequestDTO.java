package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ReservaRequestDTO {
    private Long id;
    private Long idCliente;
    private Long idAlojamiento;
    private Date fechaInicio;
    private Date fechaFinal;
    private BigDecimal precio;
}
