package com.canpepfrit.apicanpepfrit.services;

import com.canpepfrit.apicanpepfrit.DTOS.AlojamientoDTO;
import com.canpepfrit.apicanpepfrit.mappers.AlojamientoMapper;
import com.canpepfrit.apicanpepfrit.models.Alojamiento;
import com.canpepfrit.apicanpepfrit.repositories.RepoAlojamiento;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlojamientoService {

    private final RepoAlojamiento repositorio;

    private final AlojamientoMapper mapper;

    public AlojamientoService(RepoAlojamiento repositorio, AlojamientoMapper mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }


    public List<AlojamientoDTO> servAlojamientoList() {
        List<Alojamiento> alojamientos = repositorio.findAll();
        return mapper.toDTOList(alojamientos);
    }

    public AlojamientoDTO servFindById(Long id) {
        Optional<Alojamiento> exists = repositorio.findById(id);
        if (exists.isPresent()) {
            Alojamiento alojamiento = exists.get();
            return mapper.toDTO(alojamiento);
        } else {
            throw new RuntimeException("El alojamiento con id: " + id + "No existe");
        }
    }

    public AlojamientoDTO servAddAlojamiento(AlojamientoDTO alojamientoDTO) {
        Alojamiento alojamiento = mapper.toEntity(alojamientoDTO);
        Alojamiento addAlojamiento = repositorio.save(alojamiento);
        return mapper.toDTO(addAlojamiento);
    }

    public AlojamientoDTO servModifAlojamiento(Long id, AlojamientoDTO alojamientoDTO) {
        Optional<Alojamiento> exists = repositorio.findById(id);
        if (exists.isPresent()) {
            Alojamiento a = exists.get();
            mapper.updateEntityFromDTO(alojamientoDTO, a);
            Alojamiento modified = repositorio.save(a);
            return mapper.toDTO(modified);
        } else {
            throw new RuntimeException("No se ha encontrado ningun alojamiento con id: " + id);
        }

    }

    public String servDeletAlojamiento(Long id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return "Alojamiento eliminado correctamente";
        } else {
            return "El alojamiento con id: " + id + "no ha sido encontrado";
        }
    }

    public Alojamiento obtainReference(Long id) {
        return repositorio.getReferenceById(id);
    }

}
