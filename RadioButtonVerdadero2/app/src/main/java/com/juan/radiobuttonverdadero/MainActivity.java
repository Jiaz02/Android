package com.juan.radiobuttonverdadero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup rp = findViewById(R.id.RadioGroupSexo);
        RadioButton rpHombre = findViewById(R.id.radioButtonhombre);
        RadioButton rpMujer = findViewById(R.id.radioButtonMujer);
        RadioButton rpIndefinido = findViewById(R.id.radioButtonRaritos);

    }

    public void sexoSeleccionado(View view) {

        switch (view.getId()){
            case R.id.radioButtonhombre:
                Toast.makeText(this,"Has seleccionado hombre",Toast.LENGTH_LONG).show();
                break;
            case R.id.radioButtonMujer:
                Toast.makeText(this,"Has seleccionado mujer",Toast.LENGTH_LONG).show();
                break;
            case R.id.radioButtonRaritos:
                Toast.makeText(this,"Has decidido ser un rarito",Toast.LENGTH_LONG).show();
                break;
        }

    }
}