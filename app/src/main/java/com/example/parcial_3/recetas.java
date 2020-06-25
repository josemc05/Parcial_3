package com.example.parcial_3;

class recetas {

    private String produc;
    private String gusto;
    private String original;
    private String imagen;

    public recetas (String producto, String img, String gust, String ori){
        produc=producto;
        imagen=img;
        gusto=gust;
        original=ori;
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

    public String getOriginal() {
        return original;
    }
}
