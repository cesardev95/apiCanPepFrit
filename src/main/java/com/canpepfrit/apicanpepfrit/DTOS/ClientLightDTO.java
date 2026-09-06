package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

@Data
public class ClientLightDTO {
    private Long id;
    private String name;
    private String address;
    private String email;
    private String phone;
}
