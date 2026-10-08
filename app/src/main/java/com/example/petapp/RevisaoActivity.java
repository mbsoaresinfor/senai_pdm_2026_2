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

public class RevisaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_revisao);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void salvar(View view) {

        EditText nomecaixa = findViewById(R.id.editTextNomeRevisao);
        EditText idadecaixa = findViewById(R.id.editTextIdadeRevisao);

        String nome = nomecaixa.getText().toString();
        String idade = idadecaixa.getText().toString();

        if(nome.trim().equals("marcelo") && idade.equals("44")){

            Toast.makeText(this,R.string.parabens_nome_idade ,
                    Toast.LENGTH_LONG).show();
        }

    }
}