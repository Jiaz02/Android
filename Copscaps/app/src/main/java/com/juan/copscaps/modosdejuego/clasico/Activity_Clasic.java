package com.juan.copscaps.modosdejuego.clasico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
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

public class Activity_Clasic extends AppCompatActivity {

    private ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
    private static ArrayList<Pregunta> preguntasfalladas = new ArrayList<Pregunta>();

    public static List<Pregunta> getListaFallos() {
        return preguntasfalladas;
    }
    private static ArrayList<Pregunta> preguntasnorespondidas = new ArrayList<Pregunta>();

    public static List<Pregunta> getListaBlanco() {
        return preguntasnorespondidas;
    }
    private int NumPregunta = 0 ;
    private String Seleccion="";
    private boolean avanzar=false;
    TextView timerr;
    Button btnNext;
    Button btnFin;
    private static int numAciertos=0;
    private static int numfallos=0;


    private CountDownTimer coun = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clasic);
        setTitle(getResources().getString(R.string.cienenocho));

        btnFin = findViewById(R.id.button2);

        timerr = findViewById(R.id.txtTiempo);

        coun = new CountDownTimer(480000, 1000) {

            public void onTick(long millisUntilFinished) {
                timerr.setText(getString(R.string.timer)+ millisUntilFinished / 1000+"s");
            }

            public void onFinish() {
                timerr.setText("done!");
                saltar();
            }
        }.start();

        for (int i = 0; i < 100; i++) {
            Random r = new Random();
            int selectorDeLista = r.nextInt(5);

            if (selectorDeLista%2==0){
                int numPregunta = r.nextInt(200);

                preguntas.add(LogicaNegocio.listaPreguntasIncorrectas.get(numPregunta));
            } else {
                int numPregunta = r.nextInt(200);

                preguntas.add(LogicaNegocio.listaPreguntasCorrectas.get(numPregunta));
            }
        }
        MostrarPreguntas(NumPregunta,preguntas);

        btnFin.setOnClickListener(view -> {
            saltar();
        });
    }


    private void saltar(){

        if (preguntas.size()>0){
            for (Pregunta p:preguntas) {
                preguntasnorespondidas.add(p);
            }
        }

        Intent intent = new Intent(this, Resultado_Activity.class);
        intent.putExtra("aciertos",numAciertos);
        intent.putExtra("fallos",numfallos);
        startActivity(intent);
        coun.cancel();
        finish();
    }

    private void MostrarPreguntas(int numPregunta, ArrayList<Pregunta> preguntas) {
        RadioButton rp1 = findViewById(R.id.radioButtonRespuesta);
        RadioButton rp2 = findViewById(R.id.radioButtonRespuesta1);
        RadioButton rp3 = findViewById(R.id.radioButtonRespuesta2);
        TextView pregunta = findViewById(R.id.idPregunta);
        TextView numero = findViewById(R.id.idNumPregunta);
        btnNext = findViewById(R.id.buttonEnviar);
        Random r = new Random();

        if (preguntas.size()>0){
            int valorDado = r.nextInt(preguntas.size());

            int num=(numPregunta+1);
            preguntas.get(valorDado).setNumero(num);
            String nPregunta=getResources().getString(R.string.Pregunta)+preguntas.get(valorDado).getNumero();
            numero.setText(nPregunta);
            pregunta.setText(preguntas.get(valorDado).getPregunta());
            rp1.setText(preguntas.get(valorDado).getRespuesta1());
            rp2.setText(preguntas.get(valorDado).getRespuesta2());
            rp3.setText(getResources().getString(R.string.siguiente));

            btnNext.setOnClickListener(view -> {
                if (avanzar){
                    if (Seleccion.equals(preguntas.get(valorDado).getRespuestaCorrecta())){
                        numAciertos++;
                        preguntas.remove(valorDado);
                        MostrarPreguntas(num,preguntas);
                    } else if (Seleccion.equals("")) {
                        preguntasnorespondidas.add(preguntas.get(valorDado));
                        preguntas.remove(valorDado);
                        MostrarPreguntas(num,preguntas);
                    } else {
                        preguntasfalladas.add(preguntas.get(valorDado));
                        numfallos++;
                        preguntas.remove(valorDado);
                        MostrarPreguntas(num,preguntas);
                    }
                } else {
                    Toast.makeText(this, getResources().getString(R.string.blanco), Toast.LENGTH_SHORT).show();
                }

            });
        } else if(preguntasnorespondidas.size()>0){
            MostrarBlanco();

        } else {
            saltar();
        }




    }

    public void MostrarBlanco(){
        RadioButton rp1 = findViewById(R.id.radioButtonRespuesta);
        RadioButton rp2 = findViewById(R.id.radioButtonRespuesta1);
        RadioButton rp3 = findViewById(R.id.radioButtonRespuesta2);
        TextView pregunta = findViewById(R.id.idPregunta);
        TextView numero = findViewById(R.id.idNumPregunta);
        btnNext = findViewById(R.id.buttonEnviar);
        Random r = new Random();
        if (preguntasnorespondidas.size()>0){
            int valorDado = r.nextInt(preguntasnorespondidas.size());

            String nPregunta=getResources().getString(R.string.Pregunta)+preguntasnorespondidas.get(valorDado).getNumero();
            numero.setText(nPregunta);
            pregunta.setText(preguntasnorespondidas.get(valorDado).getPregunta());
            rp1.setText(preguntasnorespondidas.get(valorDado).getRespuesta1());
            rp2.setText(preguntasnorespondidas.get(valorDado).getRespuesta2());
            rp3.setText(getResources().getString(R.string.siguiente));

            btnNext.setOnClickListener(view -> {
                if (avanzar){
                    if (Seleccion.equals(preguntasnorespondidas.get(valorDado).getRespuestaCorrecta())){
                        numAciertos++;
                        preguntasnorespondidas.remove(valorDado);
                        MostrarBlanco();
                    } else if (Seleccion.equals("")) {
                        preguntasnorespondidas.remove(valorDado);
                        MostrarBlanco();
                    } else {
                        preguntasfalladas.add(preguntasnorespondidas.get(valorDado));
                        preguntasnorespondidas.remove(valorDado);
                        numfallos++;
                        MostrarBlanco();
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
        boolean isChecked = ((RadioButton) view).isChecked();
        RadioButton rp1 = findViewById(R.id.radioButtonRespuesta);
        RadioButton rp2 = findViewById(R.id.radioButtonRespuesta1);

        //guardamos la seleccion del usuario a la vez que decimos que hay algo selecionado gracias a avanzar
        switch (view.getId()){
            case R.id.radioButtonRespuesta:
                Seleccion= "Bien";
                avanzar=true;
                break;
            case R.id.radioButtonRespuesta1:
                Seleccion="Mal";
                avanzar=true;
                break;
            case R.id.radioButtonRespuesta2:
                Seleccion= "";
                avanzar=true;
                break;
        }
    }

}