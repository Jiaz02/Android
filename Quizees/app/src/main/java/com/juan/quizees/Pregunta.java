package com.juan.quizees;

import java.util.Arrays;

public class Pregunta {

    public Pregunta(int numero, String pregunta, String[] respuestasPregunta, String respuestaCorrecta) {
        this.numero = numero;
        this.pregunta = pregunta;
        this.respuestasPregunta = respuestasPregunta;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String[] getRespuestasPregunta() {
        return respuestasPregunta;
    }

    public void setRespuestasPregunta(String[] respuestasPregunta) {
        this.respuestasPregunta = respuestasPregunta;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "numero=" + numero +
                ", pregunta='" + pregunta + '\'' +
                ", respuestasPregunta=" + Arrays.toString(respuestasPregunta) +
                ", respuestaCorrecta='" + respuestaCorrecta + '\'' +
                '}';
    }

    private int numero;
    private String pregunta;
    private String[] respuestasPregunta = new String[3];
    private String respuestaCorrecta;



}
