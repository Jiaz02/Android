package com.juan.quizees;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
    private int respuestasCorrectas ;
    private String Seleccion="";
    private boolean avanzar=false;
    ImageView movileImageview;
    private boolean esInicio=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        respuestasCorrectas = extras.getInt("aciertos");
        System.out.println(respuestasCorrectas);
        esInicio=extras.getBoolean("esinicio");
//no muestra las imagenes del splash

        if(esInicio) {
            SystemClock.sleep(4000);
        }
//inicializamos los objetos del xml
        TextView idPregunta=findViewById(R.id.idNumPregunta);
        TextView pregunta = findViewById(R.id.idPregunta);

        movileImageview= findViewById(R.id.imageView1);
        int imageId;
        RadioGroup rp = findViewById(R.id.RadioRespuesta);
        RadioButton rp1 = findViewById(R.id.radioButtonRespuesta1);
        RadioButton rp2 = findViewById(R.id.radioButtonRespuesta2);
        RadioButton rp3 = findViewById(R.id.radioButtonRespuesta3);

        Button btnSend = findViewById(R.id.buttonEnviar);
//creamos un objeto pregunta por cada pregunta que queramos añadir al juego
        String aux1=getResources().getString(R.string.Respuesta1);
        String aux2=getResources().getString(R.string.Respuesta2);
        String aux3=getResources().getString(R.string.Respuesta3);
        String aux4=getResources().getString(R.string.Pregunta);
        Pregunta p1= new Pregunta(1,aux4,aux1,aux2,aux3,aux3);
        preguntas.add(p1);

        aux1=getResources().getString(R.string.Respuesta4);
        aux2=getResources().getString(R.string.Respuesta5);
        aux3=getResources().getString(R.string.Respuesta6);
        aux4=getResources().getString(R.string.Pregunta2);
        Pregunta p2= new Pregunta(2,aux4,aux1,aux2,aux3,aux2);
        preguntas.add(p2);

        aux1=getResources().getString(R.string.Respuesta7);
        aux2=getResources().getString(R.string.Respuesta8);
        aux3=getResources().getString(R.string.Respuesta9);
        aux4=getResources().getString(R.string.Pregunta3);
        Pregunta p3= new Pregunta(3,aux4,aux1,aux2,aux3,aux1);
        preguntas.add(p3);

        //en funcion del total de preguntas que se lleven se cambian los valores a una pregunta u otra
        switch (respuestasCorrectas){
            case 0:
                imageId=R.drawable.logo;
                idPregunta.setText(getResources().getString(R.string.NumPregunta));
                pregunta.setText(p1.getPregunta());
                rp1.setText(p1.getRespuesta1());
                rp2.setText(p1.getRespuesta2());
                rp3.setText(p1.getRespuesta3());

                if(imageId!=0){
                    movileImageview.setImageDrawable(ContextCompat.getDrawable(this,imageId));
                }

                break;
            case 1:
                imageId=R.drawable.paradoja;
                idPregunta.setText(getResources().getString(R.string.NumPregunta2));
                pregunta.setText(p2.getPregunta());
                rp1.setText(p2.getRespuesta1());
                rp2.setText(p2.getRespuesta2());
                rp3.setText(p2.getRespuesta3());

                if(imageId!=0){
                    movileImageview.setImageDrawable(ContextCompat.getDrawable(this,imageId));
                }
                break;
            case 2:
                imageId=R.drawable.bulbasaur;
                idPregunta.setText(getResources().getString(R.string.NumPregunta3));
                pregunta.setText(p3.getPregunta());
                rp1.setText(p3.getRespuesta1());
                rp2.setText(p3.getRespuesta2());
                rp3.setText(p3.getRespuesta3());

                if(imageId!=0){
                    movileImageview.setImageDrawable(ContextCompat.getDrawable(this,imageId));
                }
                break;
        }

        btnSend.setOnClickListener(view -> {
            if(avanzar) {
//se se puede avanzar procesamos la seleccion
                //si es igual la respuesta de la pregunta 1 se hace una cosa sino una serie de sentencias que comparan con las otras preguntas y cambian al siguiente activity.
                if (Seleccion.equals(p1.getRespuestaCorrecta())) {

                    respuestasCorrectas++;

                    Intent irPantalla2 = new Intent(this, Pantalla2.class);
                    irPantalla2.putExtra("correctas",respuestasCorrectas);
                    startActivity(irPantalla2);

                }else {
                    if (Seleccion.equals(p2.getRespuestaCorrecta())) {

                        respuestasCorrectas++;

                        Intent irPantalla2 = new Intent(this, Pantalla2.class);
                        irPantalla2.putExtra("correctas", respuestasCorrectas);
                        startActivity(irPantalla2);

                    } else {
                        if (Seleccion.equals(p3.getRespuestaCorrecta())) {

                            respuestasCorrectas++;

                            Intent irPantalla2 = new Intent(this, Pantalla2.class);
                            irPantalla2.putExtra("correctas", respuestasCorrectas);
                            startActivity(irPantalla2);


                        }

                    }
                }
//mensajito como que no hay nada seleccionado
                }
            else{
                        Toast.makeText(this, getResources().getString(R.string.NoSeleccion), Toast.LENGTH_LONG).show();
                    }

        });

    }

    public void clickOnAnswer(View view) {
        boolean isChecked = ((RadioButton) view).isChecked();
        RadioButton rp1 = findViewById(R.id.radioButtonRespuesta1);
        RadioButton rp2 = findViewById(R.id.radioButtonRespuesta2);
        RadioButton rp3 = findViewById(R.id.radioButtonRespuesta3);

        //guardamos la seleccion del usuario a la vez que decimos que hay algo selecionado gracias a avanzar
        switch (view.getId()){
            case R.id.radioButtonRespuesta1:
                Seleccion= rp1.getText().toString();
                avanzar=true;
                break;
            case R.id.radioButtonRespuesta2:
                Seleccion= rp2.getText().toString();
                avanzar=true;
                break;
            case R.id.radioButtonRespuesta3:
                Seleccion= rp3.getText().toString();
                avanzar=true;
                break;
        }

    }



}