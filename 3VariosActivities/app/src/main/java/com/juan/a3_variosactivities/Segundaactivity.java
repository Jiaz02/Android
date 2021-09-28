package com.juan.a3_variosactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Segundaactivity extends AppCompatActivity {

    Button btnIrAc1;
    Button btnIrAC3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundaactivity);

        btnIrAc1 = findViewById(R.id.btn2);

        btnIrAc1.setOnClickListener(view -> {
            Intent irAACtivity1 = new Intent(Segundaactivity.this,MainActivity.class);
            startActivity(irAACtivity1);
        });

        btnIrAC3 = findViewById(R.id.btn4);
        btnIrAC3.setOnClickListener(view -> {
            Intent irAACtivity3 = new Intent(Segundaactivity.this,terceraPantalla.class);
            startActivity(irAACtivity3);
        });

    }


}