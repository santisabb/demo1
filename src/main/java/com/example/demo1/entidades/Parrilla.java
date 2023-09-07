package com.example.demo1.entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Parrilla {
    @Id
    private Long idParrilla;

    private Boolean estadoParrilla;

    public Parrilla(Long idParrilla, Boolean estadoParrilla) {
        this.idParrilla = idParrilla;
        this.estadoParrilla = estadoParrilla;
    }

    public Parrilla(){}

    public Long getIdParrilla() {
        return idParrilla;
    }

    public void setIdParrilla(Long idParrilla) {
        this.idParrilla = idParrilla;
    }

    public Boolean getEstadoParrilla() {
        return estadoParrilla;
    }

    public void setEstadoParrilla(Boolean estadoParrilla) {
        this.estadoParrilla = estadoParrilla;
    }

    public String toString() {
        return "Parrilla{" +
                ", idParrilla=" + idParrilla +
                ", estadoParrilla=" + estadoParrilla +
                "}";
    }
}
