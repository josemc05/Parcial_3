package com.example.parcial_3;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListaRecetas_Activity extends AppCompatActivity {
ListView lstSF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_recetas_);
        lstSF = (ListView)findViewById(R.id.listarecetass);
        loadlist();
    }

    public void loadlist(){
        try {
            Parcial3BDhelper recetasDb = new Parcial3BDhelper(getApplicationContext(),"usuarios",null,1);
            SQLiteDatabase db = recetasDb.getReadableDatabase();

            List<recetas> recetass = new ArrayList<recetas>();

            String[] campos = new String[] {"producto","imagen"};

            Cursor c = db.query("recetas",campos,null,null,null,null,null);
            if (c.moveToFirst()){
                do {
                    recetas recipe = new recetas(
                            c.getString(0),
                            c.getString(1)
                    );
                    recetass.add(recipe);
                }while(c.moveToNext());
            }

            Adapterlistview adapter = new Adapterlistview(getApplicationContext(), recetass);
            lstSF.setAdapter(adapter);

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Errorcito: "+e.getMessage().toString(),Toast.LENGTH_SHORT).show();
        }
    }
}