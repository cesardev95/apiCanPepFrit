package com.canpepfrit.apicanpepfrit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "reservas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_alojamiento", nullable = false)
    private Alojamiento alojamiento;
    @Column(name = "fecha_inicio")
    private Date fechaInicio;
    @Column(name = "fecha_final")
    private Date fechaFinal;
    @Column(name = "precio")
    private BigDecimal precio;
    @Column(name="fecha_reserva")
    private Date fechaReserva;
    @Column(name="total_ecotasa")
    private BigDecimal totalEcotasa;
    @Enumerated(EnumType.STRING)
    @Column(name="plataforma")
    private Plataforma plataforma;
    @Column(name="total_personas")
    private int personas;

    public enum Plataforma {
        WEB,
        AIRBNB,
        BOOKING
    }


}
