# Challenge: Conversor de monedas 💱
Este proyecto es un desafío (Challenge del Conversor de Monedas desarrollado durante un curso de Alura LATAM) diseñado para fortalecer habilidades en Java, consumo de APIs y lógica de programación.
Consiste en una aplicación que permite convertir un monto de una moneda a otra utilizando tasas de cambio actualizadas desde una API.

## 🚀 Funcionalidades
- **Convertir monedas**: Permite ingresar una cantidad en una moneda origen y obtener el equivalente en una moneda destino.
![image](https://github.com/user-attachments/assets/de75c7f2-d50d-4522-bee6-b685b5ebe646)

- **Selección dinámica de monedas**: Ofrece un menú para elegir tanto la moneda de origen como la de destino.
![image](https://github.com/user-attachments/assets/d5c5c9c1-e58f-4927-bf14-c3041c470728)

- **Consumo de API**: Utiliza una API de tipo exchange rates para obtener las tasas de cambio en tiempo real.
- **Validaciones básicas** : Comprueba que los valores ingresados sean numéricos y positivos.

## 🛠️ Cómo funciona el código
El proyecto está escrito en Java, aplicando conceptos de programación orientada a objetos y el uso del cliente HTTP de Java  para realizar solicitudes a la API.
1. **`ConsultaApiConversor()`**: 
   - Clase encargada de realizar la petición HTTP GET a la API de tasas de cambio y procesar el JSON de respuesta.
   - Extrae la tasa de conversión entre la moneda origen y la destino.

2. **`Principal()`**:
   - Controla el flujo principal del programa, mostrando un menú interactivo al usuario para seleccionar monedas, ingresar montos y mostrar resultados.
   - Llama a ConsultaApiConversor para obtener el valor convertido.
     
3. **`Manejo de errores()`**: 
   - Incluye try/catch para manejar errores de red o de formato en la respuesta JSON.

## 📋 Cómo usar

1. **Ejecutar el programa**:
   - Compila y ejecuta el proyecto con un IDE como IntelliJ o desde la terminal usando javac y java.
2. **Ingresar datos:**:
   - Selecciona la moneda origen y destino desde el menú mostrado en consola.
   - Ingresa la cantidad que deseas convertir.
     
3. **Ver resultado**:
   - El programa mostrará el monto equivalente en la moneda seleccionada según la tasa actual.
   - 
## 🎥 Tutorial
Estoy preparando un video explicando paso a paso cómo funciona este programa y cómo puedes usarlo o modificarlo.

👉 Ver tutorial en YouTube (enlace próximamente disponible)
