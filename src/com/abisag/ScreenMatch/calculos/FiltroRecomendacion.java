package com.abisag.ScreenMatch.calculos;

public class FiltroRecomendacion {

    public void filtro(Clasificacion clasificacion){
        if (clasificacion.getClasificacion()>=4){
            System.out.println("Muy bien evaluado en el momento");
        } else if (clasificacion.getClasificacion()>=2) {
            System.out.println("popular en el momento");
        }else{
            System.out.println("colocalo en tu lista para verlo despues");
        }
    }
}
