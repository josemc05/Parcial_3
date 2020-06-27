package com.example.parcial_3;

import java.io.Serializable;

public class datos_lista_pricipal implements Serializable {
    private String titulo;
    private String ImagenReceta;
    private String id;

    public datos_lista_pricipal(String titulo, String imagenReceta, String ide) {
        this.titulo = titulo;
        ImagenReceta = imagenReceta;
        id=ide;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
