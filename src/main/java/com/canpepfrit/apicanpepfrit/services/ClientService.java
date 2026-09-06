package com.canpepfrit.apicanpepfrit.services;

import com.canpepfrit.apicanpepfrit.DTOS.ClientDTO;
import com.canpepfrit.apicanpepfrit.mappers.ClientMapper;
import com.canpepfrit.apicanpepfrit.models.Client;
import com.canpepfrit.apicanpepfrit.repositories.RepoClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final RepoClient repository;
    private final ClientMapper mapper;

    public ClientService(RepoClient repository, ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ClientDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }

    public ClientDTO findById(Long id) {
        Optional<Client> exists = repository.findById(id);
        if (exists.isPresent()) {
            Client c = exists.get();
            return mapper.toDTO(c);
        } else {
            throw new RuntimeException("No se ha econtrado cliente con id: " + id);
        }

    }

    public ClientDTO addClient(ClientDTO dto) {
        Client c = mapper.toEntity(dto);
        Client saved = repository.save(c);
        return mapper.toDTO(saved);
    }

    public ClientDTO alterClient(Long id, ClientDTO dto) {
        Optional<Client> exists = repository.findById(id);
        if (exists.isPresent()) {
            Client c = exists.get();
            mapper.updateEntityFromDTO(dto, c);
            Client saved = repository.save(c);
            return mapper.toDTO(saved);
        } else {
            throw new RuntimeException("No se ha encontrado cliente con id: " + id);
        }

    }

    public String deleteClient(Long id) {
        repository.deleteById(id);
        return "Cliente con id(" + id + ") borrado correctamente";
    }

    public Client obtainReference(Long id) {
        return repository.getReferenceById(id);
    }

}
