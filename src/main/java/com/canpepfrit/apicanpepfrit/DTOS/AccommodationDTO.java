package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

import java.util.List;

@Data
public class AccommodationDTO {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private boolean status;
    private List<ActivityLogDTO> logs;
    private List<BookingDTO> bookings;
}
