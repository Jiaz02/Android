package com.juan.listapersoanlizada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.juan.listapersoanlizada.adaptadores.Adaptador;
import com.juan.listapersoanlizada.model.Entidad;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvItem;
    private Adaptador adaptador;
    private ArrayList<Entidad> arrayEntidad = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItem = findViewById(R.id.lvItem);

        llenarItem();

        //gestiomanos el evento click de la forma A
        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,DetalleActivity.class);
                intent.putExtra("item",arrayEntidad.get(position));
                startActivity(intent);
            }
        });
    }

    private void llenarItem() {

        arrayEntidad.add(new Entidad(R.drawable.dbs_1,"SS BLUES","Goku y Vegetta"));
        arrayEntidad.add(new Entidad(R.drawable.dbs_2,"SS BLUES Y SS ROSE","Goku y Black"));
        arrayEntidad.add(new Entidad(R.drawable.dbs_3,"SS HEROES 1","Personajes Nuevos"));
        arrayEntidad.add(new Entidad(R.drawable.dbs_4,"SS HEROES 2","Otros Personajes, Magin Boo"));
        arrayEntidad.add(new Entidad(R.drawable.dbs_5,"VEGETA","Sacrificio de Vegeta"));

        adaptador = new Adaptador(arrayEntidad,this);
        lvItem.setAdapter(adaptador);
    }
}