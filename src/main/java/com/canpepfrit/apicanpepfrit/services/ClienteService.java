package com.canpepfrit.apicanpepfrit.services;

import com.canpepfrit.apicanpepfrit.DTOS.ClienteDTO;
import com.canpepfrit.apicanpepfrit.DTOS.ClienteLightDTO;
import com.canpepfrit.apicanpepfrit.mappers.ClienteMapper;
import com.canpepfrit.apicanpepfrit.models.Alojamiento;
import com.canpepfrit.apicanpepfrit.models.Cliente;
import com.canpepfrit.apicanpepfrit.repositories.RepoCliente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final RepoCliente repositorio;
    private final ClienteMapper mapper;

    public ClienteService(RepoCliente repositorio, ClienteMapper mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    public List<ClienteDTO> findAll(){
        return mapper.toDTOList(repositorio.findAll());
    }

    public ClienteDTO findById(Long id){
        Optional<Cliente> exists = repositorio.findById(id);
        if(exists.isPresent()){
            Cliente c = exists.get();
            return mapper.toDTO(c);
        }else{
            throw new RuntimeException("No se ha econtrado cliente con id: "+id);
        }

    }

    public ClienteDTO addCliente(ClienteDTO dto){
        Cliente c = mapper.toEntity(dto);
        Cliente saved = repositorio.save(c);
        return mapper.toDTO(saved);
    }

    public ClienteDTO modifCliente(Long id,ClienteDTO dto){
        Optional<Cliente> exists = repositorio.findById(id);
        if(exists.isPresent()){
            Cliente c = exists.get();
            mapper.updateEntityFromDTO(dto,c);
            Cliente saved = repositorio.save(c);
            return mapper.toDTO(saved);
        } else{
            throw new RuntimeException("No se ha encontrado cliente con id: "+id);
        }

    }

    public String deleteClient(Long id){
        repositorio.deleteById(id);
        return "Cliente con id("+id+") borrado correctamente";
    }

    public Cliente obtainReference(Long id) {
        return repositorio.getReferenceById(id);
    }

}
