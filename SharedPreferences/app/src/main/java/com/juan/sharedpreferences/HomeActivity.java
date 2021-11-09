package com.juan.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn=findViewById(R.id.btnLogOut);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogOut();
                Toast.makeText(HomeActivity.this,"Se ha guardado correctamente",Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void LogOut(){

        //En este caso hemos de crear el objeto nuevamente
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        //editor es la clase que me sirve para modificar este archivo
        //Vamos a modificar el archivo SharedPreferences
        SharedPreferences.Editor Obj_editor = preferencias.edit();

        Obj_editor.putString("email","");
        Obj_editor.putString("pass","");
        //comit confirma que lo que acabamos de recuperar arriba lo queremos guardarsin comit no guarda nada en SharedPreferences
        Obj_editor.commit();

        Intent i = new Intent(HomeActivity.this,MainActivity.class);
        startActivity(i);
    }
}