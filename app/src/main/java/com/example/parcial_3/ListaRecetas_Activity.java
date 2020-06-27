package com.example.parcial_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaRecetas_Activity extends AppCompatActivity {
ListView lstSF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_recetas_);
        lstSF = (ListView)findViewById(R.id.ListaRecetas);

        final List<recetas> arrayEntidad;

        arrayEntidad = loadlist();

        
        Adapterlistview adapter = new Adapterlistview(ListaRecetas_Activity.this, arrayEntidad);
        lstSF.setAdapter(adapter);

        lstSF.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(ListaRecetas_Activity.this,Descripcion_Receta.class);
                intent.putExtra("objetoData", arrayEntidad.get(i));
                startActivity(intent);
            }
        });
        loadlist();
    }

    public ArrayList<recetas> loadlist(){
        ArrayList<recetas> recetass = new ArrayList<recetas>();
        try {
            Intent i = getIntent();
            String userid = i.getStringExtra("id");
            String recetaid="";
            Parcial3BDhelper recetasDb = new Parcial3BDhelper(getApplicationContext(),"usuarios",null,1);
            SQLiteDatabase db = recetasDb.getReadableDatabase();


            String[] idrecetasG = new String[]{"id_r_fkg", "gusto"};
            String[] campos = new String[] {"producto","imagen"};

            Cursor c2 = db.query("recetas_guardadas",idrecetasG,"id_u_fkg='"+userid+"'",null,null,null,null);
            if (c2.moveToFirst()){
                do {
                    recetaid=c2.getString(0);
                    String gusto=c2.getString(1);
                    Cursor c = db.query("recetas",campos,"id_r='"+recetaid+"'",null,null,null,null);
                    String producto=c.getString(0);
                    String imagen=c.getString(1);
                    recetas recipe = new recetas(
                            producto,
                            imagen, gusto
                    );
                    recetass.add(recipe);
                }while(c2.moveToNext());
            }


        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Errorcito: "+e.getMessage().toString(),Toast.LENGTH_SHORT).show();
        }
        return recetass;
    }
}