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
ArrayList<recetas> arrayEntidad;
    Adapterlistview adapter;
    String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_recetas_);
        lstSF = (ListView)findViewById(R.id.listarecetass);

        Intent i = getIntent();
         userid = i.getStringExtra("datos");

        arrayEntidad = loadlist();
        adapter = new Adapterlistview(getApplicationContext(), arrayEntidad);
        lstSF.setAdapter(adapter);

        /*lstSF.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListaRecetas_Activity.this,Descripcion_Receta.class);
                intent.putExtra("objetoData2",arrayEntidad.get(i));
                intent.putExtra("objetoId",userid);
                intent.putExtra("numActivity","1");
                startActivity(intent);
            }
        });*/

    }

    public ArrayList<recetas> loadlist(){
        ArrayList<recetas> recetass = new ArrayList<>();
        try {
            String recetaid="";
            Parcial3BDhelper recetasDb = new Parcial3BDhelper(getApplicationContext(),"usuarios",null,1);
            SQLiteDatabase db = recetasDb.getReadableDatabase();


            String[] idrecetasG = new String[]{"id_u_fkg","id_r_fkg", "gusto"};
            String[] campos = new String[] {"producto","imagen"};

            Cursor c2 = db.query("recetas_guardadas",idrecetasG,"id_u_fkg='"+userid+"'",null,null,null,null);
            if (c2.moveToFirst()){

                do {
                    recetaid=c2.getString(1);
                    String gusto=c2.getString(2);
                    Cursor  c = db.query("recetas",campos,"id_r='"+recetaid+"'",null,null,null,null);
                    c.moveToFirst();
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