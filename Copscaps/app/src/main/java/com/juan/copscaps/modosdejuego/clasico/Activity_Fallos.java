package com.juan.copscaps.modosdejuego.clasico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.juan.copscaps.R;
import com.juan.copscaps.modosdejuego.deadmatch.Activity_deadmatch;

public class Activity_Fallos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fallos);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Activity_Clasic.getListaFallos().clear();
        Activity_Clasic.getListaBlanco().clear();
    }
}