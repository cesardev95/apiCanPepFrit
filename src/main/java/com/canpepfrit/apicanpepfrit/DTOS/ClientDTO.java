package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

import java.util.List;

@Data
public class ClientDTO {
    private Long id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private List<BookingDTO> bookings;
}
