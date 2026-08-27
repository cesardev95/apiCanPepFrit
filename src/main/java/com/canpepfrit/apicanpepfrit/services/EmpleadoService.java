package com.canpepfrit.apicanpepfrit.services;

import com.canpepfrit.apicanpepfrit.DTOS.EmpleadoDTO;
import com.canpepfrit.apicanpepfrit.mappers.EmpleadoMapper;
import com.canpepfrit.apicanpepfrit.models.Empleado;
import com.canpepfrit.apicanpepfrit.repositories.RepoEmpleado;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {
    private final RepoEmpleado repositorio;
    private final EmpleadoMapper mapper;

    public EmpleadoService(RepoEmpleado repositorio, EmpleadoMapper mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    public List<EmpleadoDTO> findAll(){
        return mapper.toDTOList(repositorio.findAll());
    }

    public EmpleadoDTO findById(Long id){
        Optional<Empleado> exists = repositorio.findById(id);
        if(exists.isPresent()){
            Empleado e = exists.get();
            return mapper.toDTO(e);
        }else {
            throw new RuntimeException("No hay empleado con id: "+id);
        }
    }

    public EmpleadoDTO addEmpleado(EmpleadoDTO dto){
        Empleado e = mapper.toEntity(dto);
        Empleado saved = repositorio.save(e);
        return mapper.toDTO(saved);
    }

    public EmpleadoDTO modifEmpleado(Long id,EmpleadoDTO dto){
        Optional<Empleado> exists = repositorio.findById(id);
        if(exists.isPresent()){
            Empleado e = exists.get();
           mapper.updateEntityFromDTO(dto,e);
           Empleado saved = repositorio.save(e);
           return mapper.toDTO(saved);

        }else {
            throw new RuntimeException("No se ha encontrado empleado con id: "+id);
        }
    }

    public String deleteEmpleado(Long id){
        repositorio.deleteById(id);
        return "Empleado con id("+id+") borrado correctamente";
    }


    public Empleado obtainReference(Long id) {
        return repositorio.getReferenceById(id);
    }
}
