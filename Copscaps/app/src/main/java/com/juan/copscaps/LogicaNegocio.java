package com.juan.copscaps;

import com.juan.copscaps.modosdejuego.clasico.Pregunta;

import java.util.ArrayList;
import java.util.List;

public class LogicaNegocio {
    public static List<Pregunta> listaPreguntasCorrectas = new ArrayList<Pregunta>();

    public static List<Pregunta> getListaCorrectas() {
        //metodo para buscar devolver la lista
        return listaPreguntasCorrectas;
    }

    public static List<Pregunta> listaPreguntasIncorrectas = new ArrayList<Pregunta>();

    public static List<Pregunta> getListaIncorrectas() {
        //metodo para buscar devolver la lista
        return listaPreguntasIncorrectas;
    }
}
