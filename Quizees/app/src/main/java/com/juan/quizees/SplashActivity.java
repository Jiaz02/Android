package com.juan.quizees;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    ImageView movileImageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        movileImageview= findViewById(R.id.imageView);
        int imageId;
//le asignamos valor a la foto del splash
        imageId=R.drawable.yisus;

        if(imageId!=0){
            movileImageview.setImageDrawable(ContextCompat.getDrawable(this,imageId));
        }
//enviamos 0 a correctas e incorrectas para que pueda iniciar el juego
        int correctas = 0;
        int incorrectas = 0;
        boolean esInicio=true;

        Intent intent = new Intent(SplashActivity.this, MainActivity.class);

        intent.putExtra("aciertos",correctas);
        intent.putExtra("errores",incorrectas);
        intent.putExtra("esinicio",esInicio);


        startActivity(intent);
        //terminamos el activity para que pueda volver a mostrarse
        finish();


    }
}