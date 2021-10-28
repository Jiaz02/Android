package com.juan.marcadorbasket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView puntosLocal = findViewById(R.id.puntosLocal);
        TextView puntosVisitante = findViewById(R.id.PuntosVisitantes);

        ImageButton menos1Local = findViewById(R.id.buttonR1Local);
        ImageButton menos1Visitante = findViewById(R.id.buttonR1Visitante);
        ImageButton mas1Visitante = findViewById(R.id.buttonS1Visitante);
        ImageButton mas1Local = findViewById(R.id.buttonS1Local);
        ImageButton next = findViewById(R.id.siguiente);



        menos1Local.setOnClickListener( view -> {
            String num1 = puntosLocal.getText().toString();
            int puntuacionLocal = Integer.parseInt(num1);
            int nLocal = puntuacionLocal;
            if(puntuacionLocal>0){
                puntosLocal.setText(nLocal);
            } else{
                Toast.makeText(this, getString(R.string.msg_toast),Toast.LENGTH_LONG).show();
            }
        });

        menos1Visitante.setOnClickListener( view -> {
            int puntuacionVisitante = Integer.parseInt(puntosVisitante.getText().toString());
            int nVisitante = puntuacionVisitante;
            if(puntuacionVisitante>0){
                puntosVisitante.setText(nVisitante);
            } else{
                Toast.makeText(this, getString(R.string.msg_toast),Toast.LENGTH_LONG).show();
            }
        });

        mas1Visitante.setOnClickListener( view -> {
            String num1 = puntosLocal.getText().toString();
            int puntuacionVisitante = Integer.parseInt(num1);
            int nVisitante = puntuacionVisitante;
            puntosVisitante.setText(nVisitante);
        });

        mas1Local.setOnClickListener( view -> {
            int puntuacionLocal = Integer.parseInt(puntosLocal.getText().toString());
            int nLocal = puntuacionLocal;
            puntosLocal.setText(nLocal);
        });

        next.setOnClickListener( view -> {
            Intent intent = new Intent(MainActivity.this,ResultadoActivity.class);
            startActivity(intent);
        });
    }

}