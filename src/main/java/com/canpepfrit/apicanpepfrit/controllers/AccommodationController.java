package com.canpepfrit.apicanpepfrit.controllers;

import com.canpepfrit.apicanpepfrit.DTOS.AccommodationDTO;
import com.canpepfrit.apicanpepfrit.services.AccommodationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
public class AccommodationController {
    private final AccommodationService service;

    public AccommodationController(AccommodationService service) {
        this.service = service;
    }

    @GetMapping
    public List<AccommodationDTO> findAll() {
        return service.accommodations();
    }

    @GetMapping("/{id}")
    public AccommodationDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public AccommodationDTO addAccommodation(@RequestBody AccommodationDTO dto) {
        return service.addAccommodation(dto);
    }

    @PutMapping("/{id}")
    public AccommodationDTO alterAccommodation(@PathVariable Long id, @RequestBody AccommodationDTO dto) {
        return service.alterAccommodation(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteAccommodation(@PathVariable Long id) {
        return service.deleteAccommodation(id);
    }

}
