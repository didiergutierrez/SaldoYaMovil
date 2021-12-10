package com.example.saldoya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //String usuario;
    private Button b_login;
    private TextView lbl_Crear_Cuenta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Buscamos el botón y se guarda en la variable
        b_login=findViewById(R.id.b_login);
        lbl_Crear_Cuenta= findViewById(R.id.lbl_Crear_Cuenta);


        //Proceso o método al darle click al boton
        b_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Inicio.class);
                startActivity(intent);
            }
        });

        lbl_Crear_Cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, OpcionesReg.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent intent;
        switch (item.getItemId()){
            case R.id.informacion:
                Toast.makeText(this, "Información", Toast.LENGTH_LONG).show();
                return true;
            case R.id.contacto:
                intent= new Intent(this, Contactenos.class);
                startActivity(intent);
                return true;
            case R.id.configuracion:
                Toast.makeText(this, "Configuración", Toast.LENGTH_LONG).show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}