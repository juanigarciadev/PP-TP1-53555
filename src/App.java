import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String opcion = "";

        do {
            Utilidades.limpiarConsola();
            System.out.println("======================================");
            System.out.println("          SELECTOR DE MÓDULOS          ");
            System.out.println("======================================");
            System.out.println("1. Gestión de eventos universitarios");
            System.out.println("2. Gestión de estudiantes");
            System.out.println("3. Inscripción a eventos");
            System.out.println("4. Gestión de salas");
            System.out.println("5. Salir del sistema");
            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextLine();

            switch (opcion) {
                case "1":
                    GestionEventos moduloEventos = new GestionEventos();
                    moduloEventos.iniciar(teclado);
                    break;
                case "2":
                    GestionEstudiantes moduloEstudianes = new GestionEstudiantes();
                    moduloEstudianes.iniciar(teclado);
                    break;
                case "3", "4":
                    System.out.println("¡Próximamente!");
                    break;
                case "5":
                    System.out.println("Saliendo del sistema principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (!opcion.equals("5"));

        teclado.close();
    }
}