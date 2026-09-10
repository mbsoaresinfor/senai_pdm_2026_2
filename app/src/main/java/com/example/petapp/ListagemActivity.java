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

public class ListagemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);

            if(DadosCompartilhados.IND_VETOR_PET == 0){
                Toast.makeText(this, "Nenhum pet cadastrado",
                        Toast.LENGTH_LONG).show();
                return;
            }

            ListView listView = findViewById(R.id.listViewPet);
            String[] dados = new String[DadosCompartilhados.IND_VETOR_PET];
            for(int i=0; i < DadosCompartilhados.IND_VETOR_PET;i++){
                dados[i] = DadosCompartilhados.vetorPets[i].toString();
            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1,
                    dados);

            listView.setAdapter(arrayAdapter);



    }
}