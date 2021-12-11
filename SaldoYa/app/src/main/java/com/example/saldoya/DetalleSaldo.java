package com.example.saldoya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.saldoya.bd.modelo.Saldo;

import java.util.ArrayList;

public class DetalleSaldo extends AppCompatActivity {

    private RecyclerView rv_inicio;
    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private ListAdapter adaptadorInicioRV;
    private ArrayList<Saldo> Saldos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_saldo);


        linearLayoutManager= new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        gridLayoutManager= new GridLayoutManager(this, 2);

        rv_inicio.setLayoutManager(gridLayoutManager);

        Saldos = new ArrayList<Saldo>();
        Saldos.add(new Saldo("1","Jesus", "3121234567", "jesus@gmail.com"));
        Saldos.add(new Saldo("2","Maria", "3127894561", "maria@gmail.com"));
        Saldos.add(new Saldo("3","Carlos", "3121245789", "carlos@gmail.com"));
        Saldos.add(new Saldo("4","Pepe", "3123165478", "pepe@gmail.com"));
        Saldos.add(new Saldo("5","Alejandro", "3129632587", "alejandro@gmail.com"));

        adaptadorInicioRV= new ListAdapter(this, Saldos);

        rv_inicio.setAdapter(adaptadorInicioRV);
    }
}