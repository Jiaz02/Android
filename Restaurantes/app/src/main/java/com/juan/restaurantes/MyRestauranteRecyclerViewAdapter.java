package com.juan.restaurantes;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.juan.restaurantes.model.Restaurante;
import com.juan.restaurantes.databinding.FragmentRestauranteBinding;

import java.util.List;


public class MyRestauranteRecyclerViewAdapter extends RecyclerView.Adapter<MyRestauranteRecyclerViewAdapter.ViewHolder> {

    private final List<Restaurante> mValues;
    // rescatamos el contexto desde el fragmento
    private Context ccx;

    public MyRestauranteRecyclerViewAdapter(Context context, List<Restaurante> items) {
        mValues = items;
        ccx = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentRestauranteBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    //METODO IMPORTANTE PORQUE REALIZA EL DIBUJADO DE LA LISTA COMPLETA
    // Es lanzado tantas veces como elementos tengamos en la lista
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        // Rescatamos los datos del elementos que ocupa la posicion "position"
        holder.mItem = mValues.get(position);
        holder.textViewNombreRestaurante.setText(mValues.get(position).getNombre());
        holder.textViewDireccionRestaurante.setText(mValues.get(position).getDireccion());
        holder.ratingBarRestaurante.setRating(mValues.get(position).getValoracion());
        // implementamos la carga de la imagen que ocupa el imageView
        Glide.with(ccx).load(mValues.get(position).getUrlFoto()).into(holder.imageViewFotoRestaurante);


    }

    // Devuelve el valor del tamaño de la lista de restaurantes
    @Override
    public int getItemCount() {
        return mValues.size();
    }

    // Esta clase mapea el diseño de los objetos del Layout donde definimos un elemento de la lista, en nuestro caso nuestro restaurante
    // coge cada elemento de nuestro layout y los asigna a una variable final del tipo que sea
    // Esta clase depende en gran medida del diseño que tengamos

    public class ViewHolder extends RecyclerView.ViewHolder {
        //cada componente que tenemos en cada fila
        public final TextView textViewNombreRestaurante;
        public final TextView textViewDireccionRestaurante;
        public final ImageView imageViewFotoRestaurante;
        public final RatingBar ratingBarRestaurante;

        public Restaurante mItem;

        //dentro de este constructor reciviremos por parametro el layout completo
        // y a partir de ese elemetno raiz podemos buscar el elemento en cuestion

        public ViewHolder(FragmentRestauranteBinding binding) {
            super(binding.getRoot());

            textViewNombreRestaurante=binding.textViewNombre;
            textViewDireccionRestaurante=binding.textViewDireccion;
            imageViewFotoRestaurante= binding.imageViewRestaurante;
            ratingBarRestaurante= binding.ratingBarValoracion;

        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewNombreRestaurante.getText() + "'";
        }
    }
}