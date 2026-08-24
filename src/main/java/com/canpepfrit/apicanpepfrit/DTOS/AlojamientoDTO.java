package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

import java.util.List;

@Data
public class AlojamientoDTO {
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private List<RegistroActividadDTO> registros;
    private List<ReservaDTO> reservas;
}
