package com.juan.copscaps.extras.info;

public class Option {
    private String nombre;
    private String Descripcion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Option(String nombre, String descripcion) {
        this.nombre = nombre;
        Descripcion = descripcion;
    }
}
