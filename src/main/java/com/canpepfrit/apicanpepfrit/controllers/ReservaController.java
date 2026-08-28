package com.canpepfrit.apicanpepfrit.controllers;

import com.canpepfrit.apicanpepfrit.DTOS.ReservaDTO;
import com.canpepfrit.apicanpepfrit.DTOS.ReservaRequestDTO;
import com.canpepfrit.apicanpepfrit.services.ReservaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {
    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @GetMapping
    public List<ReservaDTO> findAll(){
        return service.servFindAll();
    }
   @GetMapping("/{id}")
    public ReservaDTO findById(@PathVariable Long id){
        return service.servFindById(id);
   }

   @GetMapping("/find")

   public List<ReservaDTO> findReservas(
           @RequestParam(name = "primerDiaMes",required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate primerDiaMes,
           @RequestParam(name="ultimoDiaMes",required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate ultimoDiaMes,
           @RequestParam(name = "cliente",required = false) String cliente,
           @RequestParam(name="fecha",required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha){
        return service.findDinamic(primerDiaMes, ultimoDiaMes, cliente, fecha);
   }

   @PostMapping
    public ReservaDTO addReserva(@RequestBody ReservaRequestDTO dto){
       return service.servAddRegistro(dto);
   }

   @PutMapping("/{id}")
    public ReservaDTO modifReserva(@PathVariable Long id,@RequestBody ReservaRequestDTO dto){
        return service.servModifRegistro(id,dto);
   }

   @DeleteMapping("/{id}")
    public String deleteReserva(@PathVariable Long id){
        return service.servDeleteRegistro(id);
   }
}
