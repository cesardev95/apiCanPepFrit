package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ReservaDTO {
    private Long id;
    private ClienteDTO clienteDTO;
    private AlojamientoDTO alojamientoDTO;
    private Date fechaInicio;
    private Date fechaFinal;
    private BigDecimal precio;
}
