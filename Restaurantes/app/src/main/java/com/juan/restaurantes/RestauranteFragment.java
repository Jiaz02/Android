package com.juan.restaurantes;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juan.restaurantes.model.Restaurante;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class RestauranteFragment extends Fragment {

    //Recomendacion: me declaro la variable fuera para acceder a la variable
    // fuera del onCreate
    RecyclerView recyclerView;
    MyRestauranteRecyclerViewAdapter adapterRestaurantes;

    //creamos una lista de restaurante
    List<Restaurante> restauranteList;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;


    public RestauranteFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static RestauranteFragment newInstance(int columnCount) {
        RestauranteFragment fragment = new RestauranteFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Este metodo esta asociado a un fichero xml
        View view = inflater.inflate(R.layout.fragment_restaurante_list, container, false);

        // Aque comprobamos que el elemento padre (XML) sea una insttancia de RecyclerView
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                // Gestor del Recycler por defecto. Situa los elementos uno sobre otro
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            //
            //
            //
            //

            //lista de elementos (Restaurante)
            restauranteList = new ArrayList<>();
            //añadimos los restaurantes
            restauranteList.add(new Restaurante("Ichiraku Ramen","https://f.rpp-noticias.io/2019/04/04/423142_774142.png",5.0f,"La Hoja"));
            restauranteList.add(new Restaurante("The Drunken Clam","https://spoilertime.com/wp-content/uploads/2017/10/b3.gif",4.5f,"Quahog"));
            restauranteList.add(new Restaurante("Maclaren's Pub","https://media-cdn.tripadvisor.com/media/photo-s/12/9b/3f/a2/ingresso-e-insegna-del.jpg",4.3f,"West 55th Street"));
            restauranteList.add(new Restaurante("Moe’s","https://spoilertime.com/wp-content/uploads/2017/10/b9.jpg",3.5f,"Springfield"));

            // Asociamos el adaptador al RecyclerView
            adapterRestaurantes=new MyRestauranteRecyclerViewAdapter(getActivity(),restauranteList);
            recyclerView.setAdapter(adapterRestaurantes);
        }
        return view;
    }
}