import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        String monedaOrigen = "";
        String monedaConversion = "";

        ConsultaMoneda consulta = new ConsultaMoneda();
        System.out.println("Escriba la moneda origen:");
        monedaOrigen = lectura.nextLine();
        System.out.println("Escriba la moneda a la que desea convertir:");
        monedaConversion = lectura.nextLine();
        Moneda moneda = consulta.buscaExchangeRate(monedaOrigen, monedaConversion);
        System.out.println(moneda);
    }
}
