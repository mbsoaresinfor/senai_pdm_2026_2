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

public class RemoverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_remover);

    }

    public void remover(View view) {
        EditText editText = findViewById(R.id.editTextIdPet);
        String valor = editText.getText().toString();

        if(valor.isEmpty()){
            Toast.makeText(this, "Digite o id do pet",
                    Toast.LENGTH_LONG).show();
            return;
        }
        //valor.matches("\\d+");
        int id = Integer.parseInt(valor);

        for(int i=0; i < DadosCompartilhados.vetorPets.length;i++){
            Pet pet = DadosCompartilhados.vetorPets[i];
            if(pet != null){
                if(pet.id == id){
                    DadosCompartilhados.vetorPets[i] = null;
                    Toast.makeText(this, "Pet removido com sucesso",
                            Toast.LENGTH_LONG).show();
                    return;

                }
            }
        }

        Toast.makeText(this, "Nao localizado pet com id " + id,
                Toast.LENGTH_LONG).show();


    }
}