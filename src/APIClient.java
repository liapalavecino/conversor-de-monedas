import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Map;

public class APIClient {
    public static void main(String[] args) {
        try {
            // Crea el HttpClient
            HttpClient client = HttpClient.newHttpClient();

            // Configura el HttpRequest
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/994251c81d44019be2fa735a/latest/USD")) // Esta
                                                                                                               // es mi
                                                                                                               // URL
                                                                                                               // con la
                                                                                                               // key
                    .GET()
                    .build();

            // Envia la solicitud y se obtiene respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Código de estado: " + response.statusCode());

            // Analiza con Gson la respuesta 
            Gson gson = new Gson();
            APIResponse apiResponse = gson.fromJson(response.body(), APIResponse.class);

            // Muestra datos
            System.out.println("Moneda base: " + apiResponse.getBase_code());
            System.out.println("Tasas de cambio:");
            for (Map.Entry<String, Double> rate : apiResponse.getConversion_rates().entrySet()) {
                System.out.println(rate.getKey() + ": " + rate.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
