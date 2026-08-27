package com.canpepfrit.apicanpepfrit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "alojamientos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Alojamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(mappedBy = "alojamiento",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<RegistroActividad> registros = new ArrayList<>();
    @OneToMany(mappedBy = "alojamiento",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Reserva> reservas = new ArrayList<>();
}
