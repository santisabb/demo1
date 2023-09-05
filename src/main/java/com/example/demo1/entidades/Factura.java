package com.example.demo1.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nroFactura;

    private double total;
    private String tipo;
    private String razonSocial;

    public Factura(Long nroFactura , double total , String tipo , String razonSocial){
        this.nroFactura = nroFactura;
        this.total = total;
        this.tipo = tipo;
        this.razonSocial = razonSocial;
    }

    public Factura(){}

    public Long getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(Long nroFactura) {
        this.nroFactura = nroFactura;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String toString() {
        return "Factura{" +
                ",nroFactura=" + nroFactura +
                ",total=" + total +
                ",tipo=" + tipo +
                ",razonSocial=" + razonSocial +
                "}";
    }
}
