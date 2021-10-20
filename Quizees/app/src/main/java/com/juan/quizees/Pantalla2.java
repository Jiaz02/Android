package com.juan.quizees;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        Button btnSiguiente = findViewById(R.id.buttonSigueinte);

        btnSiguiente.setOnClickListener(view -> {
            Intent irPantalla1 = new Intent(this, MainActivity.class);
            startActivity(irPantalla1);
        });

    }
}