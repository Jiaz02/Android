package com.juan.retrofitv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView myJsonTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myJsonTextView = findViewById(R.id.jsonTextsonText);
        //1- creamods una instancia de retrofit
        Retrofit retrofit = new Retrofit.Builder()
            //2- ponemos la url base
            .baseUrl("https://jsonplaceholder.typicode.com/")
                //3- necesitamos añadir un converter a esta response
            .addConverterFactory(GsonConverterFactory.create())
                .build();
        //4- llamamos a la interzar con create y a la clase de la interfaz
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        //5- creamos un call del tipo de modelo de datos del tipo que vamos a recuperar
        Call<List<Post>> call = jsonPlaceHolderApi.obtenerPostDeLaApi();
        //6- el execute lo ara en el main Thread y no es recomendable hacerlo
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                //7- manejamos la respuesta exitosa
                if(!response.isSuccessful()){
                    //no es un problema de tipo Failure, sino cualqueir codigo http que no sea el 200
                    myJsonTextView.setText("codigo "+response.code());
                    return;
                }
                //9- creamoos una lista que tenga los post
                List<Post> listaPost = response.body();
                //10- creamos un for para recuperar los elementos de la lista
                for(Post post: listaPost){
                    String content ="";
                    content+="userIde"+post.getUserId()+"\n";
                    content+="id"+post.getId()+"\n";
                    content+="tittle"+post.getTitle()+"\n";
                    content+="body"+post.getBody()+"\n"+"\n"+"\n";
                    myJsonTextView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                //8- aqui se manejan los errores si no se ha traido bien la respuesta
                myJsonTextView.setText(t.getMessage());
            }
        });

    }
}