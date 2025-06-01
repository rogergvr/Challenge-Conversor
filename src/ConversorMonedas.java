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
}
