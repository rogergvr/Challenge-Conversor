import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String opcion = "";
        int opcionIngresada = 0;
        String monedaOrigen = "";
        String monedaConversion = "";
        double montoOrigen = 0;
        ConversorMonedas conversor = new ConversorMonedas();

        while (opcionIngresada <= 9){
            conversor.desplegarMenuOpciones();
            opcion = teclado.nextLine();

            try {
                if (opcion.equalsIgnoreCase("X"))
                    opcionIngresada = 10;
                else {
                    opcionIngresada = Integer.parseInt(opcion);// valueOf(opcion);
                }

                switch (opcionIngresada){
                    case 0, 2, 4, 6, 8:
                        monedaOrigen = "USD";
                        monedaConversion = conversor.otraMoneda(opcionIngresada);
                        break;
                    case 1, 3, 5, 7, 9:
                        monedaOrigen = conversor.otraMoneda(opcionIngresada);
                        monedaConversion = "USD";
                        break;
                    case 10:
                        System.out.println("Gracias por utilizar nuestro Conversor de Monedas!");
                        return;
                    default:
                        //System.out.println("No ha ingresado una opción válida");
                        throw new NumberFormatException();
                }

                System.out.printf("Ingrese el monto en %s que desea convertir: ", monedaOrigen);
                conversor.mostrarResultado(monedaOrigen, monedaConversion, Double.valueOf(teclado.nextLine()));
                if (!conversor.deseaContinuar(teclado))
                    return;
            }
            catch (NumberFormatException e){
                System.out.println("No ha ingresado una opción válida. Por favor, revise las opciones.\n\n");
            }
        }
    }
}
