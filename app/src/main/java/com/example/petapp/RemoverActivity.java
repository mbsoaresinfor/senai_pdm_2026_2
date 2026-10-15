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

    RepositorioLog repositorioLog;
    RepositorioPet repositorioPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("remover");
        setContentView(R.layout.activity_remover);
        repositorioLog = new RepositorioLog(this);
        repositorioPet = new RepositorioPet(this);
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

      Pet pet = repositorioPet.buscarPeloId(id);
      if(pet == null){
          Toast.makeText(this, "Nao localizado pet com id " + id,
                  Toast.LENGTH_LONG).show();
          return;
      }
        repositorioPet.remover(id);
        Toast.makeText(this, "Pet removido com sucesso",
                Toast.LENGTH_LONG).show();
        repositorioLog.salvar("remover",DadosCompartilhados.usuarioLogado);






    }
}