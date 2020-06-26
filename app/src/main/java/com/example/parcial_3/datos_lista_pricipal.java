package com.example.parcial_3;

public class datos_lista_pricipal {
    private String titulo;
    private int ImagenReceta;

    public datos_lista_pricipal(String titulo, int imagenReceta) {
        this.titulo = titulo;
        ImagenReceta = imagenReceta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImagenReceta() {
        return ImagenReceta;
    }

    public void setImagenReceta(int imagenReceta) {
        ImagenReceta = imagenReceta;
    }
}
