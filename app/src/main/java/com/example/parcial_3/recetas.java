package com.example.parcial_3;

import java.io.Serializable;

class recetas implements Serializable {

    private String produc;
    private String gusto;
    private String imagen;

    public recetas (String producto, String img, String gust){
        produc=producto;
        imagen=img;
        gusto=gust;
    }



    public String getProduc() {
        return produc;
    }


    public String getImagen() {
        return imagen;
    }


    public String getGusto() {
        return gusto;
    }
}
