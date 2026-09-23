package com.canpepfrit.apicanpepfrit.services;

import com.canpepfrit.apicanpepfrit.DTOS.BookingDTO;
import com.canpepfrit.apicanpepfrit.DTOS.BookingRequestDTO;
import com.canpepfrit.apicanpepfrit.mappers.BookingMapper;
import com.canpepfrit.apicanpepfrit.models.Booking;
import com.canpepfrit.apicanpepfrit.models.Client;
import com.canpepfrit.apicanpepfrit.repositories.RepoBooking;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final RepoBooking repository;

    private final BookingMapper mapper;
    private final ClientService clientService;
    private final AccommodationService accommodationService;

    public BookingService(RepoBooking repository, BookingMapper mapper, ClientService clientService, AccommodationService accommodationService) {
        this.repository = repository;
        this.mapper = mapper;
        this.clientService = clientService;
        this.accommodationService = accommodationService;
    }


    public List<BookingDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }

    public BookingDTO findById(Long id) {
        Optional<Booking> exists = repository.findById(id);
        if (exists.isPresent()) {
            Booking booking = exists.get();
            return mapper.toDTO(booking);
        } else {
            throw new RuntimeException("No se ha encontrado ningun registro con id :" + id);
        }
    }

    public List<BookingDTO> findBookingByMonth(LocalDate primerDiaMes, LocalDate ultimoDiaMes) {
        return mapper.toDTOList(repository.findBookingByDate(primerDiaMes, ultimoDiaMes));
    }

    public List<BookingDTO> findBookingByClientName(String cliente) {
        return mapper.toDTOList(repository.findBookingByClientName(cliente));
    }

    public List<BookingDTO> findBookingByInitDate(LocalDate fecha) {
        return mapper
                .toDTOList(repository.findBookingByStartDate(fecha));
    }

    public List<BookingDTO> findDinamic(LocalDate primerDiaMes, LocalDate ultimoDiaMes, String cliente, LocalDate fecha) {
        if (primerDiaMes != null && ultimoDiaMes != null) {
            return this.findBookingByMonth(primerDiaMes, ultimoDiaMes);
        }
        if (cliente != null) {
            return this.findBookingByClientName(cliente);
        }
        if (fecha != null) {
            return this.findBookingByInitDate(fecha);
        }
        return null;
    }

    public BookingDTO addBooking(BookingRequestDTO dto) {
        Booking booking = mapper.toEntity(dto);
        booking.setClient(clientService.obtainReference(dto.getIdClient()));
        booking.setAccommodation(accommodationService.obtainReference(dto.getIdAccommodation()));

        Booking saved = repository.save(booking);
        return mapper.toDTO(saved);
    }

    public BookingDTO alterBooking(Long id, BookingRequestDTO dto) {
        Optional<Booking> exists = repository.findById(id);
        if (exists.isPresent()) {
            Booking booking = exists.get();
            mapper.updateEntityFromRequest(dto,booking);
            booking.setClient(clientService.obtainReference(dto.getIdClient()));
            booking.setAccommodation(accommodationService.obtainReference(dto.getIdAccommodation()));

            Booking modified = repository.save(booking);
            return mapper.toDTO(modified);
        } else {
            throw new RuntimeException("No se ha encontrado registro con id: " + id);
        }
    }

    public String deleteBooking(Long id) {
        repository.deleteById(id);
        return "El registro con id: " + id + " se ha borrado correctamente";
    }

    public Booking obtainReference(Long id) {
        return repository.getReferenceById(id);
    }


}
