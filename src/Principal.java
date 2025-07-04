import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Map;
public class Principal {
    public static void main(String[] args) {
        // Mapa con las siglas y el país de la moneda
        Map<String, String> monedas = new LinkedHashMap<>();
        monedas.put("USD", "Estados Unidos");
        monedas.put("EUR", "Unión Europea");
        monedas.put("JPY", "Japón");
        monedas.put("GBP", "Reino Unido");
        monedas.put("AUD", "Australia");
        monedas.put("CAD", "Canadá");
        monedas.put("CHF", "Suiza");
        monedas.put("CNY", "China");
        monedas.put("INR", "India");
        monedas.put("BRL", "Brasil");
        monedas.put("MXN", "México");
        monedas.put("ARS", "Argentina");
        monedas.put("COP", "Colombia");
        monedas.put("CLP", "Chile");
        monedas.put("KRW", "Corea del Sur");
        monedas.put("RUB", "Rusia");
        monedas.put("TRY", "Turquía");
        monedas.put("SEK", "Suecia");
        monedas.put("NOK", "Noruega");
        monedas.put("DKK", "Dinamarca");
        monedas.put("ZAR", "Sudáfrica");
        monedas.put("NZD", "Nueva Zelanda");
        monedas.put("SGD", "Singapur");
        monedas.put("HKD", "Hong Kong");
        monedas.put("PLN", "Polonia");
        monedas.put("THB", "Tailandia");
        monedas.put("TWD", "Taiwán");
        monedas.put("SAR", "Arabia Saudita");
        monedas.put("AED", "Emiratos Árabes Unidos");
        monedas.put("ILS", "Israel");
        monedas.put("MYR", "Malasia");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Conversor de Monedas");
            System.out.println("=====================");
            System.out.println("Monedas disponibles:");
            System.out.printf("%-8s | %-30s%n", "Código", "País");
            System.out.println("------------------------------------------");

            for (Map.Entry<String, String> entry : monedas.entrySet()) {
                System.out.printf("%-8s | %-30s%n", entry.getKey(), entry.getValue());
            }

            System.out.println("Moneda Base (por ej: USD):");
            String monedaBase = scanner.nextLine().toUpperCase();

            System.out.println("Moneda destino (por ej: EUR):");
            String monedaDestino = scanner.nextLine().toUpperCase();

            System.out.println("Cantidad de " + monedaBase+" a convertir:");
            double monto = scanner.nextDouble();

            ConsultaApiConversor consulta = new ConsultaApiConversor();
            ConsultaApiConversorRecord datos = consulta.obtenerTasas(monedaBase);

            if ("success".equals(datos.result())) {
                Double tasaDeCambio = datos.conversion_rates().get(monedaDestino);
                if (tasaDeCambio != null) {
                    double conversion = monto * tasaDeCambio;
                    System.out.println("=====================");
                    System.out.println("Conversion realizada con exito:");
                    System.out.printf("%.2f %s son %.2f %s%n", monto, monedaBase, conversion, monedaDestino);
                } else {
                    System.out.println("Moneda destino no soportada.");
                }
            } else {
                System.out.println("No se pudo obtener las tasas de cambio.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
