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

        String loginDigitado = login.getText().toString();
        String senhaDigitada =  senha.getText().toString();
        boolean loginValidado = false;
        for(int i=0; i < DadosCompartilhados.usuarios.length;i++){
            if(DadosCompartilhados.usuarios[i].equals(loginDigitado)
            && DadosCompartilhados.senhas[i].equals(senhaDigitada)){
                loginValidado = true;
                break;
            }
        }

        if(loginValidado){
            DadosCompartilhados.usuarioLogado =loginDigitado;
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