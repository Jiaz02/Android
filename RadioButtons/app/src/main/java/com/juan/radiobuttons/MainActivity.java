package com.juan.radiobuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox cbFutbol = findViewById(R.id.cBFutbol);
        CheckBox cbBaloncesto = findViewById(R.id.cBBaloncesto);
        CheckBox cbPadel = findViewById(R.id.cBPadel);
    }

    public void clickOnHobby(View view) {
        switch (view.getId()){
            case R.id.cBFutbol:
                Toast.makeText(this,"Futbol ha sido seleccionado",Toast.LENGTH_LONG);
                break;
            case R.id.cBBaloncesto:
                Toast.makeText(this,"Baloncesto ha sido seleccionado",Toast.LENGTH_LONG);
                break;
            case R.id.cBPadel:
                Toast.makeText(this,"Padel ha sido seleccionado",Toast.LENGTH_LONG);
                break;
        }
    }
}