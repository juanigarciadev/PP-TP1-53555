import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Actividad {
    public static final int CUPO_MINIMO = 1;

    private int id;
    private String titulo;
    private int cupoMaximo;
    List<Inscripcion> inscripciones;

    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
        this.inscripciones = new ArrayList<>();
    }

    public Inscripcion inscribir(Estudiante estudiante) {
        Inscripcion inscripcion = new Inscripcion(estudiante, LocalDate.now(), "Confirmada");
        inscripciones.add(inscripcion);
        return inscripcion;
    };

    public void mostrarInscripciones() {
        for (Inscripcion inscripcion: inscripciones) {
            System.out.println(inscripcion);
        }
    }

    @Override
    public String toString() {
        return "  - #" + id + ": " + titulo +
                " (cupo máximo: " + cupoMaximo + ", inscriptos: " + inscripciones.size() + ")";
    }
}
