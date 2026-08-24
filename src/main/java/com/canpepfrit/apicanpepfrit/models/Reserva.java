package com.canpepfrit.apicanpepfrit.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="id_cliente")
    private Cliente cliente;
    @Column(name="id_alojamiento")
    private Alojamiento alojamiento;
    @Column(name="fecha_inicio")
    private Date fechaInicio;
    @Column(name="fecha_final")
    private Date fechaFinal;
    @Column(name="precio")
    private BigDecimal precio;

}
