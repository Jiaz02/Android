package com.juan.registrodesocios;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    private Bitmap fotoScocioTomada;
    private ImageView socioImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGuardar= findViewById(R.id.boton_guardar);
        EditText etNombre = findViewById(R.id.nombre_socio);
        EditText etApellido = findViewById(R.id.apellido_socio);
        EditText etBio = findViewById(R.id.editTextBio);
        RatingBar rtBar = findViewById((R.id.ratingBar));


        //creamos una variable del tipo imagen
        socioImagen = findViewById(R.id.socio_imagen);
        //implementamos el listener
        socioImagen.setOnClickListener( v -> {
            abrirCamara();
        });

        btnGuardar.setOnClickListener(view ->{

            String nombreSocio = etNombre.getText().toString();
            String apellidoSocio = etApellido.getText().toString();
            Float puntuacion = rtBar.getRating();
            String bioSocio =etBio.getText().toString();

            //nos creamos el intent irDetalle
            Intent irDetalle = new Intent(this, DetailActivity.class);

            //añadimos toda la informacion que queremos pasar
            //irDetalle.putExtra("nombreSocio",nombreSocio);
            //irDetalle.putExtra("apellidoSocio",apellidoSocio);
            //irDetalle.putExtra("bioSocio",bioSocio);
            //irDetalle.putExtra("puntuacion",puntuacion);

            //creamos un objeto socio con los datos que corresponden
            Socio nuevoSocio=new Socio(
                nombreSocio,
                apellidoSocio,
                bioSocio,
                puntuacion
            );

            //enviamos el objeto al intent
            irDetalle.putExtra("nuevoScoio",nuevoSocio);

            //nos vamos al detail activity
            startActivity(irDetalle);

        });
    }

    private void abrirCamara() {
        Intent camaraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camaraIntent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == Activity.RESULT_OK && requestCode == 1000){
            if (data != null){
                fotoScocioTomada=data.getExtras().getParcelable("data");
                socioImagen.setImageBitmap(fotoScocioTomada);
            }
        }
    }
}
//