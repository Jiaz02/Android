package com.juan.registrodesocios;

import android.os.Parcel;
import android.os.Parcelable;

public class Socio implements Parcelable {

    String nombre;
    String apellidos;
    String biografia;
    Float puntuacion;

    public Socio(String nombre, String apellidos, String biografia, Float puntuacion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.biografia = biografia;
        this.puntuacion = puntuacion;
    }

    protected Socio(Parcel in) {
        nombre = in.readString();
        apellidos = in.readString();
        biografia = in.readString();
        if (in.readByte() == 0) {
            puntuacion = null;
        } else {
            puntuacion = in.readFloat();
        }
    }

    public static final Creator<Socio> CREATOR = new Creator<Socio>() {
        @Override
        public Socio createFromParcel(Parcel in) {
            return new Socio(in);
        }

        @Override
        public Socio[] newArray(int size) {
            return new Socio[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getBiografia() {
        return biografia;
    }

    public Float getPuntuacion() {
        return puntuacion;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(apellidos);
        parcel.writeString(biografia);
        if (puntuacion == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeFloat(puntuacion);
        }
    }
}
