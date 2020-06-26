package com.example.parcial_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Descripcion_Receta extends AppCompatActivity {
    private ListView lvItems;
    private String item;
    private ImageView imgReceta;
    private TextView txtTituloReceta;
    private TextView txtDescripcionReceta;
    private TextView txtProcedimientos;
    private String nameProducto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion__receta);
        lvItems = (ListView)findViewById(R.id.listaIngredientes);
        imgReceta = (ImageView)findViewById(R.id.ImagenRecetaDescripcion);
        txtTituloReceta = (TextView)findViewById(R.id.TituloRecetaDescripcion);
        txtDescripcionReceta = (TextView)findViewById(R.id.descripcionRecetaDescripcion);
        txtProcedimientos = (TextView)findViewById(R.id.procedimiento);

        Intent i = getIntent();
        item = i.getStringExtra("objetoData");

        GetAerialist();
    }

    private void GetAerialist() {
        try {

            Parcial3BDhelper recetasDb = new Parcial3BDhelper(getApplicationContext(), "usuarios", null, 1);
            SQLiteDatabase db = recetasDb.getReadableDatabase();

            List<datosIngredientes> recetas = new ArrayList<>();
            String[] campos = new String[]{"producto", "imagen","ingrediente1","ingrediente2","ingrediente3","ingrediente4",
                                            "ingrediente5","preparacion"};

            Cursor c = db.query("recetas", campos, "producto="+item, null, null, null, null);
            if (c.moveToFirst()) {
                do {
                    txtTituloReceta.setText(c.getString(0));
                    txtProcedimientos.setText(c.getString(7));
                    String uri ="drawable/"+c.getString(1);
                    int id = Descripcion_Receta.this.getResources().getIdentifier(uri , null, Descripcion_Receta.this.getPackageName());
                    Drawable foto = ContextCompat.getDrawable(Descripcion_Receta.this, id);
                    imgReceta.setImageDrawable(foto);


                    datosIngredientes recipe = new datosIngredientes(
                            c.getString(2)+"\n"+c.getString(3)+"\n"+c.getString(4)+
                                    "\n"+c.getString(5)+"\n"+c.getString(6)
                    );

                    recetas.add(recipe);
                } while (c.moveToNext());
            }

            ingredienteAdaptador adapter = new ingredienteAdaptador(getApplicationContext(), recetas);
            lvItems.setAdapter(adapter);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Errorcito: " + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }

    }
}