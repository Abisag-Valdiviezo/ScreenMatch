package com.abisag.ScreenMatch.principal;

import com.abisag.ScreenMatch.exception.ErrorEnConversionDeDuracionException;
import com.abisag.ScreenMatch.modelos.Titulo;
import com.abisag.ScreenMatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner lectura = new Scanner(System.in);
        List<Titulo> titulo= new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (true){
            System.out.println("Escriba el nombre de una pelicula: ");
            var busqueda = lectura.nextLine();

            if(busqueda.equalsIgnoreCase("salir")){
                break;
            }

            String clave = "d4d0bf92";
            String direccion = "https://www.omdbapi.com/?t="+
                    busqueda.replace(" ", "+")+
                    "&apikey="+clave;

            try{
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);


                TituloOmdb miTituloOmdb= gson.fromJson(json, TituloOmdb.class);
                System.out.println(miTituloOmdb);

                Titulo miTitulo= new Titulo(miTituloOmdb);
                System.out.println("Titulo ya convertido"+miTitulo);

                titulo.add(miTitulo);

            }catch (NumberFormatException e){
                System.out.println("Ocurrio un error: ");
                System.out.println(e.getMessage());
            }catch (IllegalArgumentException e){
                System.out.println("Error en la URI, Verifique la dirección.");
            }catch (ErrorEnConversionDeDuracionException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println(titulo);

        FileWriter escritura = new FileWriter("titulos.json");
        escritura.write(gson.toJson(titulo));
        escritura.close();
        System.out.println("Finalizó la ejecución del programa");




    }
}
