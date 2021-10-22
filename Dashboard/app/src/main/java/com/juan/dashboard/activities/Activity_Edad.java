package com.juan.dashboard.activities;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.juan.dashboard.R;


public class Activity_Edad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edad);
        setTitle("Edad Canina");
        //1- agregamos los id a los elementos
        EditText edadEdit = findViewById(R.id.edad_et);
        TextView resultadoText = findViewById(R.id.resultado_et);
        Button boton = findViewById(R.id.button_btn);

        //Log.v("MainActivity", "La actividad principal se ha creado");
        Log.d("MainActivity", "La actividad principal se ha creado");
        //Log.i("MainActivity", "La actividad principal se ha creado");
        //Log.w("MainActivity", "La actividad principal se ha creado");
        //Log.e("MainActivity", "La actividad principal se ha creado");

        //2- Damos actividad al boton al ser pulsado
        boton.setOnClickListener( view -> {
            //3- recogemos el texto del edit text
            String edad = edadEdit.getText().toString();

            if (!edad.isEmpty()) {

                //4- convertimos el string a entero
                int edadInt = Integer.parseInt(edad);
                //5- Calculamos la edad canina
                int resultado = edadInt * 7;
                //6- creamos el texto que vamos a mostrar
                String resultadoString = getString(R.string.texto_resultado2,resultado);
                //7- asignamos el texto al elemento textview
                resultadoText.setText(resultadoString);
            } else{
                Log.d("MainActivity","Has introducido un campo vacio");
                Toast.makeText(this, getString(R.string.msg_toast3),Toast.LENGTH_LONG).show();

            }
        });
    }
}