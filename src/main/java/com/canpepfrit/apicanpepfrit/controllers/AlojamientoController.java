package com.canpepfrit.apicanpepfrit.controllers;

import com.canpepfrit.apicanpepfrit.DTOS.AlojamientoDTO;
import com.canpepfrit.apicanpepfrit.services.AlojamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alojamientos")
public class AlojamientoController {
    @Autowired
    private AlojamientoService service;
    @GetMapping
    public List<AlojamientoDTO> findAll(){
        return  service.servAlojamientoList();
    }
    @GetMapping("/{id}")
    public AlojamientoDTO findById(@PathVariable Long id){
        return service.servFindById(id);
    }
    @PostMapping
    public AlojamientoDTO addAlojamiento(@RequestBody AlojamientoDTO dto){
        return service.servAddAlojamiento(dto);
    }
    @PutMapping("/{id}")
    public AlojamientoDTO modifAlojamiento(@PathVariable Long id, @RequestBody AlojamientoDTO dto){
        return service.servModifAlojamiento(id,dto);
    }
    @DeleteMapping("/{id}")
    public String deleteAlojamiento(@PathVariable Long id){
        return service.servDeletAlojamiento(id);
    }

}
