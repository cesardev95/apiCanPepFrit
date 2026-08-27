package com.canpepfrit.apicanpepfrit.controllers;

import com.canpepfrit.apicanpepfrit.DTOS.EmpleadoDTO;
import com.canpepfrit.apicanpepfrit.services.EmpleadoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
    private final EmpleadoService service;

    public EmpleadoController(EmpleadoService service) {
        this.service = service;
    }
    @GetMapping
    public List<EmpleadoDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EmpleadoDTO findByid(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public EmpleadoDTO addEmpleado(@RequestBody EmpleadoDTO dto){
        return service.addEmpleado(dto);
    }

    @PutMapping("/{id}")
    public EmpleadoDTO modifEmpleado(@PathVariable Long id,@RequestBody EmpleadoDTO dto){
        return service.modifEmpleado(id,dto);
    }

    @DeleteMapping("/{id}")
    public String deleteEmpleado(@PathVariable Long id){
        return service.deleteEmpleado(id);
    }
}
