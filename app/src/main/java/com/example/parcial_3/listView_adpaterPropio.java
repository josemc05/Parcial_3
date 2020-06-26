package com.example.parcial_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class listView_adpaterPropio extends ArrayAdapter<datos_contenido> {
    private List<datos_contenido> opciones = new ArrayList<>();
    private Context mContext;

    public listView_adpaterPropio(Context context, List<datos_contenido> datos){
        super(context,R.layout.listview_layouttemple_ingredientes,datos);
        this.opciones = datos;
        this.mContext = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_layouttemple, null);

        TextView lblTitulo = (TextView)item.findViewById(R.id.titleReceta);
        lblTitulo.setText(opciones.get(position).getTitulo());

        ImageView imgFoto = (ImageView) convertView.findViewById(R.id.ImagenReceta);
        imgFoto.setImageResource(opciones.get(position).getImagen());
        return(item);
    }

}
