package com.example.alumnos.simon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Nivel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel);
    }

    public void facil(View view){
        Intent i = new Intent(this,Botones.class);
        i.putExtra("tiempo",750);
        i.putExtra("resta",0);
        startActivity(i);
    }

    public void medio(View view){
        Intent i = new Intent(this,Botones.class);
        i.putExtra("tiempo",500);
        i.putExtra("resta",0);
        startActivity(i);
    }

    public void dificil(View view){
        Intent i = new Intent(this,Botones.class);
        i.putExtra("tiempo",700);
        i.putExtra("resta",75);
        startActivity(i);
    }
}
