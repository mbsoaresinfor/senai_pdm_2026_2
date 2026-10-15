package com.example.petapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPet extends SQLiteOpenHelper {

    public RepositorioPet(@Nullable Context context) {
        super(context, "pet", null, 1);
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

    public void remover(int id){
        String sql = "delete from pet where id = " + id;
        super.getWritableDatabase().execSQL(sql);
        Log.i("pet","pet removido com sucesso");
    }

    public void atualizar(int id, String novoNome,String novaIdade){
        String sql = "update pet set nome = '" + novoNome + "',idade = " + novaIdade + "'," +
                " where id = " + id;
        super.getWritableDatabase().execSQL(sql);
        Log.i("pet","pet atualizado com sucesso");

    }

    public List<Pet> listar(){
        String sql = "select * from pet";
        ArrayList<Pet> lista = new ArrayList<>();
        Cursor cursor = super.getReadableDatabase().rawQuery(sql,null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            Pet pet = new Pet();
            pet.id = cursor.getInt(0);
            pet.nome = cursor.getString(1);
            pet.idade = cursor.getString(2);
            lista.add(pet);
            cursor.moveToNext();
        }

        cursor.close();
        return lista;

    }

    public Pet  buscarPeloId(int id){
        String sql = "select * from pet where id = " + id;
        Cursor cursor = super.getReadableDatabase().rawQuery(sql,null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            Pet pet = new Pet();
            pet.id = cursor.getInt(0);
            pet.nome = cursor.getString(1);
            pet.idade = cursor.getString(2);
            return pet;
        }

        cursor.close();
        return null;

    }



}
