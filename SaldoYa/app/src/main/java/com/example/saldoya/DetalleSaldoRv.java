package com.example.saldoya;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saldoya.bd.modelo.Saldo;

import java.util.ArrayList;

public class DetalleSaldoRv extends AppCompatActivity {

    private RecyclerView rv_detalle;
    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private ListAdapter adaptadorListAdapter;
    private ArrayList<Saldo> saldos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_saldo_rv);

        rv_detalle=findViewById(R.id.rv_detalleSaldo);



        linearLayoutManager= new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        gridLayoutManager= new GridLayoutManager(this, 2);

        rv_detalle.setLayoutManager(linearLayoutManager);

        saldos = new ArrayList<Saldo>();
        saldos.add(new Saldo("1","1","1026301447","23", "12-12-2021"));
        saldos.add(new Saldo("2","12","1026329983","3", "12-12-2021"));
        saldos.add(new Saldo("3","3","1026223333","10", "12-12-2021"));
        saldos.add(new Saldo("4","4","1026301447","30", "12-12-2021"));
        saldos.add(new Saldo("5","1","1026301447","45", "12-12-2021"));

        adaptadorListAdapter= new ListAdapter(this, saldos);

        rv_detalle.setAdapter(adaptadorListAdapter);



    }
}