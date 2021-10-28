package com.juan.marcadorbasket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        //tomamos los valores del cml
        TextView marcador = findViewById(R.id.textMarcador);
        TextView msgResultado = findViewById(R.id.txtMensajeResultado);
//tomamos los datos que hemos pasado del otro activity
        Bundle extras =getIntent().getExtras();
        int pntLocal = extras.getInt("plocal");
        int pntVisitantes = extras.getInt("pvisitante");
//actualizamos los datos del marcador
        marcador.setText(pntLocal+"/"+pntVisitantes);
//en funcion del resultado actualizamos el mensaje final
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