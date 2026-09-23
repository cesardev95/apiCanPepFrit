package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ActivityLogDTO {
    private Long id;
    private EmployeeLightDTO employee;
    private AccommodationLightDTO accommodation;
    private int hours;
    private LocalDate date;
    private int hourPrice;
    private boolean paid;
}
