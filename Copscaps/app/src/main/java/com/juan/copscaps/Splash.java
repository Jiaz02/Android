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
        InputStream archivo = getResources().openRawResource(R.raw.listapalabrasbien);
        InputStream archivo2 = getResources().openRawResource(R.raw.listapalabrasmal);
        BufferedReader reader = new BufferedReader(new InputStreamReader(archivo));
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(archivo2));
        String linea;
        boolean seguir = true;

        while (seguir == true){
            try{
                String bien = getString(R.string.bien);
                String mal = getString(R.string.mal);
                linea=reader.readLine();
                String [] campos = linea.split(",");
                Pregunta p = new Pregunta(Integer.valueOf(campos[0]),campos[1],bien,mal,bien,campos[1]);
                System.out.println(p.toString());
                LogicaNegocio.listaPreguntasCorrectas.add(p);

            } catch (Exception e){
                System.out.println(e);
                seguir = false;
            }
        }

        seguir = true;
        int count = 0;
        while (seguir == true){
            try{
                String bien = getString(R.string.bien);
                String mal = getString(R.string.mal);
                linea=reader2.readLine();
                String [] campos = linea.split(",");
                Pregunta p = new Pregunta(Integer.valueOf(campos[0]),campos[1],bien,mal,mal,LogicaNegocio.getListaCorrectas().get(count).getPregunta());
                System.out.println(p.toString());
                LogicaNegocio.listaPreguntasIncorrectas.add(p);
                count++;
            } catch (Exception e){
                System.out.println(e);
                seguir = false;
            }
        }


        String consejo = getString(R.string.Tip1);
        Tips.add(consejo);
        consejo= getString(R.string.Tip2);
        Tips.add(consejo);
        consejo= getString(R.string.Tip3);
        Tips.add(consejo);
        consejo= getString(R.string.Tip4);
        Tips.add(consejo);
        consejo= getString(R.string.Tip5);
        Tips.add(consejo);

        TextView txtconsejo=findViewById(R.id.txtSplash);

        Random r = new Random();
        int valorDado = r.nextInt(Tips.size())+1;

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