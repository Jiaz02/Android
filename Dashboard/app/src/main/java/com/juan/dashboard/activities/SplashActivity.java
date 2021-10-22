package com.juan.dashboard.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.juan.dashboard.R;

public class SplashActivity extends AppCompatActivity {

    ImageView movileImageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setTitle("Quizzes");
        movileImageview= findViewById(R.id.imageView);
        int imageId;
//le asignamos valor a la foto del splash
        imageId=R.drawable.yisus;
        if(imageId!=0){
            movileImageview.setImageDrawable(ContextCompat.getDrawable(this,imageId));
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//enviamos 0 a correctas e incorrectas para que pueda iniciar el juego
                int correctas = 0;
                Intent intent = new Intent(SplashActivity.this,Activity_Quizzes.class);
                intent.putExtra("aciertos",correctas);
                startActivity(intent);
                finish();

            }
        },4000);



    }
}