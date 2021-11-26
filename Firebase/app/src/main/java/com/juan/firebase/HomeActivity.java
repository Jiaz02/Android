package com.juan.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    TextView tvEmail,tvMetodo;
    Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvEmail = findViewById(R.id.emailtextview);
        tvMetodo = findViewById(R.id.metodoTextview);
        btnSalir = findViewById(R.id.logoutbtn);

        //recuperamos los datos del login
        Bundle datos = this.getIntent().getExtras();
        String email = datos.getString("email");
        String metodo = datos.getString("metodo");

        tvEmail.setText(email);
        tvMetodo.setText(metodo);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cerrar sesion
                FirebaseAuth.getInstance().signOut();
                //volver al intent anterior
                onBackPressed();
            }
        });
    }
}