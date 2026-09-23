package com.canpepfrit.apicanpepfrit.services;

import com.canpepfrit.apicanpepfrit.DTOS.PaymentDTO;
import com.canpepfrit.apicanpepfrit.DTOS.PaymentRequestDTO;
import com.canpepfrit.apicanpepfrit.mappers.PaymentMapper;
import com.canpepfrit.apicanpepfrit.models.Payment;
import com.canpepfrit.apicanpepfrit.repositories.RepoPayment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    private final RepoPayment repository;
    private final PaymentMapper mapper;

    private final BookingService bookingService;

    public PaymentService(RepoPayment repository, PaymentMapper mapper, BookingService bookingService) {
        this.repository = repository;
        this.mapper = mapper;
        this.bookingService = bookingService;
    }

    public List<PaymentDTO> findAll(){
        return mapper.toDTOList(repository.findAll());
    }

    public PaymentDTO findById(Long id){
        Optional<Payment> exists = repository.findById(id);
        if(exists.isPresent()){
            Payment payment = exists.get();
            return mapper.toDTO(payment);
        } else{
            throw new RuntimeException("No se ha encontrado ningún pago con id: "+id);
        }
    }

    public List<PaymentDTO> findByClientName(String name){
        return mapper.toDTOList(repository.findByBooking_Client_Name(name));
    }

    public PaymentDTO addPayment(PaymentRequestDTO dto){
        Payment payment = mapper.toEntity(dto);
        payment.setBooking(bookingService.obtainReference(dto.getIdBooking()));

        Payment saved = repository.save(payment);
        return mapper.toDTO(saved);
    }

    public PaymentDTO alterPayment(Long id, PaymentRequestDTO dto){
        Optional<Payment> exists = repository.findById(id);
        if(exists.isPresent()){
            Payment payment = exists.get();
            mapper.updatePaymentFromRequest(dto,payment);
            payment.setBooking(bookingService.obtainReference(dto.getIdBooking()));

            Payment modified = repository.save(payment);
            return mapper.toDTO(modified);
        } else{
            throw new RuntimeException("No se encontró ningún pago con id: "+id);
        }
    }

    public String deletePayment(Long id){
        repository.deleteById(id);
        return "El pago con id: "+id+" se ha borrado correctamente";
    }
}
