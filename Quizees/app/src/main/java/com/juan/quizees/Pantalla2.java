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

        btnSiguiente.setOnClickListener(view -> {
            Intent irPantalla1 = new Intent(this, MainActivity.class);
            irPantalla1.putExtra("aciertos",correctas);
            irPantalla1.putExtra("errores",incorrectas);
            startActivity(irPantalla1);
        });

    }
}