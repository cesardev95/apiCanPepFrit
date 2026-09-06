package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BookingRowDTO {
    private String month;
    private String days;
    private String clientName;
    private String plataform;
    private LocalDate bookingDate;
    private BigDecimal netAmountBooking;
    private BigDecimal nightPrice = BigDecimal.ZERO;
    private BigDecimal ecotasa;
}
