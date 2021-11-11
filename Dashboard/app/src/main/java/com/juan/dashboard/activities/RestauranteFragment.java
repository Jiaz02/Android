package com.juan.dashboard.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.juan.dashboard.R;
import com.juan.dashboard.activities.model.Restaurante;

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

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
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

        // Aque comprobamos que el elemento padre (XML) sea una instancia de RecyclerView
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                // Gestor del Recycler por defecto. Situa los elementos uno sobre otro
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            //lista de elementos (Restaurante)
            restauranteList = new ArrayList<>();
            //añadimos los restaurantes
            restauranteList.add(new Restaurante("Ichiraku Ramen","https://f.rpp-noticias.io/2019/04/04/423142_774142.png",5.0f,"La Hoja"));
            restauranteList.add(new Restaurante("The Drunken Clam","https://spoilertime.com/wp-content/uploads/2017/10/b3.gif",4.5f,"Quahog"));
            restauranteList.add(new Restaurante("Maclaren's Pub","https://media-cdn.tripadvisor.com/media/photo-s/12/9b/3f/a2/ingresso-e-insegna-del.jpg",4.3f,"West 55th Street"));
            restauranteList.add(new Restaurante("Moe’s","https://spoilertime.com/wp-content/uploads/2017/10/b9.jpg",3.5f,"Springfield"));
            restauranteList.add(new Restaurante("Los Pollos Hermanos","https://www.mitopbar.com/wp-content/uploads/2020/04/11213541395_4a4875a809_c.jpg",4.0f,"Albuquerque"));
            restauranteList.add(new Restaurante("Roger's Place","https://i.ytimg.com/vi/UZYtLOek_JQ/maxresdefault.jpg",4.5f,"Desconocido"));
            restauranteList.add(new Restaurante("Anteiku","https://pm1.narvii.com/7795/85b78c39b70e895e5d83a866ae426765fae54044r4-750-375_00.jpg",4.7f,"Tokyo"));
            restauranteList.add(new Restaurante("Yukihira","https://i.imgur.com/HuGo6nW.png",3.0f,"Sumiredōri Shopping District"));
            restauranteList.add(new Restaurante("Crustaceo Crugiente","http://3.bp.blogspot.com/--KWouEaPbto/U-jdomNokSI/AAAAAAAAAB8/8nPTlY1isKw/s1600/krusty-krub.jpg",4.3f,"Fondo de Bikini"));
            restauranteList.add(new Restaurante("Resort Tōtsuki","https://static.wikia.nocookie.net/shokugekinosoma/images/7/76/T%C5%8Dtsuki_Villa.png/revision/latest?cb=20180625052549&path-prefix=es",3.5f,"Desconocida"));

            // Asociamos el adaptador al RecyclerView
            adapterRestaurantes=new MyRestauranteRecyclerViewAdapter(getActivity(),restauranteList);
            recyclerView.setAdapter(adapterRestaurantes);
        }
        return view;
    }
}