package com.grupo10.app.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "persona")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends Persona{


    @OneToMany(cascade = CascadeType.ALL)
    private List<Servicio> serviciosContratados;

}
