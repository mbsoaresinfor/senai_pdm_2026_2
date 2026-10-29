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

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroActivity extends AppCompatActivity {

    RepositorioPet repositorioPet;
    RepositorioLog repositorioLog;

    PetApi petApi = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Cadastro de Pet");
        setContentView(R.layout.activity_cadastro);
        repositorioPet = new RepositorioPet(this);
        repositorioLog = new RepositorioLog(this);
        petApi = RetroFitCliente.getPetApi();
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

        Pet pet = new Pet();
        pet.idade = idadePet;
        pet.nome = nomePet;
       // repositorioPet.salvar(pet);
       Call<Integer>  call =  petApi.salvar(pet);
       call.enqueue(new Callback<Integer>() {
           @Override
           public void onResponse(Call<Integer> call, Response<Integer> response) {
               if(response.code() == 200){
                   sucessoSalvar();
               }else if(response.code() == 400){
                    errorSalvar("salvar o pet");
               }
           }

           @Override
           public void onFailure(Call<Integer> call, Throwable throwable) {

           }
       });




    }

    private void errorSalvar(String msg){
        Toast.makeText(this, "Error: " + msg,
                Toast.LENGTH_LONG).show();
    }
    private void sucessoSalvar(){
        EditText caixaNomePet = findViewById(R.id.editTextNomePet);
        EditText caixaIdadePet = findViewById(R.id.editTextIdadePet);
        String nomePet = caixaNomePet.getText().toString();
        String idadePet = caixaIdadePet.getText().toString();
        Toast.makeText(this, "Pet cadastrado com sucesso",
                Toast.LENGTH_LONG).show();
        caixaNomePet.setText(""); // limpa o campo do nome do pet
        caixaIdadePet.setText(""); // limpa o campo de idade do pet
    }
}