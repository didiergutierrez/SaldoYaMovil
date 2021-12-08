package com.example.saldoya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //String usuario;
    Button b_login;
    List<ListElement> element;

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

        init();
    }
    public void init(){
        element= new ArrayList<>();
        element.add(new ListElement("12/01/2021","Tiendas Ara", "23"));
        element.add(new ListElement("16/01/2021","Tiendas Exito", "33"));
        element.add(new ListElement("21/02/2021","Tiendas Falabella", "135"));
        element.add(new ListElement("30/03/2021","Tiendas Ara", "63"));
        element.add(new ListElement("03/05/2021","Tiendas Olimpica", "77"));

        ListAdapter listAdapter= new ListAdapter(element,this);
        RecyclerView recyclerView= findViewById(R.id.listaRecyclerviewHistorial);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }
}