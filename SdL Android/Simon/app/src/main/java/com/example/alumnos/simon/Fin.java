package com.example.alumnos.simon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.TextView;

public class Fin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);
        Integer puntaje = getIntent().getExtras().getInt("puntaje");
        TextView t = (TextView) findViewById(R.id.puntos);
        t.setText("El puntaje es de "+ puntaje.toString());
    }

    public void volver(View view){
        this.finish();
    }
}
