package com.accenture.bean;

/**
 * Created by j.zamora.villasenor on 10/3/2017.
 */

public class Empleado {
    String nombre;
    String apellido;
    String status;
    String telefono;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Empleado(String status, String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.status = status;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return  nombre+ " "+apellido+" "+status +" "+ telefono;
    }
}
