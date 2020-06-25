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

        TextView producto = (TextView)item.findViewById(R.id.nombrereceta);
        producto.setText(receta.get(position).getProduc());

        ImageView imagenp = (ImageView) item.findViewById(R.id.imgrecetalista);
        String img=receta.get(position).getImagen();
        String uri ="drawable/"+img;
        int id = context1.getResources().getIdentifier(uri , null, context1.getPackageName());
        Drawable foto = ContextCompat.getDrawable(context1, id);
        imagenp.setImageDrawable(foto);





        return(item);
    }
}
