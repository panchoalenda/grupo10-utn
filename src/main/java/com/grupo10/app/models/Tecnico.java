package com.grupo10.app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tecnicos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String razonSocial;

    @ManyToMany(targetEntity = Especialidad.class, cascade = CascadeType.ALL)
    private List<Especialidad> especialidades;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
      name = "tecnicos_Incidentes",
      joinColumns = @JoinColumn(name = "tecnico_id"),
      inverseJoinColumns = @JoinColumn(name = "incidente_id"))
    private List<Incidente> incidentes;


}
