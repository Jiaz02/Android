package com.juan.copscaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.juan.copscaps.modosdejuego.clasico.Activity_Clasic;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rellay_clasico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rellay_clasico=findViewById(R.id.rellay_clasico);
        rellay_clasico.setOnClickListener(view -> {
            Intent intent = new Intent(this, Activity_Clasic.class);
            startActivity(intent);
        });
    }


}