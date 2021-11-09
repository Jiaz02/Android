package com.juan.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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
    }
}