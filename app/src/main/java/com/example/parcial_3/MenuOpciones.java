package com.example.parcial_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuOpciones extends AppCompatActivity {
    private String usuario;
    private String tipoUsuario;
    private int idUsuario;
    private Button botonAgregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opciones);
        botonAgregar = (Button)findViewById(R.id.botonAgregarRecetas);

        Intent i = getIntent();
        usuario = i.getStringExtra("datos");
        verificarTipoUsuario();
        botonAdministrador();

    }

    public void verificarTipoUsuario(){
        Parcial3BDhelper recetasDb = new Parcial3BDhelper(getApplicationContext(),"usuarios",null,1);
        SQLiteDatabase db = recetasDb.getReadableDatabase();

        String[] campos = new String[] {"id_u","tipo_u"};

        Cursor c2 = db.query("usuarios",campos,"nombre='"+usuario+"'",null,null,null,null);

        c2.moveToFirst();
        idUsuario = c2.getInt(0);
        tipoUsuario = c2.getString(1);
    }

    public void RecetasDisponibles(View view){
        Intent i = new Intent(MenuOpciones.this,ListaRectas.class);
        i.putExtra("idUsuario",idUsuario);
        startActivity(i);
    }
    public void RecetasGuardadas(View view){
        Intent i = new Intent(MenuOpciones.this,ListaRecetas_Activity.class);
        i.putExtra("idUsuario",idUsuario);
        startActivity(i);
    }
    public void AgregarReceta(View view){
        Intent i = new Intent(MenuOpciones.this,AgregarActivity.class);
        i.putExtra("idUsuario",idUsuario);
        startActivity(i);
    }


    public void botonAdministrador(){
            if (tipoUsuario.equals("admin")){
                botonAgregar.setVisibility(View.VISIBLE);
            }else {
                botonAgregar.setVisibility(View.INVISIBLE);
            }
    }

}