package com.aluracursos.conversorapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConsultaApi {
    public static void main(String[] args) throws MalformedURLException {
        try {
        URL url = new URL("https://v6.exchangerate-api.com/v6/802e64c7322651d23603617f/latest/usd");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if(responseCode == 200){
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null){
                   response.append(line);
                }
                reader.close();

                System.out.println("Respuesta de la API: " +response.toString());
                connection.disconnect();
            }else{
                throw new RuntimeException("Error al conectarse a la API :" + responseCode);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
