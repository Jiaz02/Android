package com.juan.pokemonapp.model;



public class Pokemon {

    private String id;
    private String nombre;
    //le pongo un entero porque contiene el id de la imagen
    private String imageURL;
    private int soundId;
    private Type type;



    public Pokemon(String id, String nombre, String imageURL, int soundId, Type type) {
        this.id = id;
        this.nombre = nombre;
        this.imageURL = imageURL;
        this.soundId = soundId;
        this.type = type;
    }

    public enum Type{
        FIRE,WATER,PLANT,ELECTRIC
    }

    public String getImageURL() { return imageURL; }

    public int getSoundId() { return soundId; }


    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Type getType() {
        return type;
    }
}
