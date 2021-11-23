package com.juan.copscaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.juan.copscaps.modosdejuego.clasico.Pregunta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Splash extends AppCompatActivity {
    ArrayList<String> Tips = new ArrayList<>();

    File txtPalabras = new File("src/main/res/raw/palabras.txt");

    List<Pregunta> preguntas = new ArrayList<Pregunta>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        String linea;

        try{
            BufferedReader reader = new BufferedReader(new FileReader(txtPalabras));
                while ((linea=reader.readLine())!=null){
                    String [] campos = linea.split(",");
                }

        } catch (IOException e){

        }



        String consejo = "Recuerda que las agudas acabadas en -s, -n, o vocal se acentuan";
        Tips.add(consejo);
        consejo="Recuerda que debes acentuar las esdrújulas";
        Tips.add(consejo);
        consejo="Recuerda diferenciar las v y las b correctamente";
        Tips.add(consejo);
        consejo="Recuerda que hay palabras que llevan h y no lo sabes";
        Tips.add(consejo);
        consejo="Recuerda leer bien las preguntas";
        Tips.add(consejo);

        TextView txtconsejo=findViewById(R.id.txtSplash);

        Random r = new Random();
        int valorDado = r.nextInt(6);

        txtconsejo.setText(Tips.get(valorDado));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(Splash.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        },3000);
    }
}