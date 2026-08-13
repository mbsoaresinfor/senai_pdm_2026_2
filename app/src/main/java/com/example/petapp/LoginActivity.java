package com.example.petapp;

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

        EditText login =  findViewById(R.id.textViewLogin);
        Button botao = findViewById(R.id.buttonLogin);

        if(login.getText().toString().isEmpty()){
            Toast.makeText(this,R.string.campo_vazio, Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "Você escreveu:  " + login.getText().toString(), Toast.LENGTH_LONG).show();
            botao.setText(login.getText().toString());
        }
    }
}