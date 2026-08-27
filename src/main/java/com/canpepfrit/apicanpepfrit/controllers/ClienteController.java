package com.canpepfrit.apicanpepfrit.controllers;

import com.canpepfrit.apicanpepfrit.DTOS.ClienteDTO;
import com.canpepfrit.apicanpepfrit.services.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<ClienteDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ClienteDTO findById(@PathVariable Long id){
        return service.findById(id);
    }
    @PostMapping
    public ClienteDTO addCliente(@RequestBody ClienteDTO dto){
       return service.addCliente(dto);
    }
    @PutMapping("/{id}")
    public ClienteDTO modifCliente(@PathVariable Long id, ClienteDTO dto){
        return service.modifCliente(id,dto);
    }

    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable Long id){
        return service.deleteClient(id);
    }
}
