package com.abisag.ScreenMatch.calculos;
import com.abisag.ScreenMatch.modelos.Pelicula;
import com.abisag.ScreenMatch.modelos.Titulo;

public class CalculadoraDeTiempo {

    private int tiempoTotal;

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public void incluye(Titulo titulo){
        System.out.println("Agregando duración de minutos de: "+titulo);
        this.tiempoTotal += titulo.getDuracionEnMinutos();
    }
}
