package com.example.petapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle(R.string.login);



    }

    public void logar(View view) {
         // aqui eu vou colocar o codigo que vai ser executado, quando eu clicar no botao de login

        EditText login =  findViewById(R.id.editTextTextLogin);
        EditText senha =  findViewById(R.id.editTextTextSenha);



        if(login.getText().toString().equals("admin") &&
            senha.getText().toString().equals("123")){
            DadosCompartilhados.usuarioLogado ="admin";
            Bundle bundle = new Bundle();
            bundle.putString("usuario_logado","admin");
            Intent intent = new Intent(this,DashboardActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }else {
            Toast.makeText(this, "“Usuário ou senha inválido",
                    Toast.LENGTH_LONG).show();
        }

   }
}