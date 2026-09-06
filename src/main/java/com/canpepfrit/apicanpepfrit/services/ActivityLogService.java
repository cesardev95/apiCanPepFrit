package com.canpepfrit.apicanpepfrit.services;

import com.canpepfrit.apicanpepfrit.DTOS.ActivityLogDTO;
import com.canpepfrit.apicanpepfrit.DTOS.ActivityLogRequestDTO;
import com.canpepfrit.apicanpepfrit.mappers.ActivityLogMapper;
import com.canpepfrit.apicanpepfrit.models.ActivityLog;
import com.canpepfrit.apicanpepfrit.repositories.RepoActivityLog;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityLogService {

    private final RepoActivityLog repository;
    private final ActivityLogMapper mapper;

    private final AccommodationService accommodationService;
    private final EmployeeService employeeService;

    public ActivityLogService(RepoActivityLog repository, ActivityLogMapper mapper, AccommodationService accommodationService, EmployeeService employeeService) {
        this.repository = repository;
        this.mapper = mapper;
        this.accommodationService = accommodationService;
        this.employeeService = employeeService;
    }


    public List<ActivityLogDTO> findAll() {
        List<ActivityLog> registros = repository.findAll();
        return mapper.toDTOList(registros);
    }

    public ActivityLogDTO findById(Long id) {
        Optional<ActivityLog> exists = repository.findById(id);
        if (exists.isPresent()) {
            ActivityLog log = exists.get();
            return mapper.toDTO(log);
        } else {
            throw new RuntimeException("No se ha encontrado ningun registro con id: " + id);
        }
    }

    public ActivityLogDTO addLog(ActivityLogRequestDTO dto) {
        ActivityLog registro = mapper.toEntity(dto);
        registro.setAccommodation(accommodationService.obtainReference(dto.getIdAccommodation()));
        registro.setEmployee(employeeService.obtainReference(dto.getIdEmployee()));

        ActivityLog saved = repository.save(registro);
        return mapper.toDTO(saved);
    }

    public ActivityLogDTO alterLog(Long id, ActivityLogRequestDTO dto) {
        Optional<ActivityLog> exists = repository.findById(id);
        if (exists.isPresent()) {
            ActivityLog log = exists.get();
            mapper.updateEntityFromDTO(dto, log);
            log.setAccommodation(accommodationService.obtainReference(dto.getIdAccommodation()));
            log.setEmployee(employeeService.obtainReference(dto.getIdEmployee()));

            ActivityLog modified = repository.save(log);
            return mapper.toDTO(modified);
        } else {
            throw new RuntimeException("No se ha encontrado ningun registro con id: " + id);
        }
    }

    public List<ActivityLogDTO> findByAccommodationId(Long id) {
        List<ActivityLog> logs = repository.findActivityLogByAccommodation(id);
        return mapper.toDTOList(logs);
    }

    public String deleteLog(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Registro borrado correctamente";
        } else {
            return "Registro con id: " + id + " no encontrado";
        }
    }
}
