package com.canpepfrit.apicanpepfrit.mappers;

import com.canpepfrit.apicanpepfrit.DTOS.ClientDTO;
import com.canpepfrit.apicanpepfrit.DTOS.ClientLightDTO;
import com.canpepfrit.apicanpepfrit.models.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDTO toDTO(Client client);

    Client toEntity(ClientDTO clientDTO);

    ClientLightDTO toLightDTO(Client client);

    List<ClientDTO> toDTOList(List<Client> clients);

    void updateEntityFromDTO(ClientDTO dto, @MappingTarget Client entity);

}
