package com.juan.marcadorbasket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView marcador = findViewById(R.id.textMarcador);
        TextView msgResultado = findViewById(R.id.txtMensajeResultado);

        Bundle extras =getIntent().getExtras();
        int pntLocal = extras.getInt("plocal");
        int pntVisitantes = extras.getInt("pvisitante");

        marcador.setText(pntLocal+"/"+pntVisitantes);

        if(pntLocal<pntVisitantes){
            msgResultado.setText("El equipo ganador es el visitante");
        } else {
            if(pntLocal>pntVisitantes){
                msgResultado.setText("El equipo ganador es el local");
            } else {
                if (pntLocal==pntVisitantes){
                    msgResultado.setText("El resultado del partido ha sido el segundo :'(");
                }
            }
        }
    }
}