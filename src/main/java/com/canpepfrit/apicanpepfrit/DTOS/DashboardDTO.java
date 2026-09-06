package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data

public class DashboardDTO {
    private BigDecimal totalAmount;
    private BigDecimal totalEcotasa;
    private List<BookingRowDTO> bookings;

}
