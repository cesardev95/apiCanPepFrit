package com.canpepfrit.apicanpepfrit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="registros_actividad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistroActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_alojamiento", nullable = false)
    private Alojamiento alojamiento;
    @Column(name="horas")
    private int horas;
    @Column(name="fecha")
    private Date fecha;

}
