package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
    private String platform;
    private int people;
    private boolean paid;
    private String details;
    private List<PaymentDTO> payments;

}
