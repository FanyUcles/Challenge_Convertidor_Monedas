import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public void iteracion() {
        int opcion = 0;
        String menu = """
                **************************************************
                -------------------------------------------------
                Bienvenidos/as al Conversor de Moneda

                1) Dólar americano ==> Peso argentino
                2) Peso argentino ==> Dólar americano
                3) Dólar americano ==> Real brasileño
                4) Real brasileño ==> Dólar americano
                5) Dólar americano ==> Peso colombiano
                6) Peso colombiano ==> Dólar americano
                7) Euro ==> Dólar americano
                8) Dólar americano ==> Euro
                9) Ver historial
                10) Salir

                Elija una opción válida:
                **************************************************
                -------------------------------------------------
                """;
        String base_code, target_code;
        double monto;
        Historial historial = new Historial();
        Busqueda miBusqueda = new Busqueda(historial);

        while (opcion != 10) {
            System.out.println(menu);
            Scanner teclado = new Scanner(System.in);
            try {
                opcion = teclado.nextInt();
                if (opcion == 10) {
                    System.out.println("Finalizando la ejecución");
                    break;
                } else if (opcion < 1 || opcion > 10) {
                    System.out.println("Opción no válida\n");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Elija una opción válida\n");
                continue;
            }

            if (opcion == 9) {
                historial.mostrarHistorial();
                continue;
            }

            System.out.println("Ingrese el valor que desea convertir:");
            try {
                monto = teclado.nextDouble();
                if (monto < 0) {
                    System.out.println("Ingrese un valor númerico válido\n");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un valor númerico válido\n");
                continue;
            }

            switch (opcion) {
                case 1:
                    base_code = "USD";
                    target_code = "ARS";
                    miBusqueda.Resultado(base_code, target_code, monto);
                    break;
                case 2:
                    base_code = "ARS";
                    target_code = "USD";
                    miBusqueda.Resultado(base_code, target_code, monto);
                    break;
                case 3:
                    base_code = "USD";
                    target_code = "BRL";
                    miBusqueda.Resultado(base_code, target_code, monto);
                    break;
                case 4:
                    base_code = "BRL";
                    target_code = "USD";
                    miBusqueda.Resultado(base_code, target_code, monto);
                    break;
                case 5:
                    base_code = "USD";
                    target_code = "COP";
                    miBusqueda.Resultado(base_code, target_code, monto);
                    break;
                case 6:
                    base_code = "COP";
                    target_code = "USD";
                    miBusqueda.Resultado(base_code, target_code, monto);
                    break;
                case 7:
                    base_code = "EUR";
                    target_code = "USD";
                    miBusqueda.Resultado(base_code, target_code, monto);
                    break;
                case 8:
                    base_code = "USD";
                    target_code = "EUR";
                    miBusqueda.Resultado(base_code, target_code, monto);
                    break;
            }

            boolean nuevaConversion = preguntarNuevaConversion(teclado);
            if (!nuevaConversion) {
                break;
            }
        }
    }

    private boolean preguntarNuevaConversion(Scanner teclado) {
        while (true) {
            System.out.println("¿Desea hacer una nueva conversión? (si/no):");
            String respuesta = teclado.next().trim().toLowerCase();
            if (respuesta.equals("si")) {
                return true;
            } else if (respuesta.equals("no")) {
                System.out.println("Gracias por Utilizar nuestro servicio");
                return false;
            } else {
                System.out.println("Respuesta no válida, por favor escriba 'si' o 'no'.");
            }
        }
    }
}
