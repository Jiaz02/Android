package com.juan.copscaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Splash extends AppCompatActivity {
    ArrayList<String> Tips = new ArrayList<>();
    File fichero = new File("com/juan/copscaps/data/palabras.txt");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);






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
//enviamos 0 a correctas e incorrectas para que pueda iniciar el juego

                Intent intent = new Intent(Splash.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        },4000);
    }
}