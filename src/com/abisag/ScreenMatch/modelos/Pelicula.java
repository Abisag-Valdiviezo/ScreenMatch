package com.abisag.ScreenMatch.modelos;

import com.abisag.ScreenMatch.calculos.Clasificacion;

public class Pelicula extends Titulo implements Clasificacion {

    private String director;

    public Pelicula(String nombre, int fechaDeLanzamiento) {
        super(nombre, fechaDeLanzamiento);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClasificacion() {
        return (int) (caulculaMedia() / 2);
    }

    @Override
    public String toString() {
        return "Pelicula: "+this.getNombre()+" ("+getFechaDeLanzamiento()+")";
    }
}
