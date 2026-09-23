package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PaymentDTO {
    private Long id;
    private BookingLightDTO booking;
    private BigDecimal amount;
    private LocalDate paymentDate;
    private String method;
}
