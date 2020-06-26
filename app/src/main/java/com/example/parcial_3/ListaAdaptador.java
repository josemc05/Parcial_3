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

public class ListaAdaptador extends ArrayAdapter<datos_lista_pricipal> {

    private List<datos_lista_pricipal> opciones = new ArrayList<>();
    private Context mContext;

    public ListaAdaptador(Context context, List<datos_lista_pricipal> datos){
        super(context,R.layout.listview_layouttemple,datos);
        this.mContext = context;
        opciones = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_layouttemple, null);

        TextView lblTitulo = (TextView)item.findViewById(R.id.titleReceta);
        lblTitulo.setText(opciones.get(position).getTitulo());

        ImageView imgFoto = (ImageView) convertView.findViewById(R.id.ImagenReceta);
        imgFoto.setImageResource(opciones.get(position).getImagenReceta());
        return(item);
    }
}
