package com.example.parcial_3;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
//Cuevitas estuvo aqui


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parcial3BDhelper base = new Parcial3BDhelper(getApplicationContext());
        base.agregarvaloresiniciales();

    }
}