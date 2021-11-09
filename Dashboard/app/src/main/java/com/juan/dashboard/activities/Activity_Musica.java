package com.juan.dashboard.activities;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.juan.dashboard.R;
import com.juan.dashboard.activities.adaptadores.Adaptador;
import com.juan.dashboard.activities.model.DiscoMusica;

import java.util.ArrayList;

public class Activity_Musica extends AppCompatActivity {
    private ListView lvItem;
    private Adaptador adaptador;
    private ArrayList<DiscoMusica> arrayDiscos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);

        lvItem = findViewById(R.id.lvItem);

        llenarLista();

    }

    private void llenarLista() {

        arrayDiscos.add(new DiscoMusica("https://studiosol-a.akamaihd.net/uploadfile/letras/albuns/a/7/7/f/22369.jpg","Comatose","3 de octubre de 2006","Skillet"));


        adaptador = new Adaptador(arrayDiscos,this);
        lvItem.setAdapter(adaptador);
    }
}