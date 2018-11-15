package com.example.alumnos.simon;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MejoresPuntajes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mejores_puntajes);
        SharedPreferences preferencias = getSharedPreferences("archivo",MODE_PRIVATE);
        String pFac = ("Facil: "+preferencias.getInt("facil",0));
        String pMed = ("Medio: "+preferencias.getInt("medio",0));
        String pDif = ("Dificil: "+preferencias.getInt("dificil",0));
        TextView f = (TextView) findViewById(R.id.pfacil);
        f.setText(pFac);
        f= (TextView) findViewById(R.id.pmedio);
        f.setText(pMed);
        f = (TextView) findViewById(R.id.pdificil);
        f.setText(pDif);
    }

    public void volver(View view){
        this.finish();
    }
}
