package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ActivityLogRequestDTO {
    private Long id;
    private Long idEmployee;
    private Long idAccommodation;
    private int hours;
    private LocalDate date;
    private int HourPrice;
}
