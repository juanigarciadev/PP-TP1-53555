import java.util.Scanner;
import java.util.UUID;

public class GestionEventos {

    // Método que ejecuta este módulo específico
    public void iniciar(Scanner teclado) {
        String respuestaCrearMas;

        do {
            Utilidades.limpiarConsola();
            System.out.println("\n--- Módulo: Creación de eventos ---");

            // ===========================================================================
            // Ingreso de datos principales del evento

            UUID uuid = UUID.randomUUID();
            String Id = uuid.toString();

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
            teclado.nextLine(); // Limpieza de buffer

            if (costoBase == 0) {
                gratuito = true;
                System.out.println("Evento configurado como gratuito (costo base es 0)");
            }

            // Se crea el evento con los datos básicos para poder asignarle actividades y salas antes de mostrar todos los datos
            EventoUniversitario evento = new EventoUniversitario(Id, titulo, costoBase, gratuito);

            // ===========================================================================

            // ===========================================================================
            // Creacion de actividades para el evento

            String respuestaCrearMasAct;
            System.out.println("======================");
            System.out.println("Cree al menos una actividad para este evento.");

            do {
                int uuidActividad;
                System.out.println("ID de la actividad: ");
                uuidActividad = teclado.nextInt();
                teclado.nextLine(); // limpieza de buffer

                String tituloActividad;
                System.out.println("Titulo de la actividad: ");
                tituloActividad = teclado.nextLine();

                int cupoMaximoActividad;
                System.out.println("Cupo máximo para la actividad " + "'" + tituloActividad + "'" + ": ");
                cupoMaximoActividad = teclado.nextInt();
                teclado.nextLine(); // limpieza de buffer

                evento.crearActividad(uuidActividad, tituloActividad, cupoMaximoActividad);

                System.out.println("¿Desea crear más actividades? S/N");
                respuestaCrearMasAct = teclado.nextLine();

            } while (respuestaCrearMasAct.equalsIgnoreCase("S"));

            // ===========================================================================


            // ===========================================================================
            // Creacion del evento completo

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

            // ===========================================================================

            System.out.println("¿Desea crear más eventos? S/N");
            respuestaCrearMas = teclado.nextLine();

        } while (respuestaCrearMas.equalsIgnoreCase("S"));

        System.out.println("Saliendo del módulo de eventos...\n");
    }
}
