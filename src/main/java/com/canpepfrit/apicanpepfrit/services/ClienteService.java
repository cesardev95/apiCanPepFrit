package com.canpepfrit.apicanpepfrit.services;

import com.canpepfrit.apicanpepfrit.mappers.ClienteMapper;
import com.canpepfrit.apicanpepfrit.models.Alojamiento;
import com.canpepfrit.apicanpepfrit.models.Cliente;
import com.canpepfrit.apicanpepfrit.repositories.RepoCliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final RepoCliente repositorio;
    private final ClienteMapper mapper;

    public ClienteService(RepoCliente repositorio, ClienteMapper mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    public Cliente obtainReference(Long id) {
        return repositorio.getReferenceById(id);
    }

}
