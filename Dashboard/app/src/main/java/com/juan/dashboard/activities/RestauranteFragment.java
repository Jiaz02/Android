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
            restauranteList.add(new Restaurante("Crustaceo Crugiente","data:image/jpeg;base64,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",4.3f,"Fondo de Bikini"));
            restauranteList.add(new Restaurante("Resort Tōtsuki","https://static.wikia.nocookie.net/shokugekinosoma/images/7/76/T%C5%8Dtsuki_Villa.png/revision/latest?cb=20180625052549&path-prefix=es",3.5f,"Desconocida"));

            // Asociamos el adaptador al RecyclerView
            adapterRestaurantes=new MyRestauranteRecyclerViewAdapter(getActivity(),restauranteList);
            recyclerView.setAdapter(adapterRestaurantes);
        }
        return view;
    }
}