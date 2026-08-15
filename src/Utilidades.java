import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Utilidades {
    public static void limpiarConsola() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void poblarSistema(List<Estudiante> estudiantes, List<EventoUniversitario> eventos) {
        // Estudiantes de prueba
        estudiantes.add(new Estudiante("1001", "Ana Pérez"));
        estudiantes.add(new Estudiante("1002", "Juan López"));
        estudiantes.add(new Estudiante("1003", "María Gómez"));

        // Evento 1: gratuito, con dos actividades
        EventoUniversitario evento1 = new EventoUniversitario(
                UUID.randomUUID().toString(), "Hackathon UTN", 0, true);
        evento1.asignarSala(new Sala(1, "Auditorio Principal"));
        evento1.crearActividad(1, "Desarrollo de Prototipo", 20);
        evento1.crearActividad(2, "Charla de Cierre", 50);

        // Evento 2: pago, con una actividad
        EventoUniversitario evento2 = new EventoUniversitario(
                UUID.randomUUID().toString(), "Jornada de Innovación", 500.0, false);
        evento2.asignarSala(new Sala(2, "Sala 3B"));
        evento2.crearActividad(3, "Taller de Robótica", 15);

        eventos.add(evento1);
        eventos.add(evento2);

        // Inscripciones de prueba
        evento1.getActividades().get(0).inscribir(estudiantes.get(0)); // Ana -> Desarrollo de Prototipo
        evento1.getActividades().get(0).inscribir(estudiantes.get(1)); // Juan -> Desarrollo de Prototipo
        evento1.getActividades().get(1).inscribir(estudiantes.get(2)); // María -> Charla de Cierre
        evento2.getActividades().get(0).inscribir(estudiantes.get(0)); // Ana también en Taller de Robótica
    }
}
