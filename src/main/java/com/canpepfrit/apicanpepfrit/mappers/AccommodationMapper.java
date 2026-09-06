package com.canpepfrit.apicanpepfrit.mappers;

import com.canpepfrit.apicanpepfrit.DTOS.AccommodationDTO;
import com.canpepfrit.apicanpepfrit.DTOS.AccommodationLightDTO;
import com.canpepfrit.apicanpepfrit.models.Accommodation;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BookingMapper.class, ActivityLogMapper.class})
public interface AccommodationMapper {
    AccommodationDTO toDTO(Accommodation accommodation);

    Accommodation toEntity(AccommodationDTO accommodationDTO);

    AccommodationLightDTO toLightDTO(Accommodation accommodation);

    List<AccommodationDTO> toDTOList(List<Accommodation> accommodations);

    void updateEntityFromDTO(AccommodationDTO dto, @MappingTarget Accommodation entity);
}
