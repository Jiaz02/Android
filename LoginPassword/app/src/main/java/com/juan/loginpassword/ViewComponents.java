package com.juan.loginpassword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ViewComponents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_components);

        TextView Email = findViewById(R.id.textBienvenido);

        Bundle extras = getIntent().getExtras();

        Email.setText("Bienvenido "+ extras.getString("Email"));
    }
}