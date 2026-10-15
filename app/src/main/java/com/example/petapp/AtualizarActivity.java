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

    RepositorioLog repositorioLog;
    RepositorioPet repositorioPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("atualizar");
        setContentView(R.layout.activity_atualizar);
        repositorioLog = new RepositorioLog(this);
        repositorioPet = new RepositorioPet(this);
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

        Pet pet = repositorioPet.buscarPeloId( Integer.parseInt(idInt));
        if( pet == null){
            Toast.makeText(this, "Nao localizado pet com id " + id,
                    Toast.LENGTH_LONG).show();
            return;
        }

        repositorioPet.atualizar( Integer.parseInt(idInt),novoNome,novaIdade);
        Toast.makeText(this, "Pet atualizado com sucesso",
                            Toast.LENGTH_LONG).show();


    }
}