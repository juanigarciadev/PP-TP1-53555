import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {
    private final String Id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private Sala sala;
    private List<Actividad> actividades;

    private static int contadorEventos = 0;

    public EventoUniversitario(String Id, String titulo, double costoBase, boolean gratuito){
        this.Id = Id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        contadorEventos++;
        this.actividades = new ArrayList<>();
    }

    public EventoUniversitario(EventoUniversitario copiaEvento) {
        this(copiaEvento.Id + "-COPIA", copiaEvento.titulo, copiaEvento.costoBase, copiaEvento.gratuito);
        this.actividades = new ArrayList<>(copiaEvento.actividades);
        this.sala = copiaEvento.sala;
    }

    public static int getContadorEventos() {
        return contadorEventos;
    }

    public void asignarSala(Sala sala) {
        this.sala = sala;
    }

    public void crearActividad(int id, String titulo, int cupo) {
        Actividad actividad = new Actividad(id, titulo, cupo);
        this.actividades.add(actividad);
    }

    public void mostrarActividades() {
        for (Actividad actividad: actividades) {
            System.out.println(actividad);
        }
    }

    // Usado solamente para poblar
    public List<Actividad> getActividades() {
        return actividades;
    }

    @Override
    public String toString() {
        return "Evento [ID: " + Id +
                ", Título: " + titulo +
                ", Costo: " + costoBase +
                ", Gratuito: " + (gratuito ? "Si" : "No") +
                ", Sala: " + (sala != null ? sala.getNombre() : "Sin asignar") + "]";
    }

}


