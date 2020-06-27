package com.example.parcial_3;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

class Parcial3BDhelper extends SQLiteOpenHelper {

    String tableUsuario = "CREATE TABLE usuarios(id_u INTEGER primary key autoincrement, nombre TEXT, password TEXT, tipo_u TEXT)";
    String tableCategoria = "CREATE TABLE recetas(id_r INTEGER primary key autoincrement, producto TEXT, ingrediente1 TEXT, ingrediente2 TEXT, ingrediente3 TEXT,ingrediente4 TEXT,ingrediente5 TEXT,preparacion TEXT, imagen TEXT)";
    String tableGuardado = "CREATE TABLE recetas_guardadas(id_u_fkg INTEGER,id_r_fkg INTEGER, gusto TEXT default 'si', original TEXT)";
    String tableFavorito = "CREATE TABLE recetas_fav(id_u_fkf INTEGER,id_r_fkf INTEGER)";


    public Parcial3BDhelper (Context context, String nombre, SQLiteDatabase.CursorFactory cursorFactory, int version){
        super(context,nombre,cursorFactory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableUsuario);
        db.execSQL(tableCategoria);
        db.execSQL(tableGuardado);
        db.execSQL(tableFavorito);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



}
