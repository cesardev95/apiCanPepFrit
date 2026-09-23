package com.canpepfrit.apicanpepfrit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="amount")
    private BigDecimal amount;

    @Column(name="payment_date")
    private LocalDate paymentDate;

    @Enumerated(EnumType.STRING)
    @Column(name="payment_method")
    private PaymentMethod method;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_booking" ,nullable=false)
    private Booking booking;
    private enum PaymentMethod{
        TRANSFER,CASH,CARD,PLATFORM
    }
}
