package com.juan.dashboard.activities.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.juan.dashboard.R;
import com.juan.dashboard.activities.model.DiscoMusica;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private ArrayList<DiscoMusica> listDiscos;

    private Context context;
    private LayoutInflater inflater;

    public Adaptador(ArrayList<DiscoMusica> listDiscos, Context context) {
        this.listDiscos = listDiscos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listDiscos.size();
    }

    @Override
    public Object getItem(int i) {
        return listDiscos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        final DiscoMusica discoMusica = (DiscoMusica) getItem(i);

        convertView = LayoutInflater.from(context).inflate(R.layout.lista_discos_musica,null);
        ImageView imgFoto = convertView.findViewById(R.id.imgFoto);
        TextView txtNombreDisco = convertView.findViewById(R.id.txtNombreDisco);
        TextView txtArtista = convertView.findViewById(R.id.txtArtista);

        Glide.with(context).load(discoMusica.getImgFoto()).into(imgFoto);
        txtNombreDisco.setText(discoMusica.getNombre());
        txtArtista.setText(discoMusica.getArtista());

        return convertView;
    }
}
