package com.juan.a3_variosactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class terceraPantalla extends AppCompatActivity {

    Button btnIrAc1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera_pantalla);

        btnIrAc1 = findViewById(R.id.btn4);

        btnIrAc1.setOnClickListener(view -> {
            Intent irAACtivity1 = new Intent(terceraPantalla.this,MainActivity.class);
            startActivity(irAACtivity1);
        });
    }
}