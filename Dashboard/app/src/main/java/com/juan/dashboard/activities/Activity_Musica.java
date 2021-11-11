package com.juan.dashboard.activities;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.juan.dashboard.R;
import com.juan.dashboard.activities.adaptadores.Adaptador;
import com.juan.dashboard.activities.model.DiscoMusica;

import java.util.ArrayList;

public class Activity_Musica extends AppCompatActivity {

    private ListView lvItem;
    private Adaptador adaptador;
    private ArrayList<DiscoMusica> arrayDiscos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);
        setTitle("Spotify");
        lvItem = findViewById(R.id.lvItem);

        llenarLista();

    }

    private void llenarLista() {

        arrayDiscos.add(new DiscoMusica("https://studiosol-a.akamaihd.net/uploadfile/letras/albuns/a/7/7/f/22369.jpg","Comatose","3 de octubre de 2006","Skillet"));
        arrayDiscos.add(new DiscoMusica("https://images.squarespace-cdn.com/content/v1/587d33a54402432706c7e9e7/1546019253474-4MS3SE5LI1S8REI6FUX9/ZAyn.jpg?format=2500w","Icarus Falls","14 de diciembre de 2018","Zayn Malik"));
        arrayDiscos.add(new DiscoMusica("https://is5-ssl.mzstatic.com/image/thumb/Music114/v4/18/ea/ae/18eaaebb-e5ae-ce7f-aebf-7d9aa11231d9/859731210635_cover.jpg/600x600bf-60.jpg","Destiny: The Collection","6 de marzo de 2019","Neffex"));
        arrayDiscos.add(new DiscoMusica("https://m.media-amazon.com/images/I/81lYb4eQQ-L._SL1425_.jpg","Hybrid Theory","24 de octubre de 2000","Linkin Park"));
        arrayDiscos.add(new DiscoMusica("https://img.discogs.com/1N4c7Yba0bblMS46XyOk4cUI-hs=/fit-in/600x494/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-8393847-1460755973-3600.jpeg.jpg","Anti","28 de enero de 2016","Rihanna"));
        arrayDiscos.add(new DiscoMusica("https://m.media-amazon.com/images/I/41S5bRfV7yL.jpg","Prisma","25 de octubre de 2019","Beret"));
        arrayDiscos.add(new DiscoMusica("https://www.dodmagazine.es/wp-content/uploads/2021/08/ed-sheeran-2021.jpg","=","29 de octubre de 2021","Ed Sheeran"));
        arrayDiscos.add(new DiscoMusica("https://m.media-amazon.com/images/I/51J2cHzZWmL.jpg","Save Rock and Roll","12 de abril de 2013","Fall Out Boy"));
        arrayDiscos.add(new DiscoMusica("https://m.media-amazon.com/images/I/6121zZMK6JL._SL1500_.jpg","Don't Kill the Magic","30 de junio de 2014","Magic!"));
        arrayDiscos.add(new DiscoMusica("https://m.media-amazon.com/images/I/61yp8mw1rDL._SY450_.jpg","Night Visions","4 de septiembre de 2012","Imagine Dragons"));


        adaptador = new Adaptador(arrayDiscos,this);
        lvItem.setAdapter(adaptador);
    }
}