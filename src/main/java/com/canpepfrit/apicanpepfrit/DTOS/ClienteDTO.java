package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

@Data
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String direccion;
    private String email;
    private String telefono;
}
