package com.example.petapp;

import android.os.Bundle;
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

public class ListagemActivity extends AppCompatActivity {

    RepositorioPet repositorioPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);
        repositorioPet = new RepositorioPet(this);

        List<Pet> listaPet = repositorioPet.listar();
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