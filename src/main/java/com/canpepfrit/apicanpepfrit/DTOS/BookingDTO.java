package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BookingDTO {
    private Long id;
    private ClientLightDTO client;
    private AccommodationLightDTO accommodation;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal price;
    private LocalDate bookingDate;
    private BigDecimal totalEcotasa;
    private String plataform;
    private int people;
}
