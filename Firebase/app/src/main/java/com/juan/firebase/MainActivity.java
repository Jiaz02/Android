package com.juan.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity<mFirebaseAnalytics> extends AppCompatActivity {

    // Obtain the FirebaseAnalytics instance.
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Bundle bundle = new Bundle();
        bundle.putString("DAM","Aplicacion Iniciada");
        mFirebaseAnalytics.logEvent("DAM",bundle);
    }
}