package com.juan.listapersoanlizada.model;

public class Entidad {
    public Entidad(int imgFoto, String titulo, String contenido) {
        this.imgFoto = imgFoto;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public int getImgFoto() {
        return imgFoto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    //la imagen es un entero porque hace referencia a la id de la imagen
    private int imgFoto;
    private String titulo;
    private  String contenido;


}
