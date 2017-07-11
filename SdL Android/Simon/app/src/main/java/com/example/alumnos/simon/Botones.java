package com.example.alumnos.simon;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;


public class Botones extends AppCompatActivity {

    boolean ok=true;
    ArrayDeque<Integer> cola= new ArrayDeque<Integer>();
    int tiempo;
    int resta;
    int dificultad;
    int sound1;
    int sound2;
    int sound3;
    int sound4;
    SoundPool sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botones);
        Bundle datos = getIntent().getExtras();
        sp = new SoundPool( 5, AudioManager.STREAM_MUSIC , 0);
        sound1 = sp.load(this,R.raw.boton1,1);
        sound2 = sp.load(this,R.raw.boton2,1);
        sound3 = sp.load(this,R.raw.boton3,1);
        sound4 = sp.load(this,R.raw.boton4,1);
        if(datos!=null){
            tiempo=datos.getInt("tiempo");
            resta=datos.getInt("resta");
            if(resta!=0){
                dificultad = 2;
            }
            else{
                if(tiempo==500){
                    dificultad = 1;
                }
                else dificultad = 0;
            }
            cola.add(-1);
            iniciarTimer();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu_ppal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.dificil){
            Intent i = new Intent(this,Botones.class);
            i.putExtra("tiempo",700);
            i.putExtra("resta",50);
            startActivity(i);
            this.finish();
        }
        if(item.getItemId() == R.id.medio){
            Intent i = new Intent(this,Botones.class);
            i.putExtra("tiempo",500);
            i.putExtra("resta",0);
            startActivity(i);
            this.finish();
        }
        if(item.getItemId() == R.id.facil){
            Intent i = new Intent(this,Botones.class);
            i.putExtra("tiempo",750);
            i.putExtra("resta",0);
            startActivity(i);
            this.finish();
        }
        if(item.getItemId() == R.id.salir){
            this.finish();
        }
        if(item.getItemId() == R.id.mejPuntajes){
            Intent i = new Intent(this,MejoresPuntajes.class);
            startActivity(i);
            this.finish();
        }
        return true;
    }

    Random r = new Random();
    boolean botPrendido=false;
    int nextNum;
    Integer puntaje=0;

    public void onClick(View view){
        if(!ok){
            int boton = 0;
            switch (view.getId()){
                case R.id.bot0:
                    boton=0;
                    break;
                case R.id.bot1:
                    boton=1;
                    break;
                case R.id.bot2:
                    boton=2;
                    break;
                case R.id.bot3:
                    boton=3;
                    break;
            }
            final int bot = boton;
            prenderBot(bot);
            final Handler prendido = new Handler();
            prendido.postDelayed(new Runnable() {
                @Override
                public void run() {
                    apagarBot(bot);
                }
            },75);
            if(cola.peek()==bot){
                cola.removeFirst();
                cola.add(bot);
                if(cola.peek()==-1){
                    puntaje++;
                    cola.add(-1);
                    ok= true;
                    cola.removeFirst();
                    if (tiempo > 150){
                        tiempo= tiempo-resta;
                    }
                    iniciarTimer();
                }
            }else{
                Intent i = new Intent(this,Fin.class);
                i.putExtra("puntaje",puntaje);
                i.putExtra("dificultad",dificultad);
                startActivity(i);
                this.finish();
            }
        }
    }

    Handler handler = new Handler();
    Runnable runnable;
    protected void iniciarTimer(){
        TextView text = (TextView) findViewById(R.id.punto);
        text.setText(puntaje.toString());
        handler.postDelayed(runnable= new Runnable() {
            @Override
            public void run() {
                if(!botPrendido) {
                    if (ok) {
                        if (cola.peek()==-1) {
                            cola.removeFirst();
                            nextNum = r.nextInt(4);
                            prenderBot(nextNum);
                            botPrendido=true;
                            cola.add(nextNum);
                            cola.add(-1);
                            ok=false;
                        }else{
                            nextNum=cola.poll();
                            prenderBot(nextNum);
                            cola.add(nextNum);
                            botPrendido=true;
                        }
                    }
                }else{apagarBot(nextNum);
                    botPrendido= false;
                }if (ok || botPrendido){
                handler.postDelayed(this, tiempo);}
            }
        }, tiempo);
    }

    protected void prenderBot(int numB){
        Button b;
        switch (numB){
            case 0: b=(Button) findViewById(R.id.bot0);
                b.setBackgroundColor(getResources().getColor(R.color.verde));
                sp.play(sound1,1,1,1,0,0);
                break;
            case 1: b=(Button) findViewById(R.id.bot1);
                b.setBackgroundColor(getResources().getColor(R.color.rojo));
                sp.play(sound2,1,1,1,0,0);
                break;
            case 2: b=(Button) findViewById(R.id.bot2);
                b.setBackgroundColor(getResources().getColor(R.color.amarillo));
                sp.play(sound3,1,1,1,0,0);
                break;
            case 3: b=(Button) findViewById(R.id.bot3);
                b.setBackgroundColor(getResources().getColor(R.color.azul));
                sp.play(sound4,1,1,1,0,0);
                break;
        }
    }

    protected void apagarBot(int numB){
        Button b;
        switch (numB){
            case 0: b=(Button) findViewById(R.id.bot0);
                b.setBackgroundColor(getResources().getColor(R.color.verde_apagado));
                sp.stop(sound1);
                break;
            case 1: b=(Button) findViewById(R.id.bot1);
                b.setBackgroundColor(getResources().getColor(R.color.rojo_apagado));
                sp.stop(sound2);
                break;
            case 2: b=(Button) findViewById(R.id.bot2);
                b.setBackgroundColor(getResources().getColor(R.color.amarillo_apagado));
                sp.stop(sound3);
                break;
            case 3: b=(Button) findViewById(R.id.bot3);
                b.setBackgroundColor(getResources().getColor(R.color.azul_apagado));
                sp.stop(sound4);
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Puntaje",puntaje);
        outState.putInt("Tiempo",tiempo);
        outState.putInt("Resta",resta);
        outState.putInt("Nextnum",nextNum);
        outState.putBoolean("Ok",ok);
        outState.putBoolean("Botprendido",botPrendido);
        ArrayList<Integer> Ctemp = new ArrayList<Integer>();
        while (cola.peek()!=null){
            Ctemp.add(cola.poll());
        }
        outState.putIntegerArrayList("Cola",Ctemp);
}

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        puntaje = savedInstanceState.getInt("Puntaje");
        tiempo = savedInstanceState.getInt("Tiempo");
        resta = savedInstanceState.getInt("Resta");
        TextView text = (TextView) findViewById(R.id.punto);
        text.setText(puntaje.toString());
        nextNum = savedInstanceState.getInt("Nextnum");
        ok = savedInstanceState.getBoolean("Ok");
        botPrendido = savedInstanceState.getBoolean("Botprendido");
        ArrayList<Integer> Ctemp = savedInstanceState.getIntegerArrayList("Cola");
        cola.clear();
        for ( int i = 0; i< Ctemp.size(); i++){
            cola.add(Ctemp.get(i));
        }
        if (botPrendido){
            prenderBot(nextNum);
        }

    }
}
