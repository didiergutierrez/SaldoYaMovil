package com.example.saldoya.api.deserializadores;

import com.example.saldoya.api.modelos.SaldoResponseApiRest;
import com.example.saldoya.bd.modelo.Saldo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DeserializadorResponseApiRest implements JsonDeserializer<SaldoResponseApiRest> {

    @Override
    public SaldoResponseApiRest deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonArray jsonArray= json.getAsJsonObject().getAsJsonArray(JsonKeysApiRest.MEDIA_ARRAY);

        Gson gson= new Gson();
        SaldoResponseApiRest saldoResponseApiRest= gson.fromJson(json, SaldoResponseApiRest.class);
        saldoResponseApiRest.setSaldoArrayList(deserializarJsonContactos(jsonArray));

        return saldoResponseApiRest;
    }

    private ArrayList<Saldo> deserializarJsonContactos(JsonArray jsonArray) {

        ArrayList<Saldo> saldoArrayList= new ArrayList<>();

        for(int i=0; i < 1; i++){

            JsonObject jsonObject= jsonArray.get(i).getAsJsonObject();

            String id= jsonObject.get(JsonKeysApiRest.MEDIA_ID).getAsString();
            String imagen= jsonObject.get(JsonKeysApiRest.MEDIA_IMAGEN).getAsString();
            String nombre= jsonObject.get(JsonKeysApiRest.MEDIA_NOMBRE).getAsString();
            String especie= jsonObject.get(JsonKeysApiRest.MEDIA_ESPECIES).getAsString();



            Saldo saldo= new Saldo();
            saldo.setId(id);
            saldo.setCedula(nombre);
            saldo.setSaldo(especie);
            saldoArrayList.add(saldo);
        }

        return saldoArrayList;
    }
}
