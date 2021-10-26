package com.juan.listapersoanlizada.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.juan.listapersoanlizada.DetalleActivity;
import com.juan.listapersoanlizada.R;
import com.juan.listapersoanlizada.model.Entidad;

import java.util.ArrayList;
//4- extendemos BaseAdaptr e importamos metodos
public class Adaptador extends BaseAdapter {
    // 1- creamos el array list de entidad que seran los datos a mostrar
    private ArrayList<Entidad> listEntidad;

    // 2- Creamos un contexto
    private Context context;
    private LayoutInflater inflater;

    //3- generamos el constructor
    public Adaptador(ArrayList<Entidad> listEntidad, Context context) {
        this.listEntidad = listEntidad;
        this.context = context;
    }

    //Metodo que indica al ListView los cuantos datos van a cargar
    @Override
    public int getCount() {
        return listEntidad.size();
    }

    //Metodo que devuelve la posicion
    @Override
    public Object getItem(int position) {
        return listEntidad.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    //aqui se creara cada item y se asigngara los valores para cada delemento de cada item
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        //Obtenemos el objeto pro cada item a mostrar
        final Entidad entidad = (Entidad) getItem(position);

        //creamos e inicializamos los elementos del item de la lista
        convertView = LayoutInflater.from(context).inflate(R.layout.item,null);


        ImageView imgFoto = convertView.findViewById(R.id.imgFoto);
        TextView tvTitulo = convertView.findViewById(R.id.tvTitulo);
        TextView tvContenido = convertView.findViewById(R.id.tvContenido);

        //llenamos los elementos con los valores de cada item
        imgFoto.setImageResource(entidad.getImgFoto());
        tvTitulo.setText(entidad.getTitulo());
        tvContenido.setText(entidad.getContenido());


        //Gestionamos el evento click de la forma B
        convertView.setOnClickListener( v -> {

            Intent i = new Intent(context, DetalleActivity.class);
            i.putExtra("item",entidad);
            context.startActivity(i);
        });

        return convertView;
    }
}
