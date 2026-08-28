package com.canpepfrit.apicanpepfrit.services;

import com.canpepfrit.apicanpepfrit.DTOS.ReservaDTO;
import com.canpepfrit.apicanpepfrit.DTOS.ReservaRequestDTO;
import com.canpepfrit.apicanpepfrit.mappers.ReservaMapper;
import com.canpepfrit.apicanpepfrit.models.Reserva;
import com.canpepfrit.apicanpepfrit.repositories.RepoReserva;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private final RepoReserva repositorio;

    private final ReservaMapper mapper;
    private final ClienteService clienteService;
    private final AlojamientoService alojamientoService;

    public ReservaService(RepoReserva repositorio, ReservaMapper mapper, ClienteService clienteService, AlojamientoService alojamientoService) {
        this.repositorio = repositorio;
        this.mapper = mapper;
        this.clienteService = clienteService;
        this.alojamientoService = alojamientoService;
    }


    public List<ReservaDTO> servFindAll() {
        return mapper.toDTOList(repositorio.findAll());
    }

    public ReservaDTO servFindById(Long id) {
        Optional<Reserva> exists = repositorio.findById(id);
        if (exists.isPresent()) {
            Reserva r = exists.get();
            return mapper.toDTO(r);
        } else {
            throw new RuntimeException("No se ha encontrado ningun registro con id :" + id);
        }
    }

    public List<ReservaDTO> findReservaByMonth(LocalDate primerDiaMes, LocalDate ultimoDiaMes){
        return mapper.toDTOList(repositorio.findReservaByDate(primerDiaMes,ultimoDiaMes));
    }

    public List<ReservaDTO> findReservaByClientName(String cliente){
        return mapper.toDTOList(repositorio.findReservaByCliente_Nombre(cliente));
    }

    public List<ReservaDTO> findReservaByInitDate(LocalDate fecha){
        return mapper
                .toDTOList(repositorio.findReservaByFechaInicio(fecha));
    }

    public List<ReservaDTO> findDinamic(LocalDate primerDiaMes,LocalDate ultimoDiaMes,String cliente,LocalDate fecha){
        if (primerDiaMes!=null && ultimoDiaMes !=null){
            return this.findReservaByMonth(primerDiaMes, ultimoDiaMes);
        }
        if(cliente!=null){
            return this.findReservaByClientName(cliente);
        }
        if(fecha!=null){
            return this.findReservaByInitDate(fecha);
        }
        return null;
    }

    public ReservaDTO servAddRegistro(ReservaRequestDTO dto){
        Reserva reserva = mapper.toEntity(dto);
        reserva.setCliente(clienteService.obtainReference(dto.getIdCliente()));
        reserva.setAlojamiento(alojamientoService.obtainReference(dto.getIdAlojamiento()));

        Reserva saved = repositorio.save(reserva);
         return mapper.toDTO(saved);
    }

    public ReservaDTO servModifRegistro(Long id,ReservaRequestDTO dto){
        Optional<Reserva> exists = repositorio.findById(id);
        if(exists.isPresent()){
            Reserva r = exists.get();
            mapper.toDTO(r);
            r.setCliente(clienteService.obtainReference(dto.getIdCliente()));
            r.setAlojamiento(alojamientoService.obtainReference(dto.getIdAlojamiento()));

            Reserva modified = repositorio.save(r);
            return mapper.toDTO(modified);
        } else{
            throw new RuntimeException("No se ha encontrado registro con id: "+id);
        }
    }

    public String servDeleteRegistro(Long id){
        repositorio.deleteById(id);
        return "El registro con id: "+id+" se ha borrado correctamente";
    }


}
