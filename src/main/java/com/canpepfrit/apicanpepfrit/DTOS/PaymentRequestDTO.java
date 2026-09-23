package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PaymentRequestDTO {
    private Long id;
    private Long idBooking;
    private BigDecimal amount;
    private LocalDate paymentDate;
    private String method;
}
