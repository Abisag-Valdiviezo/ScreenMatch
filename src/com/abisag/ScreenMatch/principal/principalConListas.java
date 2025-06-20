package com.abisag.ScreenMatch.principal;

import com.abisag.ScreenMatch.modelos.Pelicula;
import com.abisag.ScreenMatch.modelos.Serie;
import com.abisag.ScreenMatch.modelos.Titulo;

import java.util.*;

public class principalConListas {
    public static void main(String[] args) {

        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.evalua(9);
        Pelicula otraPelicula = new Pelicula("Matrix",1998);
        otraPelicula.evalua(6);
        var pelicula = new Pelicula("El señor de los anillos",2001);
        pelicula.evalua(10);
        Serie casaDragon = new Serie("Casa Dragón",2022);

        Pelicula p1 = pelicula;

        List<Titulo> lista = new LinkedList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(pelicula);
        lista.add(casaDragon);

        for(Titulo item: lista){
            System.out.println(item.getNombre());
            if(item instanceof Pelicula pelicula1 && pelicula1.getClasificacion()>2){
                System.out.println(pelicula1.getClasificacion());
            }

        }

        ArrayList<String> listaDeArtista = new ArrayList<>();
        listaDeArtista.add("Penelope Cruz");
        listaDeArtista.add("Antonio Bandera");
        listaDeArtista.add("Ricardo Darin");
        System.out.println(listaDeArtista);

        Collections.sort(listaDeArtista);
        System.out.println("Lista de artistas ordenada"+listaDeArtista);

        Collections.sort(lista);
        System.out.println("lista de titulos ordenados: "+lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("lista ordenada por fecha: "+lista);


    }
}
