package com.example.petapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitCliente {

    public static final String IP_SERVIDOR = "http://192.168.248.166:8080/";
    private static Retrofit retrofit = null;

    public static PetApi getPetApi(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(IP_SERVIDOR + "pet/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(PetApi.class);
    }

}
