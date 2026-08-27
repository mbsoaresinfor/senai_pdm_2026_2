package com.example.petapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        setTitle("Dashboard");

        String usuarioLogado = (String)getIntent()
                .getSerializableExtra("usuario_logado");

        Log.i("pet","usuario logado");

        Toast.makeText(this,"Seja bem vindo " +
                DadosCompartilhados.usuarioLogado,Toast.LENGTH_LONG).show();

    }

}