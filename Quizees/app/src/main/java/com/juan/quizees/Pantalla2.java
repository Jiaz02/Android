package com.juan.quizees;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class Pantalla2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        Button btnSiguiente = findViewById(R.id.buttonSigueinte);

        Bundle extras = getIntent().getExtras();

        int correctas = extras.getInt("correctas");
        int incorrectas = extras.getInt("incorrectas");

        if(correctas+incorrectas==3) {
            btnSiguiente.setText(getResources().getString(R.string.reinicio));

        }


        btnSiguiente.setOnClickListener(view -> {
            if(correctas+incorrectas!=3) {
                Intent irPantalla1 = new Intent(this, MainActivity.class);
                irPantalla1.putExtra("aciertos", correctas);
                irPantalla1.putExtra("errores", incorrectas);
                startActivity(irPantalla1);
            }
            else {
                if(correctas+incorrectas==3) {

                    Intent irPantalla1 = new Intent(this, MainActivity.class);
                    irPantalla1.putExtra("aciertos", 0);
                    irPantalla1.putExtra("errores", 0);
                    startActivity(irPantalla1);
                }
            }
        });

    }
}