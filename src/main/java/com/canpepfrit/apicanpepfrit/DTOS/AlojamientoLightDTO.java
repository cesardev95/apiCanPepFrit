package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

@Data
public class AlojamientoLightDTO {
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private boolean estado;

}
