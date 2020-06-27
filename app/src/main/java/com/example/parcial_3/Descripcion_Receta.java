package com.example.parcial_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Descripcion_Receta extends AppCompatActivity {
    private ListView lvItems;
    private datos_lista_pricipal item;
    private ImageView imgReceta;
    private TextView txtTituloReceta;
    private TextView txtDescripcionReceta;
    private TextView txtProcedimientos;
    private String nameProducto, id_u, id_r;
    Bundle parametro = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion__receta);
        lvItems = (ListView)findViewById(R.id.listaIngredientes);
        imgReceta = (ImageView)findViewById(R.id.ImagenRecetaDescripcion);
        txtTituloReceta = (TextView)findViewById(R.id.TituloRecetaDescripcion);
        txtDescripcionReceta = (TextView)findViewById(R.id.descripcionRecetaDescripcion);
        txtProcedimientos = (TextView)findViewById(R.id.procedimiento);
        parametro=this.getIntent().getExtras();
        item = (datos_lista_pricipal)getIntent().getSerializableExtra("objetoData");
        id_r=item.getId();
        id_u=parametro.getString("datos");
        GetAerialist();
    }

    private void GetAerialist() {
        try {

            Parcial3BDhelper recetasDb = new Parcial3BDhelper(getApplicationContext(), "usuarios", null, 1);
            SQLiteDatabase db = recetasDb.getReadableDatabase();

            List<datosIngredientes> recetas = new ArrayList<>();
            String[] campos = new String[]{"producto", "imagen","ingrediente1","ingrediente2","ingrediente3","ingrediente4",
                                            "ingrediente5","preparacion"};

            Cursor c = db.query("recetas", campos, "producto='"+item.getTitulo()+"'", null, null, null, null);
            c.moveToFirst();

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


            ingredienteAdaptador adapter = new ingredienteAdaptador(getApplicationContext(), recetas);
            lvItems.setAdapter(adapter);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Errorcito: " + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }

    }
    //HAY QUE TRAER EL ID DEL USUARIO Y EL DE LA RECETA
    //EL DE LA RECETA TRAERLO DESDE LA PANTALLA DE ANTERIOR A ESTA
    //EL ID DEL USUARIO VIAJA A TRAVES DE LOS INTENTS DE CAMBIO DE PANTALLAS DESDE EL LOGIN
    public void corazonclick(View view){
        try {
            Parcial3BDhelper recetasDb = new Parcial3BDhelper(getApplicationContext(),"usuarios",null,1);
            SQLiteDatabase db = recetasDb.getWritableDatabase();
            String[] campos = new String[]{"id_u_fkf","id_r_fkf"};
            Cursor c = db.query("recetas_fav",campos,null,null,null,null,null);
            if (c.moveToFirst()==false || c.moveToFirst()) {
                if (db != null) {
                    ContentValues values = new ContentValues();
                    values.put("id_u_fkf",id_u);
                    values.put("id_r_fkf",id_r);
                    db.insert("recetas_fav",null,values);
                    Toast.makeText(getApplicationContext(),"Receta en Favoritos",Toast.LENGTH_SHORT).show();
                }
                c.close();
                db.close();
            }}
        catch(Exception e){Toast.makeText(getApplicationContext(),"Zometin gruong is japenin tu mai fon: "+e.getMessage().toString(),Toast.LENGTH_SHORT).show();}
    }
    public void pulgarAr(View view){
        try {
            Parcial3BDhelper recetasDb = new Parcial3BDhelper(getApplicationContext(),"usuarios",null,1);
            SQLiteDatabase db = recetasDb.getWritableDatabase();
            String[] campos = new String[] {"id_u_fkg","id_r_fkg","gusto"};
            Cursor c = db.query("recetas_guardadas",campos,null,null,null,null,null);
            if (c.moveToFirst()==false || c.moveToFirst()) {
            if (db != null) {
                    if ((id_u.equals(c.getString(0)) && (id_r.equals(c.getString(1))))){
                    ContentValues values = new ContentValues();
                    values.put("gusto","si");
                    db.update("recetas_guardadas", values,"id_u_fkg='"+id_u+"'AND id_r_fkg='"+id_r+"'",null);
                        Toast.makeText(getApplicationContext(),"Le Gusta esta Receta",Toast.LENGTH_SHORT).show();}
                    else{
                        ContentValues values = new ContentValues();
                        values.put("id_u_fkg",id_u);
                        values.put("id_r_fkg",id_r);
                        values.put("gusto","si");
                        db.insert("recetas_guardadas",null,values);
                    Toast.makeText(getApplicationContext(),"Le Gusta esta Receta",Toast.LENGTH_SHORT).show();}
                }
                c.close();
                db.close();
            }}
        catch(Exception e){Toast.makeText(getApplicationContext(),"Zometin gruong is japenin tu mai fon: "+e.getMessage().toString(),Toast.LENGTH_SHORT).show();}
    }
    public void pulgarAb(View view){
        try {
            Parcial3BDhelper recetasDb = new Parcial3BDhelper(getApplicationContext(),"usuarios",null,1);
            SQLiteDatabase db = recetasDb.getWritableDatabase();
            String[] campos = new String[] {"id_u_fkg","id_r_fkg","gusto"};
            Cursor c = db.query("recetas_guardadas",campos,null,null,null,null,null);
            if (c.moveToFirst()==false || c.moveToFirst()) {
                if (db != null) {
                    if ((id_u.equals(c.getString(0)) && (id_r.equals(c.getString(1))))){
                        ContentValues values = new ContentValues();
                        values.put("gusto","no");
                        db.update("recetas_guardadas", values,"id_u_fkg='"+id_u+"'AND id_r_fkg='"+id_r+"'",null);
                        Toast.makeText(getApplicationContext(),"no Gusta esta Receta",Toast.LENGTH_SHORT).show();}
                    else{
                        ContentValues values = new ContentValues();
                        values.put("id_u_fkg",id_u);
                        values.put("id_r_fkg",id_r);
                        values.put("gusto","no");
                        db.insert("recetas_guardadas",null,values);
                        Toast.makeText(getApplicationContext(),"No Gusta esta Receta",Toast.LENGTH_SHORT).show();}
                }}
                c.close();
                db.close();
            }
        catch(Exception e){Toast.makeText(getApplicationContext(),"Zometin gruong is japenin tu mai fon: "+e.getMessage().toString(),Toast.LENGTH_SHORT).show();}
    }
    public void guardar(View view){
        try {
            Parcial3BDhelper recetasDb = new Parcial3BDhelper(getApplicationContext(),"usuarios",null,1);
            SQLiteDatabase db = recetasDb.getWritableDatabase();
            String[] campos = new String[] {"id_u_fkg","id_r_fkg","gusto"};
            Cursor c = db.query("recetas_guardadas",campos,null,null,null,null,null);
            if (c.moveToFirst()==false || c.moveToFirst()) {
                if (db != null) {
                        ContentValues values = new ContentValues();
                        values.put("id_u_fkg",id_u);
                        values.put("id_r_fkg",id_r);
                        db.insert("recetas_guardadas",null,values);
                    Toast.makeText(getApplicationContext(),"Ha Guardado esta Receta",Toast.LENGTH_SHORT).show();
                }
                c.close();
                db.close();
            }}
        catch(Exception e){Toast.makeText(getApplicationContext(),"Zometin gruong is japenin tu mai fon: "+e.getMessage().toString(),Toast.LENGTH_SHORT).show();}
    }
}