package com.example.demo1.entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cancha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCancha;

    private String tipoCancha;
    private String medidas;
    private boolean estado;
    private String tipoCesped;

    public Cancha(int idCancha, String tipoCancha, String medidas, boolean estado, String tipoCesped) {
        this.idCancha = idCancha;
        this.tipoCancha = tipoCancha;
        this.medidas = medidas;
        this.estado = estado;
        this.tipoCesped = tipoCesped;
    }

    public Cancha(){}
    public int getIdCancha() {
        return idCancha;
    }

    public void setIdCancha(int idCancha) {
        this.idCancha = idCancha;
    }

    public String getTipoCancha() {
        return tipoCancha;
    }

    public void setTipoCancha(String tipoCancha) {
        this.tipoCancha = tipoCancha;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getTipoCesped() {
        return tipoCesped;
    }

    public void setTipoCesped(String tipoCesped) {
        this.tipoCesped = tipoCesped;
    }

    @Override
    public String toString() {
        return "Cancha{" +
                ", idCancha=" + idCancha +
                ", medidas=" + medidas +
                ", estado=" + estado +
                ", tipoCesped=" + tipoCesped +
                "}";
    }
}
