package com.aluracursos.conversorapp.consultaapi;

import java.util.Map;
public record ConsultaApiConversorRecord(String result, String base_code, Map<String, Double> conversion_rates) {
}
