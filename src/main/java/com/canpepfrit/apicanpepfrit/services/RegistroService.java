package com.canpepfrit.apicanpepfrit.services;

import com.canpepfrit.apicanpepfrit.DTOS.RegistroActividadDTO;
import com.canpepfrit.apicanpepfrit.DTOS.RegistroActividadRequestDTO;
import com.canpepfrit.apicanpepfrit.mappers.RegistroActividadMapper;
import com.canpepfrit.apicanpepfrit.models.RegistroActividad;
import com.canpepfrit.apicanpepfrit.repositories.RepoRegistroActividad;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroService {

    private final RepoRegistroActividad repositorio;
    private final RegistroActividadMapper mapper;

    private final AlojamientoService alojamientoService;
    private final EmpleadoService empleadoService;

    public RegistroService(RepoRegistroActividad repositorio, RegistroActividadMapper mapper, AlojamientoService alojamientoService, EmpleadoService empleadoService) {
        this.repositorio = repositorio;
        this.mapper = mapper;
        this.alojamientoService = alojamientoService;
        this.empleadoService = empleadoService;
    }


    public List<RegistroActividadDTO> servFindAll() {
        List<RegistroActividad> registros = repositorio.findAll();
        return mapper.toDTOList(registros);
    }

    public RegistroActividadDTO servFindById(Long id) {
        Optional<RegistroActividad> exists = repositorio.findById(id);
        if (exists.isPresent()) {
            RegistroActividad r = exists.get();
            return mapper.toDTO(r);
        } else {
            throw new RuntimeException("No se ha encontrado ningun registro con id: " + id);
        }
    }

    public RegistroActividadDTO servAddRegistro(RegistroActividadRequestDTO dto) {
        RegistroActividad registro = mapper.toEntity(dto);
        registro.setAlojamiento(alojamientoService.obtainReference(dto.getIdAlojamiento()));
        registro.setEmpleado(empleadoService.obtainReference(dto.getIdEmpleado()));

        RegistroActividad saved = repositorio.save(registro);
        return mapper.toDTO(saved);
    }

    public RegistroActividadDTO servModifRegistro(Long id, RegistroActividadRequestDTO dto) {
        Optional<RegistroActividad> exists = repositorio.findById(id);
        if (exists.isPresent()) {
            RegistroActividad r = exists.get();
            mapper.updateEntityFromDTO(dto, r);
            r.setAlojamiento(alojamientoService.obtainReference(dto.getIdAlojamiento()));
            r.setEmpleado(empleadoService.obtainReference(dto.getIdEmpleado()));

            RegistroActividad modified = repositorio.save(r);
            return mapper.toDTO(modified);
        } else {
            throw new RuntimeException("No se ha encontrado ningun registro con id: " + id);
        }
    }

    public List<RegistroActividadDTO> servFindByAlojamientoId(Long id) {
        List<RegistroActividad> registros = repositorio.findRegistroActividadByAlojamiento_Id(id);
        return mapper.toDTOList(registros);
    }

    public String servDeleteRegistro(Long id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return "Registro borrado correctamente";
        } else {
            return "Registro con id: " + id + " no encontrado";
        }
    }
}
