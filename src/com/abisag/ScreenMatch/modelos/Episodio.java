package com.abisag.ScreenMatch.modelos;

import com.abisag.ScreenMatch.calculos.Clasificacion;

public class Episodio implements Clasificacion {

    private int numero;
    private String nombre;
    private Serie serie;

    public int getTotalVisualizacion() {
        return totalVisualizacion;
    }

    public void setTotalVisualizacion(int totalVisualizacion) {
        this.totalVisualizacion = totalVisualizacion;
    }

    private int totalVisualizacion;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public int getClasificacion() {
        if(totalVisualizacion >100){
            return 4;
        }else{
            return 2;
        }
    }
}
