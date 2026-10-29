package com.example.petapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListagemActivity extends AppCompatActivity {

    RepositorioPet repositorioPet;
    PetApi petApi = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);
        repositorioPet = new RepositorioPet(this);

        petApi = RetroFitCliente.getPetApi();

        Call<List<Pet>> call = petApi.listar();
         call.enqueue(new Callback<List<Pet>>() {
          @Override
          public void onResponse(Call<List<Pet>> call, Response<List<Pet>> response) {
            if(response.code() == 200){
                List<Pet> lista = response.body();
                Log.i("pet",lista.toString());
                atualizar(lista);
            }
          }

          @Override
          public void onFailure(Call<List<Pet>> call, Throwable throwable) {
            Log.e("tag","Error: " + throwable.getMessage());
          }
      });

    }

    private void atualizar(List<Pet> listaPet){
        if(listaPet.isEmpty()){
            Toast.makeText(this, "Nenhum pet cadastrado",
                    Toast.LENGTH_LONG).show();
            return;
        }

        ListView listView = findViewById(R.id.listViewPet);
        String[] dados = new String[listaPet.size()];
        for(int i=0; i < listaPet.size();i++){
            dados[i] =listaPet.get(i).toString();
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                dados);

        listView.setAdapter(arrayAdapter);
    }
}