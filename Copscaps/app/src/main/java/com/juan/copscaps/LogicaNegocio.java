package com.juan.copscaps;

import com.juan.copscaps.modosdejuego.clasico.Pregunta;

import java.util.ArrayList;
import java.util.List;

public class LogicaNegocio {
    public static List<Pregunta> listaPreguntas = new ArrayList<Pregunta>();

    public static List<Pregunta> getListaTrabajadores() {
        //metodo para buscar devolver la lista
        return listaPreguntas;
    }
}
