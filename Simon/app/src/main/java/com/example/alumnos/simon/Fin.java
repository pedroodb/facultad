package com.example.alumnos.simon;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Fin extends AppCompatActivity {
    String texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);
        Integer puntaje = getIntent().getExtras().getInt("puntaje");
        Integer dif = getIntent().getExtras().getInt("dificultad");
        TextView t = (TextView) findViewById(R.id.puntos);
        texto = "El puntaje es de " + puntaje.toString();
        if (actualizarPuntajes(puntaje, dif)) {
            texto += "    NUEVO RECORD";
        }
        t.setText(texto);
    }

    public void volver(View view) {
        this.finish();
    }

    private boolean actualizarPuntajes(int p, int d) {
        boolean ok = false;
        SharedPreferences preferencias = getSharedPreferences("archivo", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        switch (d) {
            case 0:
                if (preferencias.getInt("facil", 0) < p) {
                    editor.putInt("facil", p);
                    ok = true;
                }
                break;
            case 1:
                if (preferencias.getInt("medio", 0) < p) {
                    editor.putInt("medio", p);
                    ok = true;
                }
                break;
            case 2:
                if (preferencias.getInt("dificil", 0) < p) {
                    editor.putInt("dificil", p);
                    ok = true;
                }
                break;
        }
        editor.commit();
        return ok;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("texto", texto);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (texto != savedInstanceState.getString("texto")) {
            texto = savedInstanceState.getString("texto");
            TextView t = (TextView) findViewById(R.id.puntos);
            t.setText(texto);
        }
    }
}
