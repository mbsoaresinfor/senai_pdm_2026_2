package com.example.petapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AtualizarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_atualizar);

    }

    public void atualizar(View view) {
        EditText id = findViewById(R.id.editTextIdPet);
        EditText nome = findViewById(R.id.editTextNovoNomePet);
        EditText idade = findViewById(R.id.editTextNOvaIdadPet);

        String idInt = id.getText().toString();
        String novoNome = nome.getText().toString();
        String novaIdade  =idade.getText().toString();

        if(idInt.isEmpty() || novoNome.isEmpty() || novaIdade.isEmpty()){
            Toast.makeText(this, "Digite o id e novo nome e nova idade para atualizar o pet",
                    Toast.LENGTH_LONG).show();
            return;
        }

        for(int i=0; i < DadosCompartilhados.vetorPets.length;i++){
            Pet pet = DadosCompartilhados.vetorPets[i];
            if(pet != null){
                if(pet.id == Integer.parseInt(idInt)){
                   pet.nome = novoNome;
                   pet.idade = novaIdade;
                    Toast.makeText(this, "Pet atualizado com sucesso",
                            Toast.LENGTH_LONG).show();
                    return;

                }
            }
        }

        Toast.makeText(this, "Nao localizado pet com id " + id,
                Toast.LENGTH_LONG).show();

    }
}