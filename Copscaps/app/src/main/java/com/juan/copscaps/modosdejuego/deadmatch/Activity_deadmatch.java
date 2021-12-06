package com.juan.copscaps.modosdejuego.deadmatch;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.juan.copscaps.LogicaNegocio;
import com.juan.copscaps.Pregunta;
import com.juan.copscaps.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Activity_deadmatch extends AppCompatActivity {

    private List<Pregunta> preguntas = new ArrayList<Pregunta>();
    private static List<Pregunta> preguntasfalladas = new ArrayList<Pregunta>();

    public static List<Pregunta> getListaFallos() {
        return preguntasfalladas;
    }

    private int NumPregunta = 0 ;
    private String Seleccion="";
    private boolean avanzar=false;
    private int vida=10;
    TextView vidas;
    Button btnNext;
    Button btnFin;
    private static int numAciertos=0;
    private static int numfallos=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deadmatch);
        btnFin = findViewById(R.id.button2D);
        vidas = findViewById(R.id.txtvidas);
        vidas.setText(vidas.getText()+String.valueOf(vida));
        preguntas= LogicaNegocio.getListaCorrectas();
        for (Pregunta p : LogicaNegocio.getListaIncorrectas()) {
            preguntas.add(p);
        }



        mostrarPreguntas(NumPregunta);

        btnFin.setOnClickListener(view -> {
            saltar();
        });
    }
    private void saltar(){
        Intent intent = new Intent(this, Result_Activity.class);
        intent.putExtra("aciertos",numAciertos);
        intent.putExtra("fallos",numfallos);
        startActivity(intent);
        finish();
    }
    private void mostrarPreguntas(int numPregunta){
        RadioButton rp1 = findViewById(R.id.radioButtonRespuestaD);
        RadioButton rp2 = findViewById(R.id.radioButtonRespuesta1D);
        TextView pregunta = findViewById(R.id.idPreguntaD);
        TextView numero = findViewById(R.id.idNumPreguntaD);
        btnNext = findViewById(R.id.buttonEnviarD);
        Random r = new Random();
        vidas = findViewById(R.id.txtvidas);

        if (vida ==0){
            saltar();
        }
        if (preguntas.size()>0){
            int valorDado = r.nextInt(preguntas.size());

            int num=(numPregunta+1);
            preguntas.get(valorDado).setNumero(num);
            String nPregunta=getResources().getString(R.string.Pregunta)+preguntas.get(valorDado).getNumero();
            numero.setText(nPregunta);
            pregunta.setText(preguntas.get(valorDado).getPregunta());
            rp1.setText(preguntas.get(valorDado).getRespuesta1());
            rp2.setText(preguntas.get(valorDado).getRespuesta2());

            btnNext.setOnClickListener(view -> {
                if (avanzar){
                    if (Seleccion.equals(preguntas.get(valorDado).getRespuestaCorrecta())){
                        numAciertos++;
                        preguntas.remove(valorDado);

                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setMessage(R.string.msgacierto);
                        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                numAciertos++;
                                mostrarPreguntas(num);
                            }
                        });
                        builder.create();
                        builder.show();

                    } else {
                        preguntasfalladas.add(preguntas.get(valorDado));
                        numfallos++;
                        preguntas.remove(valorDado);

                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setMessage(R.string.msgfallo);
                        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                vida--;
                                vidas.setText(getResources().getString(R.string.vidas)+vida);
                                mostrarPreguntas(num);
                            }
                        });
                        builder.create();
                        builder.show();
                    }
                } else {
                    Toast.makeText(this, getResources().getString(R.string.blanco), Toast.LENGTH_SHORT).show();
                }

            });

        } else {
            saltar();
        }
    }


    public void clickOnAnswer(View view) {

        //guardamos la seleccion del usuario a la vez que decimos que hay algo selecionado gracias a avanzar
        switch (view.getId()){
            case R.id.radioButtonRespuestaD:
                Seleccion= "Bien";
                avanzar=true;
                break;
            case R.id.radioButtonRespuesta1D:
                Seleccion="Mal";
                avanzar=true;
                break;
        }
    }
}