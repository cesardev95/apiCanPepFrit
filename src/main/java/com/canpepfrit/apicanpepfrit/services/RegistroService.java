package com.canpepfrit.apicanpepfrit.services;

import com.canpepfrit.apicanpepfrit.DTOS.RegistroActividadDTO;
import com.canpepfrit.apicanpepfrit.DTOS.RegistroActividadRequestDTO;
import com.canpepfrit.apicanpepfrit.mappers.RegistroActividadMapper;
import com.canpepfrit.apicanpepfrit.models.RegistroActividad;
import com.canpepfrit.apicanpepfrit.repositories.RepoRegistroActividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroService {
    @Autowired
    private RepoRegistroActividad repositorio;
    @Autowired
    private RegistroActividadMapper mapper;

    public List<RegistroActividadDTO> servFindAll(){
        List<RegistroActividad> registros = repositorio.findAll();
        return mapper.toDTOList(registros);
    }

    public RegistroActividadDTO servFindById(Long id){
        Optional<RegistroActividad> exists = repositorio.findById(id);
        if(exists.isPresent()){
            RegistroActividad r = exists.get();
            return mapper.toDTO(r);
        } else{
            throw new RuntimeException("No se ha encontrado ningun registro con id: "+id);
        }
    }

    public RegistroActividadDTO servAddRegistro(RegistroActividadRequestDTO dto){
        System.out.println(dto.getIdAlojamiento());
        RegistroActividad registro = mapper.toEntity(dto);
        repositorio.save(registro);
        return mapper.toDTO(registro);
    }

    public RegistroActividadDTO servModifRegistro(Long id, RegistroActividadRequestDTO dto){
        Optional<RegistroActividad> exists = repositorio.findById(id);
        if(exists.isPresent()){
            RegistroActividad r = exists.get();
            mapper.updateEntityFromDTO(dto,r);
            RegistroActividad modified = repositorio.save(r);
            return mapper.toDTO(modified);
        } else{
            throw new RuntimeException("No se ha encontrado ningun registro con id: "+id);
        }
    }

    public List<RegistroActividadDTO> servFindByAlojamientoId(Long id){
        List<RegistroActividad> exists = repositorio.findRegistroActividadByAlojamiento_Id(id);
        if(!exists.isEmpty()){
            return mapper.toDTOList(exists);
        }else{
            throw new RuntimeException("No hay ningun registro asociado al alojamiento con id: "+id);
        }
    }

    public String servDeleteRegistro(Long id){
       if(repositorio.existsById(id)){
           repositorio.deleteById(id);
           return "Registro borrado correctamente";
       }else{
           return "Registro con id: "+id+" no encontrado";
       }
    }
}
