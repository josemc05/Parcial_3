package com.example.parcial_3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.core.content.ContextCompat;

public class ingredienteAdaptador extends ArrayAdapter<datosIngredientes> {
    private List<datosIngredientes> opciones = new ArrayList<>();
    private Context mContext;

    public ingredienteAdaptador(Context context, List<datosIngredientes> datos){
        super(context,R.layout.listview_layouttemple_ingredientes,datos);
        this.mContext = context;
        opciones = datos;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_layouttemple_ingredientes, null);

        TextView lblIngrediente = (TextView)item.findViewById(R.id.ingrediente);
        lblIngrediente.setText(opciones.get(position).getIn_1());

        return(item);
    }

}
