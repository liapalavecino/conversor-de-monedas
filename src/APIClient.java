import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIClient {
    public static void main(String[] args) {
        try {
            // Crea el HttpClient
            HttpClient client = HttpClient.newHttpClient();

            // Configura el HttpRequest
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/994251c81d44019be2fa735a/latest/USD")) // Esta es mi URL con la key
                    .GET()
                    .build();

            // Envia la solicitud y se obtiene respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Muestra código de estado
            System.out.println("Código de estado: " + response.statusCode());

            // Muestra el body de la respuesta
            System.out.println("Cuerpo de la respuesta: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
