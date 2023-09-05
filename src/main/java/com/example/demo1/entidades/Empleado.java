package com.example.demo1.entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpleado;

    private String cuil;
    private String nombreyApellidoEmpleado;

    public Empleado(Long idEmpleado, String cuil, String nombreyApellidoEmpleado){
        this.idEmpleado = idEmpleado;
        this.cuil = cuil;
        this.nombreyApellidoEmpleado = nombreyApellidoEmpleado;
    }

    public Empleado(){}
    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getNombreyApellidoEmpleado() {
        return nombreyApellidoEmpleado;
    }

    public void setNombreyApellidoEmpleado(String nombreyApellidoEmpleado) {
        this.nombreyApellidoEmpleado = nombreyApellidoEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado{"+
                ", CUIL=" +cuil +
                ", Nombre y apellido=" + nombreyApellidoEmpleado +
                "}";
    }
}
