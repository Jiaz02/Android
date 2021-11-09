package com.juan.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnEntrar);
        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextTextPassword);

        //al iniciar la aplicacion debe mostrar lo que tiene guardado en el archivo shared preferences
        //obtengo los valores que se han creado previamente
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);

        if(preferencias.getString("email","")!=""){
            Intent i = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(i);

        }
        //aqui tenemos que escribir la referencia del valor que buscamos
        //el par de comillas vacio es el valor inicial en caso de que no haya ningun valor
         editTextEmail.setText(preferencias.getString("email",""));
         editTextPassword.setText(preferencias.getString("pass",""));

         btnLogin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Guardar();
                 Toast.makeText(MainActivity.this,"Se ha salido correctamente",Toast.LENGTH_SHORT).show();
             }
         });

    }

    public void Guardar(){

        //En este caso hemos de crear el objeto nuevamente
        SharedPreferences preferencias = getSharedPreferences("datos",Context.MODE_PRIVATE);
        //editor es la clase que me sirve para modificar este archivo
        //Vamos a modificar el archivo SharedPreferences
        SharedPreferences.Editor Obj_editor = preferencias.edit();

        Obj_editor.putString("email",editTextEmail.getText().toString());
        Obj_editor.putString("pass",editTextPassword.getText().toString());
        //comit confirma que lo que acabamos de recuperar arriba lo queremos guardarsin comit no guarda nada en SharedPreferences
        Obj_editor.commit();
    }

}