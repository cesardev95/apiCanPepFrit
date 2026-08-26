package com.canpepfrit.apicanpepfrit.mappers;

import com.canpepfrit.apicanpepfrit.DTOS.ClienteDTO;
import com.canpepfrit.apicanpepfrit.models.Cliente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteDTO toDTO(Cliente cliente);
    Cliente toEntity(ClienteDTO clienteDTO);
    List<ClienteDTO> toDTOList(List<Cliente> clientes);
}
