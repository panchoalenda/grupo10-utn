package com.grupo10.app.Model;

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
public class Tecnico extends Persona{

    //listado de especialidades del tecnico
    @Column(name = "especialidades")
    public List<Especialidad> especialidades;

    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    public void servicioResuelto(){
        //programar seccion para marcar como resuelto un servicio
    }

    @ManyToMany(targetEntity = Especialidad.class,cascade = CascadeType.ALL, fetch =FetchType.LAZY)
   /* @JoinTable(
      name = "tecnicos_servicios",  // Nombre de la tabla intermedia
      joinColumns = @JoinColumn(name = "tecnicos_id"),
      inverseJoinColumns = @JoinColumn(name = "servicios_id"))*/
    private List<Servicio> servicios;

}
