package com.example.parcial_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

class Adapterlistview extends ArrayAdapter<recetas> {

    private List<recetas> receta = new ArrayList<>();
    private Context context1;
    public Adapterlistview(Context context, List<recetas> datos){
        super(context, R.layout.listviewrecetas, datos);
        receta = datos;
        context1=context;
    }



    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listviewrecetas, null);
        //colocar los productos
        TextView producto = (TextView)item.findViewById(R.id.nombrereceta);
        producto.setText(receta.get(position).getProduc());

        //Colocar la imagen basado en la ruta de la imagen
        ImageView imagenp = (ImageView) item.findViewById(R.id.imgrecetalista);
        String img=receta.get(position).getImagen();
        String uri ="drawable/"+img;
        int id = context1.getResources().getIdentifier(uri , null, context1.getPackageName());
        Drawable foto = ContextCompat.getDrawable(context1, id);
        imagenp.setImageDrawable(foto);

        //Establecer el imageView/ImageSwitcher/ImageButton
        ImageView imageng = (ImageView) item.findViewById(R.id.botonimagen1);
        String imagen1 = receta.get(position).getGusto();
        if(imagen1.equals("si")){
            String uri1 ="drawable/gustar";
            int id1 = context1.getResources().getIdentifier(uri1 , null, context1.getPackageName());
            Drawable foto1 = ContextCompat.getDrawable(context1, id1);
            imageng.setImageDrawable(foto1);
        }
        else{
            String uri2 ="drawable/nogustar";
            int id2 = context1.getResources().getIdentifier(uri2 , null, context1.getPackageName());
            Drawable foto2 = ContextCompat.getDrawable(context1, id2);
            imageng.setImageDrawable(foto2);
        }

        //Establecer el imageView/ImageSwitcher/ImageButton 2
        ImageView imageno = (ImageView) item.findViewById(R.id.botonimagen2);
        String imagen2 = receta.get(position).getOriginal();
        if(imagen2.equals("si")){
            String uri3 ="drawable/original";
            int id3 = context1.getResources().getIdentifier(uri3 , null, context1.getPackageName());
            Drawable foto1 = ContextCompat.getDrawable(context1, id3);
            imageno.setImageDrawable(foto1);
        }
        else{
            String uri4 ="drawable/noriginal";
            int id4 = context1.getResources().getIdentifier(uri4 , null, context1.getPackageName());
            Drawable foto2 = ContextCompat.getDrawable(context1, id4);
            imageno.setImageDrawable(foto2);
        }
        return(item);
    }
}
