import java.util.Scanner;
import java.util.UUID;


public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Sistema de creación de eventos");
        System.out.println("======================");

        UUID uuid = UUID.randomUUID();
        String Id = uuid.toString();


        System.out.println("Ingrese el nombre del evento: ");
        String titulo = teclado.nextLine();

        System.out.println("¿El evento es gratuito? S/N: ");
        String respuestaGratuito = teclado.nextLine();
        boolean gratuito = false;

        if (respuestaGratuito.equals("S")) {
            gratuito = true;
        } else if (respuestaGratuito.equals("N")) {
            gratuito = false;
        } else {
            System.out.println("Respuesta incorrecta.");
        }

        double costoBase;

        if (!gratuito) {
            System.out.println("Ingrese el costo base: ");
            // CORRECCIÓN 2: Usamos nextDouble() para leer el número decimal
            costoBase = teclado.nextDouble();
        } else {
            costoBase = 0;
        }

        EventoUniversitario evento = new EventoUniversitario(Id, titulo, costoBase, gratuito);

        System.out.println("Evento creado con éxito");

        System.out.println("Creando copia del evento...");
        EventoUniversitario copiaEvento = new EventoUniversitario(evento);
        System.out.println("Copia de evento creada con éxito");

        System.out.println("======================");
        System.out.println("Datos del evento:");
        System.out.println(evento);

        System.out.println("======================");
        System.out.println("Datos de la copia:");
        System.out.println(copiaEvento);

        System.out.println("======================");
        System.out.println("Cantidad de eventos: " + EventoUniversitario.getContadorEventos());
    }
}