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
        ImageButton mas2Visitante = findViewById(R.id.buttonS2Visitante);
        ImageButton mas1Local = findViewById(R.id.buttonS1Local);
        ImageButton mas2Local = findViewById(R.id.buttonS2Local);
        ImageButton next = findViewById(R.id.siguiente);
        ImageButton reset = findViewById(R.id.Restore);



        menos1Local.setOnClickListener( view -> {
            int puntuacionLocal = Integer.parseInt(puntosLocal.getText().toString());
            int nLocal = puntuacionLocal-1;
            if(puntuacionLocal>0){
                String local = String.valueOf(nLocal);
                puntosLocal.setText(local);
            } else{
                Toast.makeText(this, getString(R.string.msg_toast),Toast.LENGTH_LONG).show();
            }
        });

        menos1Visitante.setOnClickListener( view -> {
            int puntuacionVisitante = Integer.parseInt(puntosVisitante.getText().toString());
            int nVisitante = puntuacionVisitante-1;
            if(puntuacionVisitante>0){
                String visitante = String.valueOf(nVisitante);
                puntosVisitante.setText(visitante);
            } else{
                Toast.makeText(this, getString(R.string.msg_toast),Toast.LENGTH_LONG).show();
            }
        });

        mas1Visitante.setOnClickListener( view -> {
            int puntuacionVisitante = Integer.parseInt(puntosVisitante.getText().toString());
            int nVisitante = puntuacionVisitante+1;
            String visitante = String.valueOf(nVisitante);
            puntosVisitante.setText(visitante);
        });

        mas2Visitante.setOnClickListener( view -> {
            int puntuacionVisitante = Integer.parseInt(puntosVisitante.getText().toString());
            int nVisitante = puntuacionVisitante+2;
            String visitante = String.valueOf(nVisitante);
            puntosVisitante.setText(visitante);
        });

        mas1Local.setOnClickListener( view -> {
            int puntuacionLocal = Integer.parseInt(puntosLocal.getText().toString());
            int nLocal = puntuacionLocal+1;
            String local = String.valueOf(nLocal);
            puntosLocal.setText(local);
        });

        mas2Local.setOnClickListener( view -> {
            int puntuacionLocal = Integer.parseInt(puntosLocal.getText().toString());
            int nLocal = puntuacionLocal+2;
            String local = String.valueOf(nLocal);
            puntosLocal.setText(local);
        });

        next.setOnClickListener( view -> {
            int puntuacionLocal = Integer.parseInt(puntosLocal.getText().toString());
            int puntuacionVisitante = Integer.parseInt(puntosVisitante.getText().toString());
            Intent intent = new Intent(MainActivity.this,ResultadoActivity.class);
            intent.putExtra("plocal",puntuacionLocal);
            intent.putExtra("pvisitante",puntuacionVisitante);
            startActivity(intent);
        });

        reset.setOnClickListener( view -> {
            puntosLocal.setText("0");
            puntosVisitante.setText("0");
        });
    }

}