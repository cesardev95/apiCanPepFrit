package com.canpepfrit.apicanpepfrit.mappers;

import com.canpepfrit.apicanpepfrit.DTOS.BookingDTO;
import com.canpepfrit.apicanpepfrit.DTOS.BookingRequestDTO;
import com.canpepfrit.apicanpepfrit.models.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    BookingDTO toDTO(Booking booking);

    Booking toEntityFromDTO(BookingDTO bookingDTO);

    List<BookingDTO> toDTOList(List<Booking> bookings);

    List<Booking> toEntityList(List<BookingDTO> bookingDTOS);

    List<Booking> toEntityListFromRequest(List<BookingRequestDTO> dtos);

    @Mapping(target = "client", ignore = true)
    @Mapping(target = "accommodation", ignore = true)
    Booking toEntity(BookingRequestDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "client", ignore = true)
    @Mapping(target = "accommodation", ignore = true)
    Booking updateEntityFromRequest(BookingRequestDTO dto, @MappingTarget Booking entity);


}
