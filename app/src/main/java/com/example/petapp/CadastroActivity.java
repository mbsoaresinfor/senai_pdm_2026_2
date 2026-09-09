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

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Cadastro de Pet");
        setContentView(R.layout.activity_cadastro);

    }

    public void salvar(View view) {
        EditText caixaNomePet = findViewById(R.id.editTextNomePet);
        EditText caixaIdadePet = findViewById(R.id.editTextIdadePet);
        String nomePet = caixaNomePet.getText().toString();
        String idadePet = caixaIdadePet.getText().toString();

        if(nomePet.isEmpty() || idadePet.isEmpty()){
            Toast.makeText(this, "“Nome ou idade do pet tem que ser preenchido",
                    Toast.LENGTH_LONG).show();
                return;
        }

        boolean resultado = DadosCompartilhados.salvarPet(nomePet,idadePet);
        if(resultado == true) {
            Toast.makeText(this, "Pet cadastrado com sucesso",
                    Toast.LENGTH_LONG).show();
            caixaNomePet.setText(""); // limpa o campo do nome do pet
            caixaIdadePet.setText(""); // limpa o campo de idade do pet
        }else{
            Toast.makeText(this, "Erro ao cadastar o pet",
                    Toast.LENGTH_LONG).show();
        }


    }
}