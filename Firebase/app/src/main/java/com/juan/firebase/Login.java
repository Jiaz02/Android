package com.juan.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login<mFirebaseAnalytics> extends AppCompatActivity {
enum ProviderType{
    BASIC,GOOGLE,FACEBOOK
}
    // Obtain the FirebaseAnalytics instance.
    private FirebaseAnalytics mFirebaseAnalytics;
    // creamos la instancia
    private FirebaseAuth mAuth;

    EditText etEmail,etPassword;
    Button btnRegister,btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail=findViewById(R.id.emaileditText);
        etPassword=findViewById(R.id.passwordeditText);

        btnLogin=findViewById(R.id.loginbtn);
        btnRegister=findViewById(R.id.registerbtn);

        setTitle("Login");
        // esto es todo del analytics
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString("DAM","Aplicacion Iniciada");
        mFirebaseAnalytics.logEvent("DAM",bundle);


        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registroUsuarioEmailPass();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loguearseWithEmailAndPassword();
            }
        });
    }

    private void loguearseWithEmailAndPassword() {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        if (!email.isEmpty() && !password.isEmpty()){
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("FIREBASE", "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                irAHome(email,ProviderType.BASIC);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("FIREBASE", "signInWithEmail:failure", task.getException());
                                Toast.makeText(Login.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        } else {
            Toast.makeText(Login.this, "Hay uno o mas campos en blanco", Toast.LENGTH_SHORT).show();
        }
    }

    private void irAHome(String email, ProviderType tipologueo) {
        Intent i = new Intent(this,HomeActivity.class);
        i.putExtra("email",email);
        i.putExtra("metodo",tipologueo);
        startActivity(i);
    }

    private void registroUsuarioEmailPass() {
        String _email = etEmail.getText().toString();
        String _password = etPassword.getText().toString();

        if ( !_email.isEmpty() && !_password.isEmpty() ){
            // Si el email y el passwor introducido no estan vacios
            mAuth.createUserWithEmailAndPassword( _email, _password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if ( task.isSuccessful() ){
                                // El registro es satisfactorio
                                Log.i("FIREBASE","El usuario ha sido creado correctamente");
                                Toast.makeText(Login.this, "El Usuario SE HA CREADO Satisfactoriamente", Toast.LENGTH_LONG).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                            } else {
                                Log.w("FIREBASE", "createUserWithEmailAndPassword: failure", task.getException());
                                Toast.makeText(Login.this, "Ha fallado el CREARSE un usuario", Toast.LENGTH_LONG).show();
                            }

                        }
                    });
        } else {
            Toast.makeText(Login.this, "Hay uno o mas campos en blanco", Toast.LENGTH_SHORT).show();
        }
    }
}