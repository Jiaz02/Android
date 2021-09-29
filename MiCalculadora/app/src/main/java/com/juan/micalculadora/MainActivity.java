package com.juan.micalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText numuno = findViewById(R.id.NUM1);
        EditText numdos = findViewById(R.id.NUM2);
        TextView resultadoText = findViewById(R.id.textResultado);
        Button suma = findViewById(R.id.btnSuma);
        Button resta = findViewById(R.id.btnResta);
        Button multi = findViewById(R.id.btnMulti);
        Button div = findViewById(R.id.btnDiv);


        suma.setOnClickListener( view -> {
            //3- recogemos el texto del edit text
            String num1 = numuno.getText().toString();
            String num2 = numdos.getText().toString();
            String msgResultado=resultadoText.getText().toString();

            if (!num1.isEmpty()||!num2.isEmpty()) {
                int numero1 = Integer.parseInt(num1);
                int numero2 = Integer.parseInt(num2);
                int resultado = numero1 + numero2;
                resultadoText.setText(msgResultado+" "+resultado);
            } else{
                Log.d("MainActivity","Has introducido un campo vacio");
                Toast.makeText(this, getString(R.string.msg_toast),Toast.LENGTH_LONG).show();

            }
        });

        resta.setOnClickListener( view -> {
            //3- recogemos el texto del edit text
            String num1 = numuno.getText().toString();
            String num2 = numdos.getText().toString();
            String msgResultado=resultadoText.getText().toString();

            if (!num1.isEmpty()||!num2.isEmpty()) {
                int numero1 = Integer.parseInt(num1);
                int numero2 = Integer.parseInt(num2);
                int resultado = numero1 - numero2;
                resultadoText.setText(msgResultado+" "+resultado);
            } else{
                Log.d("MainActivity","Has introducido un campo vacio");
                Toast.makeText(this, getString(R.string.msg_toast),Toast.LENGTH_LONG).show();

            }
        });

        multi.setOnClickListener( view -> {
            //3- recogemos el texto del edit text
            String num1 = numuno.getText().toString();
            String num2 = numdos.getText().toString();
            String msgResultado=resultadoText.getText().toString();

            if (!num1.isEmpty()||!num2.isEmpty()) {
                int numero1 = Integer.parseInt(num1);
                int numero2 = Integer.parseInt(num2);
                int resultado = numero1 * numero2;
                resultadoText.setText(msgResultado+" "+resultado);
            } else{
                Log.d("MainActivity","Has introducido un campo vacio");
                Toast.makeText(this, getString(R.string.msg_toast),Toast.LENGTH_LONG).show();

            }
        });

        div.setOnClickListener( view -> {
            //3- recogemos el texto del edit text
            String num1 = numuno.getText().toString();
            String num2 = numdos.getText().toString();
            String msgResultado=resultadoText.getText().toString();

            if (!num1.isEmpty()||!num2.isEmpty()) {
                int numero1 = Integer.parseInt(num1);
                int numero2 = Integer.parseInt(num2);
                int resultado = numero1 / numero2;
                resultadoText.setText(msgResultado+" "+resultado);
            } else{
                Log.d("MainActivity","Has introducido un campo vacio");
                Toast.makeText(this, getString(R.string.msg_toast),Toast.LENGTH_LONG).show();

            }
        });


    }
}