package com.canpepfrit.apicanpepfrit.services;

import com.canpepfrit.apicanpepfrit.mappers.EmpleadoMapper;
import com.canpepfrit.apicanpepfrit.models.Empleado;
import com.canpepfrit.apicanpepfrit.repositories.RepoEmpleado;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {
    private final RepoEmpleado repositorio;
    private final EmpleadoMapper mapper;

    public EmpleadoService(RepoEmpleado repositorio, EmpleadoMapper mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }


    public Empleado obtainReference(Long id) {
        return repositorio.getReferenceById(id);
    }
}
