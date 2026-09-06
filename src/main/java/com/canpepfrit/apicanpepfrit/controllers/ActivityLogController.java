package com.canpepfrit.apicanpepfrit.controllers;

import com.canpepfrit.apicanpepfrit.DTOS.ActivityLogDTO;
import com.canpepfrit.apicanpepfrit.DTOS.ActivityLogRequestDTO;
import com.canpepfrit.apicanpepfrit.services.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activityLogs")
public class ActivityLogController {
    @Autowired
    private ActivityLogService service;

    @GetMapping
    public List<ActivityLogDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ActivityLogDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/alojamiento/{id}")
    public List<ActivityLogDTO> findByAlojamientoId(@PathVariable Long id) {
        return service.findByAccommodationId(id);
    }

    @PostMapping
    public ActivityLogDTO addLog(@RequestBody ActivityLogRequestDTO dto) {
        return service.addLog(dto);
    }

    @PutMapping("/{id}")
    public ActivityLogDTO alterLog(@PathVariable Long id, @RequestBody ActivityLogRequestDTO dto) {
        System.out.println(dto.getIdAccommodation());
        return service.alterLog(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteLog(@PathVariable Long id) {
        return service.deleteLog(id);
    }
}
