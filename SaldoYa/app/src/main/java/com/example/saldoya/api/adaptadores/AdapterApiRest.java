package com.example.saldoya.api.adaptadores;

import com.example.saldoya.api.ConstantesApiRest;
import com.example.saldoya.api.IEndPointsApiRest;
import com.example.saldoya.api.deserializadores.DeserializadorResponseApiRest;
import com.example.saldoya.api.modelos.SaldoResponseApiRest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdapterApiRest {

    public IEndPointsApiRest conexionApiRest(){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ConstantesApiRest.URL)
                .addConverterFactory(GsonConverterFactory.create(construirGsonDeserializadorMedia()))
                .build();

        return retrofit.create(IEndPointsApiRest.class);
    }

    private Gson construirGsonDeserializadorMedia() {

        GsonBuilder gsonBuilder= new GsonBuilder();
        gsonBuilder.registerTypeAdapter(SaldoResponseApiRest.class, new DeserializadorResponseApiRest());

        return gsonBuilder.create();
    }
}
