import com.abisag.ScreenMatch.calculos.CalculadoraDeTiempo;
import com.abisag.ScreenMatch.calculos.FiltroRecomendacion;
import com.abisag.ScreenMatch.modelos.Episodio;
import com.abisag.ScreenMatch.modelos.Pelicula;
import com.abisag.ScreenMatch.modelos.Serie;

import java.util.ArrayList;
import java.util.Objects;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.setDuracionEnMinutos(120);
        miPelicula.setIncluidoEnElPlan(true);

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(10);
        miPelicula.evalua(10);
        miPelicula.evalua(7.8);


        System.out.println(miPelicula.getTotalDeLasEvaluaciones());
        System.out.println(miPelicula.caulculaMedia());

        Serie casaDragon = new Serie("Casa Dragón",2022);
        casaDragon.setTemporadas(1);
        casaDragon.setMinutosPorEpisodio(50);
        casaDragon.setEpisodiosPorTemporada(10);
        casaDragon.muestraFichaTecnica();
        System.out.println(casaDragon.getDuracionEnMinutos());

        Pelicula otraPelicula = new Pelicula("Matrix",1998);
        otraPelicula.setDuracionEnMinutos(180);


        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDragon);
        calculadora.incluye(otraPelicula);
        System.out.println("Tiempo para ver tus titulos " + calculadora.getTiempoTotal() + "minutos");


        FiltroRecomendacion filtroRecomendacion =new FiltroRecomendacion();
        filtroRecomendacion.filtro(miPelicula);
        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("la casa Targaryen");
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizacion(50);

        filtroRecomendacion.filtro(episodio);


        var pelicula = new Pelicula("El señor de los anillos",2001);
        pelicula.setDuracionEnMinutos(180);

        ArrayList<Pelicula>listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(pelicula);
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(otraPelicula);

        System.out.println("Tamaño de la lista: "+listaDePeliculas.size());
        System.out.println("La primera pelicula es: "+listaDePeliculas.get(0).getNombre());

        System.out.println(listaDePeliculas.toString());

        System.out.println("toString de la pelicula: "+listaDePeliculas.get(0).toString());



    }
}
