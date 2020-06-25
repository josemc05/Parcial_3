package com.example.parcial_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarActivity extends AppCompatActivity {
EditText producto, url, ingre1, ingre2, ingre3, ingre4, ingre5, pasos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        InicializarControles();
    }

    public void InicializarControles() {
        producto = (EditText) findViewById(R.id.producto);
        url = (EditText)findViewById(R.id.url);
        ingre1 = (EditText) findViewById(R.id.ingre1);
        ingre2 = (EditText)findViewById(R.id.ingre2);
        ingre3 = (EditText) findViewById(R.id.ingre3);
        ingre4 = (EditText)findViewById(R.id.ingre4);
        ingre5 = (EditText) findViewById(R.id.ingre5);
        pasos = (EditText)findViewById(R.id.proce);
    }
public void agregarReceta(View view){
    try{
        Parcial3BDhelper usuariosDb = new Parcial3BDhelper(getApplicationContext(),"usuarios",null,1);
        SQLiteDatabase db = usuariosDb.getWritableDatabase();

        if (db != null) {
            ContentValues values = new ContentValues();
            values.put("producto", producto.getText().toString());
            values.put("ingrediente1", ingre1.getText().toString());
            values.put("ingrediente2", ingre2.getText().toString());
            values.put("ingrediente3", ingre3.getText().toString());
            values.put("ingrediente4", ingre4.getText().toString());
            values.put("ingrediente5", ingre5.getText().toString());
            values.put("preparacion", pasos.getText().toString());
            values.put("imagen", url.getText().toString());
            db.insert("recetas", null, values);
            Toast.makeText(getApplicationContext(), "En teoria, todo se inserto bien", Toast.LENGTH_SHORT).show();

        }
    }catch (Exception e){
        Toast.makeText(getApplicationContext(),"Errorcito: "+e.getMessage().toString(),Toast.LENGTH_SHORT).show();
    }
}
}

