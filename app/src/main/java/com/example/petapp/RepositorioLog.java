package com.example.petapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Date;

public class RepositorioLog extends SQLiteOpenHelper {

    public RepositorioLog(@Nullable Context context) {
        super(context, "log", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String sql = "create table log(id integer not null primary key, " +
            "data_operacao text not null, operacao text not null, usuario text not null)";
        db.execSQL(sql);
        Log.i("pet","Criada tabela LOG com sucesso");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void salvar(String operacao, String usuario){
        String sql = "insert into log values(null,'" + new Date().toGMTString() + "','"
                + operacao +"', '"+ usuario +"')";
        super.getWritableDatabase().execSQL(sql);
       Log.i("pet","log inserido com sucesso");
    }



}
