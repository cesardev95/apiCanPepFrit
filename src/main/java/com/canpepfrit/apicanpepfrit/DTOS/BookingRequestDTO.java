package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BookingRequestDTO {
    private Long id;
    private Long idClient;
    private Long idAccommodation;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal price;
    private LocalDate bookingDate;
    private BigDecimal totalEcotasa;
    private String plataform;
    private int people;
}
