package com.example.parcial_3;

public class datos_contenido {
    private String titulo;

    public datos_contenido(String titulo, String ingrediente1, String ingrediente2, String ingrediente3, String ingrediente4, String ingrediente5, String preparacion, int imagen) {
        this.titulo = titulo;
        this.ingrediente1 = ingrediente1;
        this.ingrediente2 = ingrediente2;
        this.ingrediente3 = ingrediente3;
        this.ingrediente4 = ingrediente4;
        this.ingrediente5 = ingrediente5;
        this.preparacion = preparacion;
        this.imagen = imagen;
    }

    private String ingrediente1;
    private String ingrediente2;
    private String ingrediente3;
    private String ingrediente4;
    private String ingrediente5;
    private String preparacion;
    private int imagen;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIngrediente1() {
        return ingrediente1;
    }

    public void setIngrediente1(String ingrediente1) {
        this.ingrediente1 = ingrediente1;
    }

    public String getIngrediente2() {
        return ingrediente2;
    }

    public void setIngrediente2(String ingrediente2) {
        this.ingrediente2 = ingrediente2;
    }

    public String getIngrediente3() {
        return ingrediente3;
    }

    public void setIngrediente3(String ingrediente3) {
        this.ingrediente3 = ingrediente3;
    }

    public String getIngrediente4() {
        return ingrediente4;
    }

    public void setIngrediente4(String ingrediente4) {
        this.ingrediente4 = ingrediente4;
    }

    public String getIngrediente5() {
        return ingrediente5;
    }

    public void setIngrediente5(String ingrediente5) {
        this.ingrediente5 = ingrediente5;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }




}
