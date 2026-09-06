package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeDTO {
    private Long id;
    private String name;
    private String phone;
    private List<ActivityLogDTO> logs;
}
