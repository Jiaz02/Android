package com.juan.copscaps.modosdejuego.clasico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.juan.copscaps.LogicaNegocio;
import com.juan.copscaps.Pregunta;
import com.juan.copscaps.R;

import java.util.ArrayList;
import java.util.Random;

public class Activity_Clasic extends AppCompatActivity {

    public ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
    public ArrayList<Pregunta> preguntasfalladas = new ArrayList<Pregunta>();
    private int NumPregunta = 0 ;
    private String Seleccion="";
    private boolean avanzar=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clasic);
        setTitle("100 en 8 min");

        for (int i = 0; i < 99; i++) {
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

    }

    private void MostrarPreguntas(int numPregunta, ArrayList<Pregunta> preguntas) {
        RadioButton rp1 = findViewById(R.id.radioButtonRespuesta1);
        RadioButton rp2 = findViewById(R.id.radioButtonRespuesta2);
        TextView pregunta = findViewById(R.id.idPregunta);
        TextView numero = findViewById(R.id.idPregunta);

        Random r = new Random();
        int valorDado = r.nextInt(2);

        int num=(numPregunta+1);
        String nPregunta="Pregunta "+num;
        numero.setText(nPregunta);
        pregunta.setText(preguntas.get(valorDado).getPregunta());
        rp1.setText(preguntas.get(valorDado).getRespuesta1());
        rp2.setText(preguntas.get(valorDado).getRespuesta2());

    }


    public void clickOnAnswer(View view) {
        boolean isChecked = ((RadioButton) view).isChecked();
        RadioButton rp1 = findViewById(R.id.radioButtonRespuesta1);
        RadioButton rp2 = findViewById(R.id.radioButtonRespuesta2);

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
        }
    }
}