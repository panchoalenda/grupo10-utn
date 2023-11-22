package com.grupo10.app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "cuil")
    private String cuil;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Servicio> serviciosContratados;

}
