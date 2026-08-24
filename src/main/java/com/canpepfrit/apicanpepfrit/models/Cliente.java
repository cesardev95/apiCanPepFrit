package com.canpepfrit.apicanpepfrit.models;

import jakarta.persistence.*;

@Entity
@Table(name="clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="direccion")
    private String direccion;
    @Column(name="email")
    private String email;
    @Column(name="telefono")
    private String telefono;
}
