package com.juan.registrodesocios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView nombreSocio = findViewById(R.id.tvNombre);
        TextView apellidoSocio = findViewById(R.id.tvApellido);
        TextView bioSocio = findViewById(R.id.tvBio);
        RatingBar puntuacion = findViewById(R.id.rbPuntuacion);

        //recogemos la informacion procedente del main activity
        Bundle extras = getIntent().getExtras();
        //obtenemos el objeto
        Socio nuevoSocio = extras.getParcelable("nuevoScoio");

        //nombreSocio.setText(extras.getString("nombreSocio"));

        //enlazamos cada campo con el dato qur corresponde
        nombreSocio.setText(nuevoSocio.getNombre());
        apellidoSocio.setText(nuevoSocio.getApellidos());
        bioSocio.setText(nuevoSocio.getBiografia());
        puntuacion.setRating(nuevoSocio.getPuntuacion());

    }
}