package com.example.petapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class RepositorioPet extends SQLiteOpenHelper {

    public RepositorioPet(@Nullable Context context) {
        super(context, "pet", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String sql = "create table pet (id integer not null primary key, " +
            "nome text not null, idade text not null)";
        db.execSQL(sql);
        Log.i("pet","Criada tabela PET com sucesso");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void salvar(Pet pet){
        String sql = "insert into pet values(null,'" + pet.nome + "','" + pet.idade +"')";
        super.getWritableDatabase().execSQL(sql);
       Log.i("pet","pet inserido com sucesso");
    }



}
