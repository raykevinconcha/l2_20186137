package com.example.l2_20186137;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class cronometro extends AppCompatActivity {
    private  int segundos=0;
    private boolean contando;
    private boolean d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro);
        if(savedInstanceState!= null){
            segundos=savedInstanceState.getInt("segundos");
            contando=savedInstanceState.getBoolean("contando");
            d=savedInstanceState.getBoolean("d");
        }
        runTimer();

    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("segundos",segundos);
        savedInstanceState.putBoolean("contando",contando);
        savedInstanceState.putBoolean("d",d);
    }
    @Override
    protected void onResume(){
        super.onResume();
        if(d){
            contando=true;
        }
    }
    @Override
    protected void onPause(){
        super.onPause();
        d=contando;
        contando=false;
    }
    public void onClickIniciar(View view){
        if(!contando && segundos==0){
            contando=true;
        }
    }
    public void onClickParar(View view){
        contando=false;
    }
    public void onClickLimpiar(View view){
        contando=false;
        segundos=0;
    }
    public void onClickRetomar(View view){
        if(!contando && segundos>0){
            contando=true;
        }
    }

    private void runTimer(){
        final TextView temporizadorVista=(TextView)findViewById(R.id.temporizador_vista);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int horas=segundos/3600;
                int minutos=(segundos%3600)/60;
                int seg=segundos%60;

                String time =String.format(Locale.getDefault(),"%d:%02d:%02d",horas,minutos,seg);
                temporizadorVista.setText(time);

                if(contando){
                    segundos++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }

}