package com.juan.copscaps.modosdejuego.clasico;

public class Pregunta {
//clase que sirve para almacenar las distintas preguntas.


    public Pregunta(int numero, String pregunta, String respuesta1, String respuesta2, String respuestaCorrecta, String preguntaBienEscrita) {
        this.numero = numero;
        this.pregunta = pregunta;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuestaCorrecta = respuestaCorrecta;
        this.preguntaBienEscrita = preguntaBienEscrita;
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

    public String getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getPreguntaBienEscrita() {
        return preguntaBienEscrita;
    }

    public void setPreguntaBienEscrita(String preguntaBienEscrita) {
        this.preguntaBienEscrita = preguntaBienEscrita;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "numero=" + numero +
                ", pregunta='" + pregunta + '\'' +
                ", respuesta1='" + respuesta1 + '\'' +
                ", respuesta2='" + respuesta2 + '\'' +
                ", respuestaCorrecta='" + respuestaCorrecta + '\'' +
                ", preguntaBienEscrita='" + preguntaBienEscrita + '\'' +
                '}';
    }

    private int numero;
    private String pregunta;
    private String respuesta1;
    private String respuesta2;
    private String respuestaCorrecta;
    private String preguntaBienEscrita;



}
