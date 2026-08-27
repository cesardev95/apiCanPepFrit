package com.canpepfrit.apicanpepfrit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empleados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "telefono")
    private String telefono;
    //Tipo de cascada para poder modificar las clases hijas directamente desde el JSON del padre.
    //OrphanRemoval para que borre los registros que se queden sin clase padre.
    @OneToMany(mappedBy = "empleado",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<RegistroActividad> registros = new ArrayList<>();

}
