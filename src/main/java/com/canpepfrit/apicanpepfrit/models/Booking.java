package com.canpepfrit.apicanpepfrit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_accommodation", nullable = false)
    private Accommodation accommodation;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "booking_date")
    private LocalDate bookingDate;
    @Column(name = "total_ecotasa")
    private BigDecimal totalEcotasa;
    @Enumerated(EnumType.STRING)
    @Column(name = "platform")
    private Platform platform;
    @Column(name = "total_people")
    private int people;
    @Column(name="paid")
    private boolean paid;
    @Column(name="details")
    private String details;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments = new ArrayList<>();

    public enum Platform {
        WEB,
        AIRBNB,
        BOOKING
    }


}
