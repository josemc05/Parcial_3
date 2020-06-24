package com.example.parcial_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//Cuevitas estuvo aqui


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parcial3BDhelper usuariosDb = new Parcial3BDhelper(getApplicationContext(),"usuarios",null,1);
        Toast.makeText(getApplicationContext(),"crea objeto del bdhelper",Toast.LENGTH_SHORT).show();
            SQLiteDatabase db = usuariosDb.getWritableDatabase();
        Toast.makeText(getApplicationContext(),"abre la BD",Toast.LENGTH_SHORT).show();
            if (db != null){
                Toast.makeText(getApplicationContext(),"existe la BD",Toast.LENGTH_SHORT).show();
                ContentValues values = new ContentValues();
                values.put("nombre","jose");
                values.put("password","123");
                values.put("tipo_u","admin");
                db.insert("usuarios",null,values);
                Toast.makeText(getApplicationContext(),"todo insertado",Toast.LENGTH_SHORT).show();
            }
        }

    }
