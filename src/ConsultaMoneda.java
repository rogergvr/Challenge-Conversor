import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Moneda buscaExchangeRate(String monedaOrigen, String monedaConversion){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/92a4783ac849dee57e4792b8/pair/" + monedaOrigen + "/" + monedaConversion);
        System.out.println("Direccion: " + direccion);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            //System.out.println("Inicio Try");
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            //System.out.println("Response: " + response);
            //System.out.println("Fin Try");
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré la moneda");
        }

    }

}
