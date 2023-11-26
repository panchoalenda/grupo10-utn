package com.grupo10.app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "catalogo_servicios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogoServ {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long   id;
        @Column(name = "nombre_servicio")
        private String nombre;

}
