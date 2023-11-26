package com.grupo10.app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "servicios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;

    @Column(name = "servicios")
    private CatalogoServ servicio;

    @ManyToMany(mappedBy = "servicios")
    private List<Tecnico> tecnicos;
}
