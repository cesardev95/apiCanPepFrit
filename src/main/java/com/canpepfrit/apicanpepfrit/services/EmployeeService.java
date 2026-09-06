package com.canpepfrit.apicanpepfrit.services;

import com.canpepfrit.apicanpepfrit.DTOS.EmployeeDTO;
import com.canpepfrit.apicanpepfrit.mappers.EmployeeMapper;
import com.canpepfrit.apicanpepfrit.models.Employee;
import com.canpepfrit.apicanpepfrit.repositories.RepoEmployee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final RepoEmployee repository;
    private final EmployeeMapper mapper;

    public EmployeeService(RepoEmployee repository, EmployeeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<EmployeeDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }

    public EmployeeDTO findById(Long id) {
        Optional<Employee> exists = repository.findById(id);
        if (exists.isPresent()) {
            Employee e = exists.get();
            return mapper.toDTO(e);
        } else {
            throw new RuntimeException("No hay empleado con id: " + id);
        }
    }

    public EmployeeDTO addEmployee(EmployeeDTO dto) {
        Employee e = mapper.toEntity(dto);
        Employee saved = repository.save(e);
        return mapper.toDTO(saved);
    }

    public EmployeeDTO alterEmployee(Long id, EmployeeDTO dto) {
        Optional<Employee> exists = repository.findById(id);
        if (exists.isPresent()) {
            Employee e = exists.get();
            mapper.updateEntityFromDTO(dto, e);
            Employee saved = repository.save(e);
            return mapper.toDTO(saved);

        } else {
            throw new RuntimeException("No se ha encontrado empleado con id: " + id);
        }
    }

    public String deleteEmployee(Long id) {
        repository.deleteById(id);
        return "Empleado con id(" + id + ") borrado correctamente";
    }


    public Employee obtainReference(Long id) {
        return repository.getReferenceById(id);
    }
}
