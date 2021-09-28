package com.juan.a3_variosactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnIrAc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIrAc2 = findViewById(R.id.btn1);

        btnIrAc2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        //Para cambiar de activity lo primero que haremos sera crear el Inten
        //1--le diremos en el primer campo desde dodne le llamamos y en el segundo a donde queremos ir
        Intent irAACtivity2 = new Intent(MainActivity.this,Segundaactivity.class);

        //2--Lanzamos el activitycon el metodo startActivity
        startActivity(irAACtivity2);
    }
}