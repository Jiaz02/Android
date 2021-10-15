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

        setTitle("CheckBoxes");
    }

    public void clickOnHobby(View view) {

        Boolean isChecked = ((CheckBox) view).isChecked();

        switch (view.getId()){

            case R.id.cBFutbol:
                if (isChecked) {
                    Toast.makeText(this, "Futbol ha sido seleccionado", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Futbol ha sido desseleccionado", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.cBBaloncesto:
                if (isChecked) {
                    Toast.makeText(this, "Baloncesto ha sido seleccionado", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(this, "Baloncesto ha sido desseleccionado", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.cBPadel:
                if (isChecked) {
                    Toast.makeText(this, "Padel ha sido seleccionado", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(this, "Padel ha sido desseleccionado", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}