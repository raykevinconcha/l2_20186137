package com.example.l2_20186137;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class sing_up extends AppCompatActivity {
    private CheckBox cbAceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        cbAceptar=findViewById(R.id.cbAceptar);
        Button btncreateaccount= findViewById(R.id.buttoncreate);
        btncreateaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbAceptar.isChecked()){
                    Intent i = new Intent(sing_up.this, Username.class);
                    startActivity(i);

                }else{
                    Toast.makeText(sing_up.this,"Verifique la casilla porfavor para crear su cuenta",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}