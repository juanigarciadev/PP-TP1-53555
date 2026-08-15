import java.util.Scanner;

public class GestionEstudiantes {
    String respuestaCrearMas;

    public void iniciar(Scanner teclado) {
        do {
            Utilidades.limpiarConsola();
            System.out.println("\n--- Módulo: Creación de estudiantes ---");

            String legajo;
            System.out.println("Ingrese el legajo del estudiante:");
            legajo = teclado.nextLine();

            String nombre;
            System.out.println("Ingrese el nombre del estudiante: ");
            do {
                nombre = teclado.nextLine();
            } while (legajo.isEmpty());

            Estudiante estudiante = new Estudiante(legajo, nombre);

            System.out.println("======================");
            System.out.println("¡Estudiante creado con éxito!");
            System.out.println("Legajo: " + legajo);
            System.out.println("Nombre: " + nombre);
            System.out.println("======================");

            System.out.println("¿Desea crear más estudiantes? S/N");
            respuestaCrearMas = teclado.nextLine();
        } while (respuestaCrearMas.equalsIgnoreCase("S"));

    }

}
