import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Busqueda {
    private static final String API_KEY = "8da546170c1d3ca7833e9ca8";
    private Historial historial;

    public Busqueda(Historial historial) {
        this.historial = historial;
    }

    public Convertir buscaquedaAConvetir(String base_code, String target_code, double cantidad) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + base_code);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Convertir convertir = new Gson().fromJson(response.body(), Convertir.class);
            double conversionRate = convertir.getConversionRate(target_code);
            return new Convertir(base_code, target_code, cantidad * conversionRate);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void Resultado(String base_code, String target_code, double cantidad) {
        Convertir resultado = buscaquedaAConvetir(base_code, target_code, cantidad);
        double conversion = resultado.conversion_result();
        historial.agregarRegistro(base_code, target_code, cantidad, conversion);
        System.out.println("El valor " + cantidad + " [" + base_code + "] " + "corresponde al valor de =====> " + conversion + " [" + target_code + "]\n");
    }
}