package com.canpepfrit.apicanpepfrit.controllers;

import com.canpepfrit.apicanpepfrit.DTOS.RegistroActividadDTO;
import com.canpepfrit.apicanpepfrit.DTOS.RegistroActividadRequestDTO;
import com.canpepfrit.apicanpepfrit.services.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registros")
public class RegistroActividadController {
    @Autowired
    private RegistroService service;

    @GetMapping
    public List<RegistroActividadDTO> findAll() {
        return service.servFindAll();
    }

    @GetMapping("/{id}")
    public RegistroActividadDTO findById(@PathVariable Long id) {
        return service.servFindById(id);
    }

    @GetMapping("/alojamiento/{id}")
    public List<RegistroActividadDTO> findByAlojamientoId(@PathVariable Long id){
        return service.servFindByAlojamientoId(id);
    }

    @PostMapping
    public RegistroActividadDTO addRegistro(@RequestBody RegistroActividadRequestDTO dto) {
        return service.servAddRegistro(dto);
    }

    @PutMapping("/{id}")
    public RegistroActividadDTO modifRegistro(@PathVariable Long id, @RequestBody RegistroActividadRequestDTO dto) {
        System.out.println(dto.getIdAlojamiento());
        return service.servModifRegistro(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteRegistro(@PathVariable Long id) {
        return service.servDeleteRegistro(id);
    }
}
