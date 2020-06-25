package com.example.parcial_3;

class recetas {

   private String idr;
    private String produc;
    private String ingre1;
    private String ingre2;
    private String ingre3;
    private String ingre4;
    private String ingre5;
    private String pasos;
    private String imagen;

    public recetas (String producto, String img){
        produc=producto;
        imagen=img;
    }
    public String getIdr() {
        return idr;
    }


    public String getProduc() {
        return produc;
    }



    public String getIngre1() {
        return ingre1;
    }


    public String getIngre2() {
        return ingre2;
    }


    public String getIngre3() {
        return ingre3;
    }



    public String getIngre4() {
        return ingre4;
    }



    public String getIngre5() {
        return ingre5;
    }



    public String getPasos() {
        return pasos;
    }


    public String getImagen() {
        return imagen;
    }


}
