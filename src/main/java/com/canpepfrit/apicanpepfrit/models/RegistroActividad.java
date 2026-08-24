package com.canpepfrit.apicanpepfrit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="registro_actividad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistroActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="id_empleado")
    private Empleado empleado;
    @Column(name="id_alojamiento")
    private Alojamiento alojamiento;
    @Column(name="horas")
    private int horas;
    @Column(name="fecha")
    private Date fecha;

}
