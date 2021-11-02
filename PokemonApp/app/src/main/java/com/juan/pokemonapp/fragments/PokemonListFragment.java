package com.juan.pokemonapp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.juan.pokemonapp.MainActivity;
import com.juan.pokemonapp.R;
import com.juan.pokemonapp.adapter.PokemonListAdapter;
import com.juan.pokemonapp.interfaces.iComunicaFragments;
import com.juan.pokemonapp.model.Pokemon;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PokemonListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PokemonListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ListView lvPokemon;
    private PokemonListAdapter adaptador;
    private ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();

    //Declara la interfaz que voy a utilizar
    iComunicaFragments interfaz;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PokemonListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        interfaz = (iComunicaFragments) context;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PokemonListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PokemonListFragment newInstance(String param1, String param2) {
        PokemonListFragment fragment = new PokemonListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //1- creamos una vista que es la que vamos a retornar
        View view = inflater.inflate(R.layout.fragment_pokemon_list, container, false);
        //2- A partir de este view vamos a obtener todos los views del Fragment
        lvPokemon = view.findViewById(R.id.pokemon_listView);
        //3- Traemos el resto de codigo del MAINACTIVITY
        pokemonList.add(new Pokemon("1","Bulbasaur","https://i.pinimg.com/736x/98/11/e1/9811e12a04a17b6052578f7c3264009c.jpg",R.raw.bulbasaur,Pokemon.Type.PLANT));
        pokemonList.add(new Pokemon("2","Ivysaur","https://i.pinimg.com/originals/d2/77/ac/d277ac58965a2ea9d58bd1324303ed11.jpg",R.raw.ivysaur,Pokemon.Type.PLANT));
        pokemonList.add(new Pokemon("3","Venasaur","https://scontent-mad1-1.xx.fbcdn.net/v/t1.6435-9/86189222_645142216027520_8275746803605831680_n.jpg?_nc_cat=101&ccb=1-5&_nc_sid=0debeb&_nc_ohc=FYbZ-vHzL0gAX9CkBf-&_nc_ht=scontent-mad1-1.xx&oh=02250f183fdb23e87240834154c47bb2&oe=61A590E7",R.raw.venuasaur,Pokemon.Type.PLANT));
        pokemonList.add(new Pokemon("4","Charmander","https://sm.ign.com/t/ign_latam/news/p/pokemon-ci/pokemon-cinematic-universe-a-possibility-after-detective-pik_x5k5.1200.jpg",R.raw.charmander,Pokemon.Type.FIRE));
        pokemonList.add(new Pokemon("5","Charmeleon","https://cdna.artstation.com/p/assets/images/images/020/678/630/large/marcus-whinney-01.jpg?1568741012&dl=1",R.raw.charmeleon,Pokemon.Type.FIRE));
        pokemonList.add(new Pokemon("6","Charizar","https://static.wikia.nocookie.net/detective-pikachu/images/6/69/Charizard.jpg/revision/latest?cb=20190531182134&path-prefix=es",R.raw.charizard,Pokemon.Type.FIRE));
        pokemonList.add(new Pokemon("7","Squirtle","https://i0.wp.com/lopezdoriga.com/wp-content/uploads/2019/04/squirtle.jpg?resize=980%2C550&ssl=1",R.raw.squirtle,Pokemon.Type.WATER));
        pokemonList.add(new Pokemon("8","Wartortle","https://i.pinimg.com/originals/18/a0/2b/18a02bd04132e152e7fb84fba5b039c8.jpg",R.raw.blastoise,Pokemon.Type.WATER));
        pokemonList.add(new Pokemon("9","Blastoise","https://i.ytimg.com/vi/Crm29pKO0N4/maxresdefault.jpg",R.raw.blastoise,Pokemon.Type.WATER));
        pokemonList.add(new Pokemon("10","Pikachu","https://estaticos-cdn.elperiodico.com/clip/813cc6af-fe7a-4995-9268-15303ebfca91_alta-libre-aspect-ratio_default_0.jpg",R.raw.pikachu,Pokemon.Type.ELECTRIC));
        pokemonList.add(new Pokemon("11","Raichu","https://pbs.twimg.com/media/EDPvHFnXYAAgoCp.jpg",R.raw.raichu,Pokemon.Type.ELECTRIC));
        //4-  Un contexto siempre va a depender de un Activity.
        // Cuando nos pida un contexto desde un fragment podemos obtenerlo con getActivity()
        adaptador = new PokemonListAdapter(getActivity(),pokemonList,R.id.item);
        lvPokemon.setAdapter(adaptador);

        lvPokemon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pokemon selectedPokemon = (Pokemon) adaptador.getItem(position);
                if (selectedPokemon != null){
                    //Toast.makeText(getActivity(),selectedPokemon.getNombre(),Toast.LENGTH_SHORT).show();
                    interfaz.enviarPokemon(selectedPokemon);
                }
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}