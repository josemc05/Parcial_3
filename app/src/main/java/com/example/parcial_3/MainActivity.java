package com.example.parcial_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//Cuevitas estuvo aqui
EditText user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InicializarControles();
        ingresarPrimerosDatos();
        }
    public void InicializarControles(){
        user = (EditText) findViewById(R.id.user);
        pass = (EditText)findViewById(R.id.pass);


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
                    int id = Integer.parseInt(c.getString(0));
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
                c.close();
                db.close();
            }}}
    catch(Exception e){Toast.makeText(getApplicationContext(),"Zometin gruong is japenin tu mai fon: "+e.getMessage().toString(),Toast.LENGTH_SHORT).show();}
    }

    public void onClick(View view){
        if(TextUtils.isEmpty(user.getText().toString()))
            user.setError("Introduzca su Usuario");
        if(TextUtils.isEmpty(pass.getText().toString()))
            pass.setError("Introduzca la Contraseña");
        else{
            try {
                String usuario=user.getText().toString();
                String password=pass.getText().toString();
                Parcial3BDhelper usuariosDb = new Parcial3BDhelper(getApplicationContext(),"usuarios",null,1);
                SQLiteDatabase db = usuariosDb.getReadableDatabase();
                String[] campos = new String[] {"id_u","nombre","password", "tipo_u"};
                Cursor c = db.query("usuarios",campos,null,null,null,null,null);
                if (c.moveToFirst()) {
                    do {
                        String id = c.getString(0);
                        String userbd = c.getString(1);
                        String passbd = c.getString(2);
                        String tp_user = c.getString(3);
                        if ( usuario.equals(userbd) && passbd.equals(password)) {
                            if (tp_user.equals("admin")) {
                                Intent i = new Intent(this, OpcionesActivity.class);
                                i.putExtra("id", id);
                                startActivity(i);
                            } else if(tp_user.equals("consu")){
                                Intent e = new Intent(this, OpcionesActivity.class);
                                e.putExtra("id", id);
                                startActivity(e);
                            }
//
                        }
                    } while (c.moveToNext());
                    c.close();
                    db.close();
            }}catch (Exception e){Toast.makeText(getApplicationContext(),"Zometin gruong is japenin tu mai fon: "+e.getMessage().toString(),Toast.LENGTH_SHORT).show();};

        }




    }


    }
