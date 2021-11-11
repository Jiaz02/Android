package com.juan.dashboard.activities.model;

import java.io.Serializable;

public class DiscoMusica implements Serializable {
    public DiscoMusica(String imgFoto, String nombre, String añoLanzamiento, String artista) {
        this.imgFoto = imgFoto;
        this.nombre = nombre;
        this.añoLanzamiento = añoLanzamiento;
        this.artista = artista;
    }

    public String getImgFoto() {
        return imgFoto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAñoLanzamiento() {
        return añoLanzamiento;
    }

    public String getArtista() {
        return artista;
    }

    private String imgFoto;
    private String nombre;
    private  String añoLanzamiento;
    private  String artista;
}
