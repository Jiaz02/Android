package com.juan.dashboard.activities.model;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.juan.dashboard.R;

public class Activity_DetalleMusica extends AppCompatActivity {

    private TextView titulo,fecha,autor;
    private ImageView imgFoto;
    private DiscoMusica disco;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_musica);

        disco = (DiscoMusica) getIntent().getSerializableExtra("item");

        if(disco != null){
            titulo=findViewById(R.id.txt_titulo);
            imgFoto=findViewById(R.id.portada);
            fecha=findViewById(R.id.txt_fecha);
            autor=findViewById(R.id.txt_autor);

            titulo.setText(disco.getNombre());
            fecha.setText(disco.getAñoLanzamiento());
            autor.setText(disco.getArtista());
            Glide.with(context).load(disco.getImgFoto()).into(imgFoto);

        }

    }
}