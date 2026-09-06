package com.canpepfrit.apicanpepfrit.mappers;

import com.canpepfrit.apicanpepfrit.DTOS.EmployeeDTO;
import com.canpepfrit.apicanpepfrit.DTOS.EmployeeLightDTO;
import com.canpepfrit.apicanpepfrit.models.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDTO toDTO(Employee employee);

    Employee toEntity(EmployeeDTO employeeDTO);

    EmployeeLightDTO toLightDTO(Employee employee);

    List<EmployeeDTO> toDTOList(List<Employee> employees);

    void updateEntityFromDTO(EmployeeDTO dto, @MappingTarget Employee entity);

}
