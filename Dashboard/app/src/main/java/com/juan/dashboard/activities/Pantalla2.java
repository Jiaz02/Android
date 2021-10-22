package com.juan.dashboard.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.juan.dashboard.R;

public class Pantalla2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        TextView texto = findViewById(R.id.idFinal);
        Button btnSiguiente = findViewById(R.id.buttonSigueinte);

        //usamos un bundle para recoger las preguntas acertadas y las falladas
        Bundle extras = getIntent().getExtras();

        int correctas = extras.getInt("correctas");
        boolean esInicio=false;

        //si el total es 3 significa que el juego ha terminado asi que lo comunicamos al usuario
        if(correctas==3) {
            texto.setText(getResources().getString(R.string.felicidades));
            btnSiguiente.setText(getResources().getString(R.string.reinicio));

        }


        btnSiguiente.setOnClickListener(view -> {
            //si es distinto de 3 volvemos a la pantalla de las preguntas reenviando los aciertos y fallos para seguir
            if(correctas!=3) {
                Intent irPantalla1 = new Intent(this, Activity_Quizzes.class);
                irPantalla1.putExtra("aciertos", correctas);
                irPantalla1.putExtra("esinicio",esInicio);
                startActivity(irPantalla1);
            }
            else {
                //si el total es 3, se vuelve a las preguntas pero reseteando los valores a 0
                if(correctas==3) {

                    Intent irPantalla1 = new Intent(this, Activity_Quizzes.class);
                    irPantalla1.putExtra("aciertos", 0);
                    irPantalla1.putExtra("esinicio",esInicio);
                    startActivity(irPantalla1);
                }
            }
        });

    }
}