package com.canpepfrit.apicanpepfrit.controllers;

import com.canpepfrit.apicanpepfrit.DTOS.PaymentDTO;
import com.canpepfrit.apicanpepfrit.DTOS.PaymentRequestDTO;
import com.canpepfrit.apicanpepfrit.services.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @GetMapping
    public List<PaymentDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PaymentDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public PaymentDTO addPayment(@RequestBody PaymentRequestDTO dto){
        System.out.println(dto.getIdBooking());
        return service.addPayment(dto);
    }

    @PutMapping("/{id}")
    public PaymentDTO alterPayment(@PathVariable Long id,@RequestBody PaymentRequestDTO dto){
        return service.alterPayment(id,dto);
    }

    @DeleteMapping("/{id}")
    public String deletePayment(@PathVariable Long id){
        return service.deletePayment(id);
    }
}
