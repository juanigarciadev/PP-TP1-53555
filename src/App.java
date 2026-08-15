import java.util.Scanner;
import java.util.UUID;


public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String respuestaCrearMas;

        System.out.println("Sistema de creación de eventos");
        System.out.println("======================");

        do {
            UUID uuid = UUID.randomUUID();
            String Id = uuid.toString();


            System.out.println("Ingrese el nombre del evento: ");
            String titulo = teclado.nextLine();

            boolean gratuito = false;
            double costoBase;

            System.out.println("Ingrese el costo base: ");
            // Usamos nextDouble() para leer el número decimal
            costoBase = teclado.nextDouble();
            teclado.nextLine(); // Limpieza del salto de línea residual que introduce teclado.nextDouble()
            if (costoBase == 0) {
                gratuito = true;
                System.out.println("Evento configurado como gratuito (costo base es 0)");
            };


            EventoUniversitario evento = new EventoUniversitario(Id, titulo, costoBase, gratuito);


            System.out.println("======================");
            System.out.println("Evento creado con éxito:");
            System.out.println(evento);

            System.out.println("Creando copia del evento...");
            EventoUniversitario copiaEvento = new EventoUniversitario(evento);
            System.out.println("Datos de la copia:");
            System.out.println(copiaEvento);

            System.out.println("======================");
            System.out.println("Cantidad de eventos: " + EventoUniversitario.getContadorEventos());

            System.out.println("¿Desea crear más eventos? S/N");
            respuestaCrearMas = teclado.nextLine();

        } while (respuestaCrearMas.equalsIgnoreCase("S"));
    }
}