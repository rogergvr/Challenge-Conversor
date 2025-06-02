import java.util.Scanner;

public class ConversorMonedas {
    public void desplegarMenuOpciones(){
        String menuConversorMonedas = """
                ********************************************
                Bienvenido al Conversor de Monedas
                ********************************************
                
                ** Escriba la opción deseada **
                0. Dólar ==> Peso Argentino
                1. Peso Argentino ==> Dólar
                2. Dólar ==> Real Brasileño
                3. Real Brasileño ==> Dólar
                4. Dólar ==> Peso Colombiano
                5. Peso Colombiano ==> Dólar
                6. Dólar ==> Peso Chileno
                7. Peso Chileno ==> Dólar
                8. Dólar ==> Sol Peruano
                9. Sol Peruano ==> Dólar
                X. Salir
                
                Opción: 
                """;

        System.out.println(menuConversorMonedas);
    }

    public String otraMoneda (int opcionIngresada){
        switch (opcionIngresada){
            case 0, 1:
                return "ARS";
            case 2, 3:
                return "BRL";
            case 4, 5:
                return "COP";
            case 6, 7:
                return "CLP";
            case 8, 9:
                return "PEN";
        }
        return "";
    }

    public void mostrarResultado(String monedaOrigen,
                                 String monedaConversion,
                                 Double montoOrigen){

        ConsultaMoneda consulta = new ConsultaMoneda();
        Moneda moneda = consulta.buscaExchangeRate(monedaOrigen, monedaConversion);

        System.out.printf("El monto de %s %.2f es equivalente a %s %.2f \n\n", monedaOrigen, montoOrigen, monedaConversion, montoOrigen * Double.valueOf(moneda.conversion_rate()));

        return;
    }

    public boolean deseaContinuar(Scanner teclado){
        System.out.println("Desea continuar (S/N): ");
        if (teclado.nextLine().equalsIgnoreCase("N")) {
            System.out.println("Gracias por utilizar nuestro Conversor de Monedas!");
            return false;
        }
        else
            return true;
    }
}
