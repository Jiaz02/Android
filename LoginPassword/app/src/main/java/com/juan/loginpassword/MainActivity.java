package com.juan.loginpassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEntrar= findViewById(R.id.boton_Entrar);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etContraseña = findViewById(R.id.etContraseña);

        btnEntrar.setOnClickListener(view -> {

            String Email = etEmail.getText().toString();
            String Contraseña = etContraseña.getText().toString();
            if (!(Email.isEmpty()||Contraseña.isEmpty())) {
                Intent irSala = new Intent(this, ViewComponents.class);
                irSala.putExtra("Email", Email);
                irSala.putExtra("Contraseña", Contraseña);

                startActivity(irSala);
            }
            else{
                Log.d("MainActivity","Has introducido un campo vacio");
                Toast.makeText(this, getString(R.string.msg_toast),Toast.LENGTH_LONG).show();
            }
        });
    }
}