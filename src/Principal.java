import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcionIngresada = 0;
        String opcion = "";
        String monedaOrigen = "";
        String monedaConversion = "";
        double montoOrigen = 0;
        double montoConvertido = 0;
        ConsultaMoneda consulta = new ConsultaMoneda();
        ConversorMonedas conversor = new ConversorMonedas();

        while (opcionIngresada <= 9){
            conversor.desplegarMenuOpciones();
            opcion = teclado.nextLine();
            if (opcion.equalsIgnoreCase("X"))
                opcionIngresada = 10;
            else {
                opcionIngresada = Integer.parseInt(opcion);// valueOf(opcion);
                //System.out.println("Opcion ingresada: " + opcionIngresada);
            }

            switch (opcionIngresada) {
                case 0:
                    monedaOrigen = "USD";
                    monedaConversion = "ARS";
                    break;
                case 1:
                    monedaOrigen = "ARS";
                    monedaConversion = "USD";
                    break;
                case 2:
                    monedaOrigen = "USD";
                    monedaConversion = "BRL";
                    break;
                case 3:
                    monedaOrigen = "BRL";
                    monedaConversion = "USD";
                    break;
                case 4:
                    monedaOrigen = "USD";
                    monedaConversion = "COP";
                    break;
                case 5:
                    monedaOrigen = "COP";
                    monedaConversion = "USD";
                    break;
                case 6:
                    monedaOrigen = "USD";
                    monedaConversion = "CLP";
                    break;
                case 7:
                    monedaOrigen = "CLP";
                    monedaConversion = "USD";
                    break;
                case 8:
                    monedaOrigen = "USD";
                    monedaConversion = "PEN";
                    break;
                case 9:
                    monedaOrigen = "PEN";
                    monedaConversion = "USD";
                    break;
                case 10:
                    System.out.println("Gracias por utilizar nuestro Conversor de Monedas!");
                    return;
                default:
                    System.out.println("No ha ingresado una opción válida");
            }
            //System.out.printf("Monedas seleccionadas: %s y %s", monedaOrigen, monedaConversion);

            Moneda moneda = consulta.buscaExchangeRate(monedaOrigen, monedaConversion);
            //System.out.println(moneda);
            System.out.println("Ingrese el monto que desea convertir");
            montoOrigen = Double.valueOf(teclado.nextLine());
            montoConvertido = montoOrigen * Double.valueOf(moneda.conversion_rate());
            System.out.printf("El monto de %s %.2f es equivalente a %s %.2f \n\n", monedaOrigen, montoOrigen, monedaConversion, montoConvertido);
            System.out.println("Desea continuar (S/N): ");
            opcion = teclado.nextLine();
            if (opcion.equalsIgnoreCase("N")){
                System.out.println("Gracias por utilizar nuestro Conversor de Monedas!");
                return;
            }
        }
    }
}
