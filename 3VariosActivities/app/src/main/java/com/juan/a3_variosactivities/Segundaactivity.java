package com.juan.a3_variosactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Segundaactivity extends AppCompatActivity implements View.OnClickListener {

    Button btnIrAc1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundaactivity);

        btnIrAc1 = findViewById(R.id.btn2);

        btnIrAc1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //Para cambiar de activity lo primero que haremos sera crear el Intent
        //1--le diremos en el primer campo desde dodne le llamamos y en el segundo a donde queremos ir
        Intent irAACtivity1 = new Intent(Segundaactivity.
                this,MainActivity.class);

        //2--Lanzamos el activitycon el metodo startActivity
        startActivity(irAACtivity1);
    }
}