package com.juan.a1_miedadcanina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1- agregamos los id a los elementos
        EditText edadEdit = findViewById(R.id.edad_et);
        TextView resultadoText = findViewById(R.id.resultado_et);
        Button boton = findViewById(R.id.button_btn);

        //2- Damos actividad al boton al ser pulsado
        boton.setOnClickListener( view -> {
            //3- recogemos el texto del edit text
            String edad = edadEdit.getText().toString();
            //4- convertimos el string a entero
            int edadInt =Integer.parseInt(edad);
            //5- Calculamos la edad canina
            int resultado = edadInt * 7;
            //6- creamos el texto que vamos a mostrar
            String resultadoString = "Si fueras un perro tu edad sería "+resultado+" años";
            //7- asignamos el texto al elemento textview
            resultadoText.setText(resultadoString);

        });
    }
}