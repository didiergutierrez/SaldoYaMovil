package com.example.saldoya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //String usuario;
    Button b_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buscamos el botón y se guarda en la variable
        b_login=findViewById(R.id.b_login);

        //Proceso o método al darle click al boton
        b_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Inicio.class);
                startActivity(intent);
            }
        });
    }
}