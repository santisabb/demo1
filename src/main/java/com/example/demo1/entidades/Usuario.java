package com.example.demo1.entidades;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nroDni;

    private String nombreyApellido;
    private String mail;
    private Long nroTelefono;
    private int cantReservas;

    public Usuario(long nroDni, String nombreyApellido, String mail, long nroTelefono, int cantReservas) {
        this.nroDni = nroDni;
        this.nombreyApellido = nombreyApellido;
        this.mail = mail;
        this.nroTelefono = nroTelefono;
        this.cantReservas = cantReservas;
    }
    public Usuario(){}
    public Long getNroDni() {
        return nroDni;
    }

    public void setNroDni(long nroDni) {
        this.nroDni = nroDni;
    }

    public String getNombreyApellido() {
        return nombreyApellido;
    }

    public void setNombreyApellido(String nombreyApellido) {
        this.nombreyApellido = nombreyApellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public long getNroTelefono() {
        return nroTelefono;
    }

    public void setNroTelefono(long nroTelefono) {
        this.nroTelefono = nroTelefono;
    }

    public int getCantReservas() {
        return cantReservas;
    }

    public void setCantReservas(int cantReservas) {
        this.cantReservas = cantReservas;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "nroDni=" + nroDni +
                ", nombreyApellido='" + nombreyApellido + '\'' +
                ", mail='" + mail + '\'' +
                ", nroTelefono=" + nroTelefono +
                ", cantReservas=" + cantReservas +
                '}';
    }
}
