package com.juan.pokemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.juan.pokemonapp.adapter.PokemonListAdapter;
import com.juan.pokemonapp.model.Pokemon;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvPokemon;
    private PokemonListAdapter adaptador;
    private ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPokemon = findViewById(R.id.pokemon_listView);

        pokemonList.add(new Pokemon("1","Bulbasaur",Pokemon.Type.PLANT));
        pokemonList.add(new Pokemon("2","Ivysaur",Pokemon.Type.PLANT));
        pokemonList.add(new Pokemon("3","Venasaur",Pokemon.Type.PLANT));
        pokemonList.add(new Pokemon("4","Charmander",Pokemon.Type.FIRE));
        pokemonList.add(new Pokemon("5","Charmeleon",Pokemon.Type.FIRE));
        pokemonList.add(new Pokemon("6","Charizar",Pokemon.Type.FIRE));
        pokemonList.add(new Pokemon("7","Squirtle",Pokemon.Type.WATER));
        pokemonList.add(new Pokemon("8","Blastoise",Pokemon.Type.WATER));
        pokemonList.add(new Pokemon("9","Pikachu",Pokemon.Type.ELECTRIC));
        pokemonList.add(new Pokemon("10","Raichu",Pokemon.Type.ELECTRIC));

        adaptador = new PokemonListAdapter(this,pokemonList,R.id.item);
        lvPokemon.setAdapter(adaptador);

        lvPokemon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pokemon selectedPokemon = (Pokemon) adaptador.getItem(position);
                if (selectedPokemon != null){
                    Toast.makeText(MainActivity.this,selectedPokemon.getNombre(),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}