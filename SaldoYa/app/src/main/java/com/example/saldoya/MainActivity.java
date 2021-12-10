package com.example.saldoya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //String usuario;
    private Button b_login;
    //private TextView lbl_Crear_Cuenta, lbl_Registrar_Saldo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Buscamos el botón y se guarda en la variable
        b_login=findViewById(R.id.b_login);
        //lbl_Crear_Cuenta= findViewById(R.id.lbl_Crear_Cuenta);
        //lbl_Registrar_Saldo= findViewById(R.id.lbl_Registrar_Saldo);

        //Proceso o método al darle click al boton
        b_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Inicio.class);
                startActivity(intent);
            }
        });

        //lbl_Crear_Cuenta.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        Intent intent= new Intent(MainActivity.this, RegistrarEmpleado.class);
        //        startActivity(intent);
        //    }
        //});

        //lbl_Registrar_Saldo.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        Intent intent= new Intent(MainActivity.this, RegistrarSaldo.class);
        //        startActivity(intent);
        //    }
        //});

    }

}