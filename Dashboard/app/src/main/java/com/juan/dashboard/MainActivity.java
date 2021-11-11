package com.juan.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.juan.dashboard.activities.Activity_Edad;
import com.juan.dashboard.activities.Activity_Galeria;
import com.juan.dashboard.activities.Activity_Mapas;
import com.juan.dashboard.activities.Activity_Musica;
import com.juan.dashboard.activities.Activity_Quizzes;
import com.juan.dashboard.activities.Activity_Restaurantes;
import com.juan.dashboard.activities.Activity_Setings;
import com.juan.dashboard.activities.Amigos_Activity;
import com.juan.dashboard.activities.Calculadora_Activity;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rellay_calculadora,rellay_amigos,rellay_perro,rellay_quizzes,rellay_galeria,rellay_mapas,rellay_restaurantes,rellay_settings,rellay_muscica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rellay_calculadora=findViewById(R.id.rellay_calculadora);
        rellay_amigos=findViewById(R.id.rellay_amigos);
        rellay_perro=findViewById(R.id.rellay_perrete);
        rellay_quizzes=findViewById(R.id.rellay_quizzes);
        rellay_galeria=findViewById(R.id.rellay_galeria);
        rellay_mapas=findViewById(R.id.rellay_mapas);
        rellay_restaurantes=findViewById(R.id.rellay_restaurantes);
        rellay_settings=findViewById(R.id.rellay_ajustes);
        rellay_muscica=findViewById(R.id.rellay_musica);


        rellay_calculadora.setOnClickListener(view -> {
            Intent intent = new Intent(this, Calculadora_Activity.class);
            startActivity(intent);
        });
        rellay_amigos.setOnClickListener(view -> {
            Intent intent = new Intent(this, Amigos_Activity.class);
            startActivity(intent);
        });
        rellay_perro.setOnClickListener(view -> {
            Intent intent = new Intent(this, Activity_Edad.class);
            startActivity(intent);
        });
        rellay_quizzes.setOnClickListener(view -> {
            int correctas = 0;
            Intent intent = new Intent(this, Activity_Quizzes.class);
            intent.putExtra("aciertos",correctas);
            startActivity(intent);
        });
        rellay_galeria.setOnClickListener(view -> {
            Intent intent = new Intent(this, Activity_Galeria.class);
            startActivity(intent);
        });
        rellay_mapas.setOnClickListener(view -> {
            Intent intent = new Intent(this, Activity_Mapas.class);
            startActivity(intent);
        });
        rellay_restaurantes.setOnClickListener(view -> {
            Intent intent = new Intent(this, Activity_Restaurantes.class);
            startActivity(intent);
        });
        rellay_settings.setOnClickListener(view -> {
            Intent intent = new Intent(this, Activity_Setings.class);
            startActivity(intent);
        });
        rellay_muscica.setOnClickListener(view -> {
            //Intent intent = new Intent(this, Activity_Musica.class);
            //startActivity(intent);
        });
    }
}