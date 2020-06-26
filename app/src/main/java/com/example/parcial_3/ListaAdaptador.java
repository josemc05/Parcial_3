package com.example.parcial_3;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.io.Serializable;
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
final datos_lista_pricipal item2 = (datos_lista_pricipal) getItem(position);

        final View item = inflater.inflate(R.layout.listview_layouttemple, null);

        TextView lblTitulo = (TextView)item.findViewById(R.id.titleReceta);
        lblTitulo.setText(opciones.get(position).getTitulo());

        ImageView imgFoto = (ImageView) item.findViewById(R.id.ImagenReceta);
        String img=opciones.get(position).getImagenReceta();
        String uri ="drawable/"+img;
        int id = mContext.getResources().getIdentifier(uri , null, mContext.getPackageName());
        Drawable foto = ContextCompat.getDrawable(mContext, id);
        imgFoto.setImageDrawable(foto);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,Descripcion_Receta.class);
                intent.putExtra("ObjetoData", (Serializable) item2);
                mContext.startActivity(intent);
            }
        });

        //imgFoto.setImageResource(opciones.get(position).getImagenReceta());

        return(item);
    }
}
