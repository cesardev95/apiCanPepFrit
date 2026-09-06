package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

@Data
public class AccommodationLightDTO {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private boolean status;

}
