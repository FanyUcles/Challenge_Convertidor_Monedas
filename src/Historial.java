import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Historial {
    private List<String> registros;

    public Historial() {
        registros = new ArrayList<>();
    }

    public void agregarRegistro(String base_code, String target_code, double cantidad, double resultado) {
        LocalDateTime ahora = LocalDateTime.now();
        String registro = String.format("%s: %f %s -> %f %s", ahora, cantidad, base_code, resultado, target_code);
        registros.add(registro);
    }

    public void mostrarHistorial() {
        if (registros.isEmpty()) {
            System.out.println("No hay historial para mostrar.\n");
        } else {
            System.out.println("Historial de conversiones:");
            for (String registro : registros) {
                System.out.println(registro);
            }
        }
    }

    public boolean estaVacio() {
        return registros.isEmpty();
    }
}
