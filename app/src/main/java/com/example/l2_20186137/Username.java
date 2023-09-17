package com.example.l2_20186137;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Username extends AppCompatActivity {
    Button cronometro;
    Button contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);
        cronometro = (Button) findViewById(R.id.button3);
        contador = (Button) findViewById(R.id.button4);
        cronometro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Username.this, cronometro.class);
                startActivity(i);

            }
        });
        contador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(Username.this, Contador.class);
                startActivity(j);
            }
        });
    }

    }
