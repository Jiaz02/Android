package com.juan.copscaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.juan.copscaps.extras.info.Activity_Info;
import com.juan.copscaps.extras.mapa.MapsActivity;
import com.juan.copscaps.modosdejuego.clasico.Activity_Clasic;
import com.juan.copscaps.modosdejuego.deadmatch.Activity_deadmatch;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rellay_clasico;
    RelativeLayout rellar_mapa;
    RelativeLayout rellar_info;
    RelativeLayout rellar_dead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Para introducir el mapa, hacer que salga la ubicacion de la rae

        rellay_clasico=findViewById(R.id.rellay_clasico);
        rellar_mapa = findViewById(R.id.rellay_mapa);
        rellar_info = findViewById(R.id.rellay_info);
        rellar_dead = findViewById(R.id.rellay_deadmatch);

        rellay_clasico.setOnClickListener(view -> {
            Intent intent = new Intent(this, Activity_Clasic.class);
            startActivity(intent);
        });
        rellar_mapa.setOnClickListener(view -> {
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
        });
        rellar_info.setOnClickListener(view -> {
            Intent intent = new Intent(this, Activity_Info.class);
            startActivity(intent);
        });
        rellar_dead.setOnClickListener(view -> {
            Intent intent = new Intent(this, Activity_deadmatch.class);
            startActivity(intent);
        });
    }


}