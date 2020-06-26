package com.example.parcial_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListaRectas extends AppCompatActivity {
    private ListView lvItems;
    private List<datos_lista_pricipal> recetass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_rectas);
        lvItems = (ListView)findViewById(R.id.ListaRecetas);
        GetAerialist();
    }

    private void GetAerialist() {
        try {
            int indiceRow = 0;
            double i;

            Parcial3BDhelper recetasDb = new Parcial3BDhelper(getApplicationContext(), "usuarios", null, 1);
            SQLiteDatabase db = recetasDb.getReadableDatabase();

            recetass = new ArrayList<>();
            String[] campos = new String[]{"producto", "imagen","id_r"};

            Cursor c = db.query("recetas", campos, null, null, null, null, null);
            if (c.moveToFirst()) {
                do {
                    datos_lista_pricipal recipe = new datos_lista_pricipal(
                            c.getString(0),
                            c.getString(1)
                    );
                    indiceRow = c.getInt(2);

                    recetass.add(recipe);
                } while (c.moveToNext());
            }
            i = indiceRow/2;

            /*if (i % 2 != 0 && i != 1) {
                i = i + 0.5;
            }
            indiceRow = (int)i;
            GridLayout gridLayout = new GridLayout(this);
            gridLayout.setRowCount(indiceRow);*/

            ListaAdaptador adapter = new ListaAdaptador(getApplicationContext(), recetass);
            lvItems.setAdapter(adapter);

            lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(ListaRectas.this,Descripcion_Receta.class);
                    intent.putExtra("ObjetoData",recetass.get(i));
                    startActivity(intent);
                }
            });

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Errorcito: " + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }

    }
}