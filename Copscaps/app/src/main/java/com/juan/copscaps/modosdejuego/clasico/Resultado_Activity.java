package com.juan.copscaps.modosdejuego.clasico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.juan.copscaps.R;

public class Resultado_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Bundle extras = getIntent().getExtras();

        TextView puntos = findViewById(R.id.txtpuntos);
        Button btn = findViewById(R.id.button);

        int aciertos = extras.getInt("aciertos");
        int fallos = extras.getInt("fallos");

        double result = (aciertos-fallos)/10;

        if (result < 0) {
            puntos.setText("0");
        } else{
            puntos.setText(String.valueOf(result));
        }



        btn.setOnClickListener(view -> {
            Intent intent = new Intent(this, Activity_Fallos.class);
            startActivity(intent);
            finish();
        });

    }
}