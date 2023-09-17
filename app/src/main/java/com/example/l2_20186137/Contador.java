package com.example.l2_20186137;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Contador extends AppCompatActivity implements  ContadorEvent{
    TextView cuenta_0;
    Exception e;
    Cuenta c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);
        cuenta_0=(TextView)findViewById(R.id.cuenta_0);
    }
    public void cambio(int count){
        try {
            cuenta_0.setText(""+count);
        }catch (Exception ex){
            e=ex;
        }

    }
    public void iniciarCuenta(View view){
        c=new Cuenta();
        c.setCount(this);
        c.start();
    }


}
