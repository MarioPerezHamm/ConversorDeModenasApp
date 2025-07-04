package com.aluracursos.conversorapp.consultaapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApiConversor {
    private String apiKey = "802e64c7322651d23603617f";
    private String baseUrl = "https://v6.exchangerate-api.com/v6/";

    public ConsultaApiConversorRecord obtenerTasas(String monedaBase){

        String url = baseUrl + apiKey + "/latest/" + monedaBase;
        try {
            Gson gson = new GsonBuilder()
                    //.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setPrettyPrinting()
                    .create();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();


            HttpResponse<String > response = client.send(request, HttpResponse.BodyHandlers.ofString());
           // System.out.println(response.body());
            return gson.fromJson(response.body(), ConsultaApiConversorRecord.class);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


}
