package com.example.registro_ciudades;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ciudades.db";

    public MyDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table ciudad(Id INTEGER PRIMARY KEY, Nombre TEXT, Latitud INTEGER, Longitud INTEGER, Poblacion INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists ciudad");
        onCreate(db);

    }
    public void InsertCiudad(SQLiteDatabase db, Ciudades ciudades){
        ContentValues values= new ContentValues();
        values.put("Id",ciudades.getId());
        values.put("Nombre", ciudades.getNombre());
        values.put("Latitud", ciudades.getLatitud());
        values.put("Longitud", ciudades.getLongitud());
        values.put("Poblacion", ciudades.getPoblacion());
        db.insert("ciudad",null, values);
    }
    public ArrayList<Ciudades> selectCiudad(SQLiteDatabase db){
        ArrayList<Ciudades> ciudades = new ArrayList<Ciudades>();
        Cursor filas = db.rawQuery("Select * from ciudad", null);
        if (filas.moveToFirst()){
            do{
                Ciudades ciudad = new Ciudades(filas.getInt(0), filas.getString(1), filas.getInt(2),
                        filas.getInt(3), filas.getInt(4));
                ciudades.add(ciudad);
            }while (filas.moveToNext());
        }
        return ciudades;
    }
}
