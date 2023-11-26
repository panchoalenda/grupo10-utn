package com.grupo10.app.models;
import java.time.LocalDate;
import java.util.*;
import  java.time.temporal.ChronoUnit;

public class Empresa {
    private List<Cliente> clientes;
    private List<Incidente> incidentes;
    private List<Tecnico> tecnicos;

    public Empresa(List<Cliente> clientes, List<Incidente> incidentes, List<Tecnico> tecnicos) {
        this.clientes = clientes;
        this.incidentes = incidentes;
        this.tecnicos = tecnicos;
    }
    public void AgregarIncidente(Incidente incidente){
        this.incidentes.add(incidente);
    }

    public Tecnico TecnicosMasResueltos(int dias){
        Tecnico tecnicoEficaz = null;
        int max=0;
        for(Tecnico t : this.tecnicos){
            if(CantidadResueltos(t,dias)>max){
                tecnicoEficaz = t;
                max=CantidadResueltos(t,dias);
            }
        }
        return tecnicoEficaz;
    }

    public int CantidadResueltos(Tecnico t, int dias){
        int cant=0;
        for(Incidente p: this.incidentes){
            if(p.getTecnico().equals(t) && p.getEstado()==Estado.RESUELTO
                    && ChronoUnit.DAYS.between(LocalDate.now(),p.getFechaPosibleResolucion())<=7){
                cant++;
            }
        }
        return cant;
    }
}
