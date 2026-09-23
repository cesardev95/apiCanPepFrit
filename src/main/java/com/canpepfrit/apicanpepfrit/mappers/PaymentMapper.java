package com.canpepfrit.apicanpepfrit.mappers;

import com.canpepfrit.apicanpepfrit.DTOS.PaymentDTO;
import com.canpepfrit.apicanpepfrit.DTOS.PaymentRequestDTO;
import com.canpepfrit.apicanpepfrit.models.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentDTO toDTO(Payment payment);
    Payment toEntity(PaymentDTO paymentDTO);
    List<PaymentDTO> toDTOList(List<Payment> payments);
    List<Payment> toEntityList(List<PaymentDTO> dtos);

    @Mapping(target="booking",ignore=true)
    Payment toEntity(PaymentRequestDTO dto);

    @Mapping(target="id",ignore = true)
    @Mapping(target="booking",ignore = true)
    Payment updatePaymentFromRequest(PaymentRequestDTO dto, @MappingTarget Payment entity);

}
