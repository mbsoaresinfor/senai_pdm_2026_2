package com.example.petapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PetApi {

    @GET("listar")
    public Call<List<Pet>> listar();

    @POST("salvar")
    public Call<Integer> salvar(@Body Pet pet);


}
