package com.canpepfrit.apicanpepfrit.controllers;

import com.canpepfrit.apicanpepfrit.DTOS.ClientDTO;
import com.canpepfrit.apicanpepfrit.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public List<ClientDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ClientDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ClientDTO addCliente(@RequestBody ClientDTO dto) {
        return service.addClient(dto);
    }

    @PutMapping("/{id}")
    public ClientDTO modifCliente(@PathVariable Long id, ClientDTO dto) {
        return service.alterClient(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable Long id) {
        return service.deleteClient(id);
    }
}
