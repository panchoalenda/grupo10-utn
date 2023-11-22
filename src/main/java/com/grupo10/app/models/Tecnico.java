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
public class Tecnico{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;

    @Column(name = "nombre")
    private String razonSocial;

    @ManyToMany
    @JoinTable(
      name = "tecnicos_servicios",  // Nombre de la tabla intermedia
      joinColumns = @JoinColumn(name = "tecnicos_id"),
      inverseJoinColumns = @JoinColumn(name = "servicios_id"))
    private List<Servicio> servicios;

}
