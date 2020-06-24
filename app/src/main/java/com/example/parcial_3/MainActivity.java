package com.example.parcial_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//Cuevitas estuvo aqui


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ingresarPrimerosDatos();
        }
public void ingresarPrimerosDatos(){
    try{
        Parcial3BDhelper usuariosDb = new Parcial3BDhelper(getApplicationContext(),"usuarios",null,1);
        SQLiteDatabase db = usuariosDb.getWritableDatabase();
        if (db != null){
            String[] campos = new String[] {"id_u"};
            Cursor c = db.query("usuarios",campos,null,null,null,null,null);
            if (c.moveToFirst()) {
                do{
                    int id = Integer.parseInt(c.getString(0)); Toast.makeText(getApplicationContext(),"existe la BD",Toast.LENGTH_SHORT).show();
                    if(id==0 ){
                        Toast.makeText(getApplicationContext(),"no habia nada, vamos a ingresar datos",Toast.LENGTH_SHORT).show();
                        ContentValues values = new ContentValues();
                        values.put("nombre","jose");
                        values.put("password","123");
                        values.put("tipo_u","admin");
                        db.insert("usuarios",null,values);
                        ContentValues values2 = new ContentValues();
                        values.put("nombre","pedro");
                        values.put("password","456");
                        values.put("tipo_u","consu");
                        db.insert("usuarios",null,values2);}
                }while (c.moveToNext());
                Toast.makeText(getApplicationContext(),"todo insertado",Toast.LENGTH_SHORT).show();
            }}}
    catch(Exception e){Toast.makeText(getApplicationContext(),"Zometin gruong is japenin tu mai fon: "+e.getMessage().toString(),Toast.LENGTH_SHORT).show();}
    }
    }
