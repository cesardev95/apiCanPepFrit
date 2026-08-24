package com.canpepfrit.apicanpepfrit.controllers;

import com.canpepfrit.apicanpepfrit.DTOS.AlojamientoDTO;
import com.canpepfrit.apicanpepfrit.services.AlojamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
