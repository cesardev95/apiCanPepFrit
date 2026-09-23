package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BookingLightDTO {
    private Long id;
    private ClientLightDTO client;
    private AccommodationLightDTO accommodation;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal price;
    private LocalDate bookingDate;
    private BigDecimal totalEcotasa;
    private String platform;
    private int people;
    private boolean paid;
    private String details;
}
