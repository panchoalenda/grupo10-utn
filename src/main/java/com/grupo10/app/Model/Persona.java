package com.grupo10.app.Model;

import jakarta.persistence.*;

@Entity
@Table(name="persona")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "razonSocial")
    private String razonSocial;

    @Column(name = "CUIT")
    private String CUIT;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCUIT() {
        return CUIT;
    }

    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }
}
