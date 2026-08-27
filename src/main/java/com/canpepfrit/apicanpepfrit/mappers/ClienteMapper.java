package com.canpepfrit.apicanpepfrit.mappers;

import com.canpepfrit.apicanpepfrit.DTOS.AlojamientoDTO;
import com.canpepfrit.apicanpepfrit.DTOS.ClienteDTO;
import com.canpepfrit.apicanpepfrit.DTOS.ClienteLightDTO;
import com.canpepfrit.apicanpepfrit.models.Alojamiento;
import com.canpepfrit.apicanpepfrit.models.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteDTO toDTO(Cliente cliente);
    Cliente toEntity(ClienteDTO clienteDTO);
    ClienteLightDTO toLightDTO(Cliente cliente);
    List<ClienteDTO> toDTOList(List<Cliente> clientes);
    void updateEntityFromDTO(ClienteDTO dto, @MappingTarget Cliente entity);

}
