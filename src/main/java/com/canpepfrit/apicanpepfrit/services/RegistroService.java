package com.canpepfrit.apicanpepfrit.services;

import com.canpepfrit.apicanpepfrit.DTOS.RegistroActividadDTO;
import com.canpepfrit.apicanpepfrit.mappers.RegistroActividadMapper;
import com.canpepfrit.apicanpepfrit.models.RegistroActividad;
import com.canpepfrit.apicanpepfrit.repositories.RepoRegistroActividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroService {
    @Autowired
    private RepoRegistroActividad repositorio;
    @Autowired
    private RegistroActividadMapper mapper;

    public List<RegistroActividadDTO> findByAlojamientoId(Long id){
        List<RegistroActividad> exists = repositorio.findRegistroActividadByAlojamiento_Id(id);
        if(!exists.isEmpty()){
            return mapper.toDTOList(exists);
        }else{
            throw new RuntimeException("No hay ningun registro asociado al alojamiento con id: "+id);
        }
    }
}
