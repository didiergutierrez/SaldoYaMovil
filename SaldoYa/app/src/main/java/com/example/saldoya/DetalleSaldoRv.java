package com.example.saldoya;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saldoya.api.IEndPointsApiRest;
import com.example.saldoya.api.adaptadores.AdapterApiRest;
import com.example.saldoya.api.modelos.SaldoResponseApiRest;
import com.example.saldoya.bd.modelo.Saldo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleSaldoRv extends AppCompatActivity {

    private Context contexto;
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

        dataApi();


        linearLayoutManager= new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        gridLayoutManager= new GridLayoutManager(this, 2);

        rv_detalle.setLayoutManager(linearLayoutManager);



        saldos = new ArrayList<Saldo>();
        saldos.add(new Saldo("1","1026301447","23", "12-12-2021"));
        saldos.add(new Saldo("2","1026329983","3", "12-12-2021"));
        saldos.add(new Saldo("3","1026223333","10", "12-12-2021"));
        saldos.add(new Saldo("4","1026301447","30", "12-12-2021"));
        saldos.add(new Saldo("5","1026301447","45", "12-12-2021"));

        adaptadorListAdapter= new ListAdapter(this, saldos);

        rv_detalle.setAdapter(adaptadorListAdapter);

    }

    private void dataApi() {

        AdapterApiRest adapterApiRest= new AdapterApiRest();
        IEndPointsApiRest iEndPointsApiRest= adapterApiRest.conexionApiRest();
        Call<SaldoResponseApiRest> respuestaCall= iEndPointsApiRest.getMedia();
        respuestaCall.enqueue(new Callback<SaldoResponseApiRest>() {
            @Override
            public void onResponse(Call<SaldoResponseApiRest> call, Response<SaldoResponseApiRest> response) {
                SaldoResponseApiRest saldoResponseApiRest= response.body();
                ArrayList<Saldo> saldoArrayList= saldoResponseApiRest.getSaldoArrayList();
                //metododelay();
                saldos=saldoArrayList;
            }

            @Override
            public void onFailure(Call<SaldoResponseApiRest> call, Throwable t) {
                Toast.makeText(contexto, "Error al obtener los datos", Toast.LENGTH_SHORT).show();
            }
        });
    }

//    private void metododelay() {
//        for (int i = 10; i > 0; i--) {
//            try {
//                Thread.sleep(1000);
//            }
//            catch (InterruptedException e){
//
//            }
//            Toast.makeText(contexto,"Estamos buscando su informacion en "+i+" segundos",Toast.LENGTH_LONG);
//        }


}