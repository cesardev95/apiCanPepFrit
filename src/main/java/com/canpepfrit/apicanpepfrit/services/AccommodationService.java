package com.canpepfrit.apicanpepfrit.services;

import com.canpepfrit.apicanpepfrit.DTOS.AccommodationDTO;
import com.canpepfrit.apicanpepfrit.mappers.AccommodationMapper;
import com.canpepfrit.apicanpepfrit.models.Accommodation;
import com.canpepfrit.apicanpepfrit.repositories.RepoAccommodation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationService {

    private final RepoAccommodation repository;

    private final AccommodationMapper mapper;

    public AccommodationService(RepoAccommodation repository, AccommodationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public List<AccommodationDTO> accommodations() {
        List<Accommodation> accommodations = repository.findAll();
        return mapper.toDTOList(accommodations);
    }

    public AccommodationDTO findById(Long id) {
        Optional<Accommodation> exists = repository.findById(id);
        if (exists.isPresent()) {
            Accommodation accommodation = exists.get();
            return mapper.toDTO(accommodation);
        } else {
            throw new RuntimeException("El alojamiento con id: " + id + "No existe");
        }
    }

    public AccommodationDTO addAccommodation(AccommodationDTO accommodationDTO) {
        Accommodation accommodation = mapper.toEntity(accommodationDTO);
        Accommodation addAccommodation = repository.save(accommodation);
        return mapper.toDTO(addAccommodation);
    }

    public AccommodationDTO alterAccommodation(Long id, AccommodationDTO accommodationDTO) {
        Optional<Accommodation> exists = repository.findById(id);
        if (exists.isPresent()) {
            Accommodation a = exists.get();
            mapper.updateEntityFromDTO(accommodationDTO, a);
            Accommodation modified = repository.save(a);
            return mapper.toDTO(modified);
        } else {
            throw new RuntimeException("No se ha encontrado ningun alojamiento con id: " + id);
        }

    }

    public String deleteAccommodation(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Alojamiento eliminado correctamente";
        } else {
            return "El alojamiento con id: " + id + "no ha sido encontrado";
        }
    }

    public Accommodation obtainReference(Long id) {
        return repository.getReferenceById(id);
    }

}
