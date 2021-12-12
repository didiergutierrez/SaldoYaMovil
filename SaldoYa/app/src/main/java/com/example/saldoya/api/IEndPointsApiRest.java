package com.example.saldoya.api;

import com.example.saldoya.api.modelos.SaldoResponseApiRest;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IEndPointsApiRest {
    @GET(ConstantesApiRest.GET_MEDIA_ALL)
    Call<SaldoResponseApiRest> getMedia();
}
