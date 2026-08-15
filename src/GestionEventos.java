import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class GestionEventos {

    public void iniciar(Scanner teclado, List<EventoUniversitario> eventos) {
        String opcion;

        do {
            Utilidades.limpiarConsola();
            System.out.println("\n--- Módulo: Eventos Universitarios ---");
            System.out.println("1. Crear evento");
            System.out.println("2. Mostrar eventos");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextLine();

            switch (opcion) {
                case "1":
                    crearEvento(teclado, eventos);
                    break;
                case "2":
                    mostrarEventos(eventos);
                    break;
                case "3":
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            if (!opcion.equals("3")) {
                System.out.println("\nPresione Enter para continuar...");
                teclado.nextLine();
            }

        } while (!opcion.equals("3"));
    }

    private void crearEvento(Scanner teclado, List<EventoUniversitario> eventos) {
        System.out.println("\n--- Creación de evento ---");

        String id = UUID.randomUUID().toString();

        System.out.println("Ingrese el nombre del evento: ");
        String titulo;
        do {
            titulo = teclado.nextLine();
        } while (titulo.isEmpty());

        boolean gratuito = false;
        double costoBase;

        System.out.println("Ingrese el costo base: ");
        do {
            costoBase = teclado.nextDouble();
        } while (costoBase < 0);
        teclado.nextLine(); // limpieza de buffer

        if (costoBase == 0) {
            gratuito = true;
            System.out.println("Evento configurado como gratuito (costo base es 0)");
        }

        EventoUniversitario evento = new EventoUniversitario(id, titulo, costoBase, gratuito);

        String respuestaCrearMasAct;
        System.out.println("======================");
        System.out.println("Cree al menos una actividad para este evento.");

        do {
            int idActividad;
            System.out.println("ID de la actividad: ");
            idActividad = teclado.nextInt();
            teclado.nextLine();

            String tituloActividad;
            System.out.println("Titulo de la actividad: ");
            tituloActividad = teclado.nextLine();

            int cupoMaximoActividad;
            System.out.println("Cupo máximo para la actividad '" + tituloActividad + "': ");
            cupoMaximoActividad = teclado.nextInt();
            teclado.nextLine();

            evento.crearActividad(idActividad, tituloActividad, cupoMaximoActividad);

            System.out.println("¿Desea crear más actividades? S/N");
            respuestaCrearMasAct = teclado.nextLine();

        } while (respuestaCrearMasAct.equalsIgnoreCase("S"));

        eventos.add(evento);

        System.out.println("======================");
        System.out.println("Evento creado con éxito:");
        System.out.println(evento);
        System.out.println("Actividades: ");
        evento.mostrarActividades();

        System.out.println("Creando copia del evento...");
        EventoUniversitario copiaEvento = new EventoUniversitario(evento);
        System.out.println("Datos de la copia:");
        System.out.println(copiaEvento);

        System.out.println("======================");
        System.out.println("Cantidad de eventos: " + EventoUniversitario.getContadorEventos());
    }

    private void mostrarEventos(List<EventoUniversitario> eventos) {
        System.out.println("\n--- Lista de eventos ---");

        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados.");
            return;
        }

        for (EventoUniversitario evento : eventos) {
            System.out.println(evento);
            evento.mostrarActividades();
            System.out.println("----------------------");
        }
    }
}