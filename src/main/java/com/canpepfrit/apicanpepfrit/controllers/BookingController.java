package com.canpepfrit.apicanpepfrit.controllers;

import com.canpepfrit.apicanpepfrit.DTOS.BookingDTO;
import com.canpepfrit.apicanpepfrit.DTOS.BookingRequestDTO;
import com.canpepfrit.apicanpepfrit.services.BookingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @GetMapping
    public List<BookingDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public BookingDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/find")

    public List<BookingDTO> findBooking(
            @RequestParam(name = "primerDiaMes", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate primerDiaMes,
            @RequestParam(name = "ultimoDiaMes", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate ultimoDiaMes,
            @RequestParam(name = "cliente", required = false) String cliente,
            @RequestParam(name = "fecha", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return service.findDinamic(primerDiaMes, ultimoDiaMes, cliente, fecha);
    }

    @PostMapping
    public BookingDTO addBooking(@RequestBody BookingRequestDTO dto) {
        return service.addBooking(dto);
    }

    @PutMapping("/{id}")
    public BookingDTO alterBooking(@PathVariable Long id, @RequestBody BookingRequestDTO dto) {
        return service.alterBooking(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable Long id) {
        return service.deleteBooking(id);
    }
}
