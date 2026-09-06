package com.canpepfrit.apicanpepfrit.controllers;

import com.canpepfrit.apicanpepfrit.DTOS.EmployeeDTO;
import com.canpepfrit.apicanpepfrit.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<EmployeeDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EmployeeDTO findByid(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO dto) {
        return service.addEmployee(dto);
    }

    @PutMapping("/{id}")
    public EmployeeDTO alterEmployee(@PathVariable Long id, @RequestBody EmployeeDTO dto) {
        return service.alterEmployee(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return service.deleteEmployee(id);
    }
}
