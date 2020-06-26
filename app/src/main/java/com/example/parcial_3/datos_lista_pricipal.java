package com.example.parcial_3;

public class datos_lista_pricipal {
    private String titulo;
    private String ImagenReceta;

    public datos_lista_pricipal(String titulo, String imagenReceta) {
        this.titulo = titulo;
        ImagenReceta = imagenReceta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagenReceta() {
        return ImagenReceta;
    }

    public void setImagenReceta(String imagenReceta) {
        ImagenReceta = imagenReceta;
    }
}
