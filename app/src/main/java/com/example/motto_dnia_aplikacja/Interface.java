package com.example.motto_dnia_aplikacja;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Interface {

    String adress = "http://10.0.2.2:8080/";
    @GET("cytaty")
    Call<List<Mott>> getMott();
}
