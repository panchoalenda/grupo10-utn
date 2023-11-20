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

    @ElementCollection
    private List<String> servicios;

}
