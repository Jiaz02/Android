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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        InputStream archivo = getResources().openRawResource(R.raw.palabras);
        BufferedReader reader = new BufferedReader(new InputStreamReader(archivo));
        String linea;
        boolean seguir = true;

        while (seguir == true){
            try{

                linea=reader.readLine();
                String [] campos = linea.split(",");
                Pregunta p = new Pregunta(Integer.valueOf(campos[0]),campos[1],campos[2],campos[3],campos[4],campos[5]);
                System.out.println(p.toString());
                LogicaNegocio.listaPreguntas.add(p);

            } catch (Exception e){
                seguir = false;
            }
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