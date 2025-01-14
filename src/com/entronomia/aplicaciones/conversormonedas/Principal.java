package com.entronomia.aplicaciones.conversormonedas;

import com.entronomia.aplicaciones.conversormonedas.modelo.Moneda;
import com.entronomia.aplicaciones.conversormonedas.modelo.TipoDeCambio;
import com.google.gson.Gson;

import java.util.List;
import java.util.Scanner;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Double cantidadInicial;
        Double cantidadFinal;
        Double tasaDeCambio;
        Integer opcion = -1;
        String menu = """
        1. Convertir Dólares a Pesos Chilenos
        2. Convertir Pesos Chilenos a Dólares
        3. Convertir Dólares a Euros
        4. Convertir Euros a Dólares
        5. Convertir Dólares a Pesos Mexicanos
        6. Convertir Pesos Mexicanos a Dólares
        7. Convertir Dólares a Reales brasileños
        8. Convertir Reales brasileños a Dólares
        0. Salir
        """;
        String apiKey = "84e894583be8a2d094588ec8";
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";
        String json;
        Gson gson = new Gson();
        String fechaUltima;
        String fechaProxima;
        Double dolar;
        Double euro;
        Double pesoChile;
        Double pesoMexico;
        Double realBrasil;

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest requerimiento = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
        try {
            HttpResponse<String> respuesta = cliente.send(requerimiento, HttpResponse.BodyHandlers.ofString());
            json = respuesta.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        TipoDeCambio tipoDeCambio = gson.fromJson(json, TipoDeCambio.class);
        fechaUltima = tipoDeCambio.getFechaUltima();
        fechaProxima = tipoDeCambio.getFechaProxima();
        dolar = tipoDeCambio.getMoneda().getDolar();
        euro = tipoDeCambio.getMoneda().getEuro();
        pesoChile = tipoDeCambio.getMoneda().getPesoChile();
        pesoMexico = tipoDeCambio.getMoneda().getPesoMexico();
        realBrasil = tipoDeCambio.getMoneda().getRealBrasil();

        System.out.println("************************************************");
        System.out.println("Bienvenidos a este programa conversor de monedas");
        while(opcion != 0) {
            System.out.println(menu);
            System.out.println("Elija una opción por favor: " );
            opcion = Integer.parseInt(entrada.nextLine());
            switch (opcion) {
                case 1:
                    tasaDeCambio = pesoChile/dolar;
                    System.out.println("¿Qué cantidad desea convertir? ");
                    cantidadInicial = Double.parseDouble(entrada.nextLine());
                    cantidadFinal = cantidadInicial * tasaDeCambio;
                    System.out.println("" + cantidadInicial + " Dólares, equivalen a " + cantidadFinal + " Pesos Chilenos");
                    System.out.println("*********************************************************************************");
                    break;
                case 2:
                    tasaDeCambio = dolar/pesoChile;
                    System.out.println("¿Qué cantidad desea convertir? ");
                    cantidadInicial = Double.parseDouble(entrada.nextLine());
                    cantidadFinal = cantidadInicial * tasaDeCambio;
                    System.out.println("" + cantidadInicial + " Pesos Chilenos, equivalen a " + cantidadFinal + " Dólares");
                    System.out.println("*********************************************************************************");
                    break;
                case 3:
                    tasaDeCambio = euro/dolar;
                    System.out.println("¿Qué cantidad desea convertir? ");
                    cantidadInicial = Double.parseDouble(entrada.nextLine());
                    cantidadFinal = cantidadInicial * tasaDeCambio;
                    System.out.println("" + cantidadInicial + " Dólares, equivalen a " + cantidadFinal + " Euros");
                    System.out.println("*********************************************************************************");
                    break;
                case 4:
                    tasaDeCambio = dolar/euro;
                    System.out.println("¿Qué cantidad desea convertir? ");
                    cantidadInicial = Double.parseDouble(entrada.nextLine());
                    cantidadFinal = cantidadInicial * tasaDeCambio;
                    System.out.println("" + cantidadInicial + " Euros, equivalen a " + cantidadFinal + " Dólares");
                    System.out.println("*********************************************************************************");
                    break;
                case 5:
                    tasaDeCambio = pesoMexico/dolar;
                    System.out.println("¿Qué cantidad desea convertir? ");
                    cantidadInicial = Double.parseDouble(entrada.nextLine());
                    cantidadFinal = cantidadInicial * tasaDeCambio;
                    System.out.println("" + cantidadInicial + " Dólares, equivalen a " + cantidadFinal + " Pesos Mexicanos");
                    System.out.println("*********************************************************************************");
                    break;
                case 6:
                    tasaDeCambio = dolar/pesoMexico;
                    System.out.println("¿Qué cantidad desea convertir? ");
                    cantidadInicial = Double.parseDouble(entrada.nextLine());
                    cantidadFinal = cantidadInicial * tasaDeCambio;
                    System.out.println("" + cantidadInicial + " Pesos Mexicanos, equivalen a " + cantidadFinal + " Dólares");
                    System.out.println("*********************************************************************************");
                    break;
                case 7:
                    tasaDeCambio = realBrasil/dolar;
                    System.out.println("¿Qué cantidad desea convertir? ");
                    cantidadInicial = Double.parseDouble(entrada.nextLine());
                    cantidadFinal = cantidadInicial * tasaDeCambio;
                    System.out.println("" + cantidadInicial + " Dólares, equivalen a " + cantidadFinal + " Reales Brasileños");
                    System.out.println("*********************************************************************************");
                    break;
                case 8:
                    tasaDeCambio = dolar/realBrasil;
                    System.out.println("¿Qué cantidad desea convertir? ");
                    cantidadInicial = Double.parseDouble(entrada.nextLine());
                    cantidadFinal = cantidadInicial * tasaDeCambio;
                    System.out.println("" + cantidadInicial + " Reales Brasileños, equivalen a " + cantidadFinal + " Dólares");
                    System.out.println("*********************************************************************************");
                    break;
                case 0:
                    System.out.println("Proceso terminado");
                    break;
                default:
                    System.out.println("Error en la entrada elegida");
            }
        }

    }
}
