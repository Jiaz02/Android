package com.juan.quizees;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
    private int respuestasCorrectas = 0;
    private int respuestasIncorrectas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SystemClock.sleep(4000);



        TextView pregunta = findViewById(R.id.idPregunta);

        RadioGroup rp = findViewById(R.id.RadioRespuesta);
        RadioButton rp1 = findViewById(R.id.radioButtonRespuesta1);
        RadioButton rp2 = findViewById(R.id.radioButtonRespuesta2);
        RadioButton rp3 = findViewById(R.id.radioButtonRespuesta3);

        Button btnSend = findViewById(R.id.buttonEnviar);


        btnSend.setOnClickListener(view -> {

            String Seleccion="";

            String aux1=getResources().getString(R.string.Respuesta1);
            String aux2=getResources().getString(R.string.Respuesta2);
            String aux3=getResources().getString(R.string.Respuesta3);
            String aux4=getResources().getString(R.string.Pregunta);
            String[] respuestasp1 = {aux1,aux2,aux3};

            Pregunta p1= new Pregunta(1,aux4,respuestasp1,aux2);
            preguntas.add(p1);
            aux1=getResources().getString(R.string.Respuesta1);
            aux2=getResources().getString(R.string.Respuesta2);
            aux3=getResources().getString(R.string.Respuesta3);
            aux4=getResources().getString(R.string.Pregunta);
            respuestasp1[0] = aux1;
            respuestasp1[1] = aux2;
            respuestasp1[2] = aux3;
            Pregunta p2= new Pregunta(1,aux4,respuestasp1,aux2);
            preguntas.add(p2);
            aux1=getResources().getString(R.string.Respuesta1);
            aux2=getResources().getString(R.string.Respuesta2);
            aux3=getResources().getString(R.string.Respuesta3);
            aux4=getResources().getString(R.string.Pregunta);
            respuestasp1[0] = aux1;
            respuestasp1[1] = aux2;
            respuestasp1[2] = aux3;
            Pregunta p3= new Pregunta(1,aux4,respuestasp1,aux2);
            preguntas.add(p3);

            obtenerRespuestas(Seleccion);

            switch (view.getId()){
                case R.id.radioButtonRespuesta1:
                    if(isChecked){
                        Seleccion=getString(R.string.Respuesta1);
                        if(Seleccion.equals(p1.getRespuestaCorrecta())){
                            respuestasIncorrectas++;
                            Intent irPantalla2 = new Intent(this, Pantalla2.class);
                            startActivity(irPantalla2);
                        }
                    }
                    break;
                case R.id.radioButtonRespuesta2:
                    if(isChecked){
                        Seleccion=getString(R.string.Respuesta2);
                        if(Seleccion.equals(p1.getRespuestaCorrecta())){
                            respuestasIncorrectas++;
                            Intent irPantalla2 = new Intent(this, Pantalla2.class);
                            startActivity(irPantalla2);
                        }
                    }
                    break;
                case R.id.radioButtonRespuesta3:
                    //if(isChecked){
                        Seleccion=getString(R.string.Respuesta3);
                        if(Seleccion.equals(p1.getRespuestaCorrecta())){
                            respuestasCorrectas++;
                            Intent irPantalla2 = new Intent(this, Pantalla2.class);
                            startActivity(irPantalla2);
                        }
                    //}
                    break;
                default:
                    Toast.makeText(this,"No has selecionado nada >:(",Toast.LENGTH_LONG).show();
            }
        });

    }

    private void obtenerRespuestas(String seleccion) {

    }
    public void clickOnAnswer(View view) {
        boolean isChecked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.radioButtonRespuesta1:
                Toast.makeText(this,"Has seleccionado la primera opcion",Toast.LENGTH_LONG).show();
                break;
            case R.id.radioButtonRespuesta2:
                Toast.makeText(this,"Has seleccionado la segunda opcion",Toast.LENGTH_LONG).show();
                break;
            case R.id.radioButtonRespuesta3:
                Toast.makeText(this,"Has seleccionado la tercera opcion",Toast.LENGTH_LONG).show();
                break;
        }

    }



}