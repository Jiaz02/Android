package com.juan.copscaps.modosdejuego.deadmatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.juan.copscaps.R;

public class Result_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Activity_deadmatch.getListaFallos().clear();
    }
}