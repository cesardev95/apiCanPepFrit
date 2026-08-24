package com.canpepfrit.apicanpepfrit.services;

import com.canpepfrit.apicanpepfrit.DTOS.AlojamientoDTO;
import com.canpepfrit.apicanpepfrit.DTOS.RegistroActividadDTO;
import com.canpepfrit.apicanpepfrit.DTOS.ReservaDTO;
import com.canpepfrit.apicanpepfrit.mappers.AlojamientoMapper;
import com.canpepfrit.apicanpepfrit.mappers.RegistroActividadMapper;
import com.canpepfrit.apicanpepfrit.mappers.ReservaMapper;
import com.canpepfrit.apicanpepfrit.models.Alojamiento;
import com.canpepfrit.apicanpepfrit.models.RegistroActividad;
import com.canpepfrit.apicanpepfrit.models.Reserva;
import com.canpepfrit.apicanpepfrit.repositories.RepoAlojamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlojamientoService {
    @Autowired
    private RepoAlojamiento repositorio;
    @Autowired
    private AlojamientoMapper mapper;
    @Autowired
    private ReservaMapper reservaMapper;
    @Autowired
    private RegistroActividadMapper registroMapper;

    public List<AlojamientoDTO> servAlojamientoList(){
        List<Alojamiento> alojamientos = repositorio.findAll();
        return mapper.toDTOList(alojamientos);
    }

    public AlojamientoDTO servFindById(Long id){
        Optional<Alojamiento> exists = repositorio.findById(id);
        if(exists.isPresent()){
            Alojamiento alojamiento = exists.get();
            return mapper.toDTO(alojamiento);
        }else{
            throw new RuntimeException("El alojamiento con id: "+id+"No existe");
        }
    }

    public AlojamientoDTO servAddAlojamiento(AlojamientoDTO alojamientoDTO){
        Alojamiento alojamiento = mapper.toEntity(alojamientoDTO);
        Alojamiento addAlojamiento = repositorio.save(alojamiento);
        return mapper.toDTO(addAlojamiento);
    }

    public AlojamientoDTO servModifAlojamiento(Long id,AlojamientoDTO alojamientoDTO){
        Optional<Alojamiento> exists = repositorio.findById(id);
        if(exists.isPresent()){
            Alojamiento a = exists.get();
            a.setDireccion(alojamientoDTO.getDireccion());
            a.setNombre(alojamientoDTO.getNombre());
            a.setTelefono(alojamientoDTO.getTelefono());
            List<ReservaDTO> reservasDTO = alojamientoDTO.getReservas();
            List<Reserva> reservas = reservaMapper.toEntityList(reservasDTO);
            a.setReservas(reservas);
            List<RegistroActividadDTO> registrosDTO = alojamientoDTO.getRegistros();
            List<RegistroActividad> registros = registroMapper.toEntityList(registrosDTO);
            a.setRegistros(registros);
            Alojamiento modificado = repositorio.save(a);
            return mapper.toDTO(modificado);
        } else{
            throw new RuntimeException("No se ha encontrado ningun alojamiento con el id: "+id);
        }
    }
    public String servDeletAlojamiento(Long id){
        if(repositorio.existsById(id)){
            repositorio.deleteById(id);
            return "Alojamiento eliminado correctamente";
        }else{
            return "El alojamiento con id: "+id+"no ha sido encontrado";
        }
    }

}
