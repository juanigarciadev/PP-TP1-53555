public class EventoUniversitario {
    private final String Id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;

    private static int contadorEventos = 0;

    public EventoUniversitario(String Id, String titulo, double costoBase, boolean gratuito){
        this.Id = Id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        contadorEventos++;
    }

    public EventoUniversitario(EventoUniversitario otroEvento) {
        this(otroEvento.Id + "-COPIA", otroEvento.titulo, otroEvento.costoBase, otroEvento.gratuito);
    }

    public static int getContadorEventos() {
        return contadorEventos;
    }

    @Override
    public String toString() {
        return "Evento [ID=" + Id +
                ", Título=" + titulo +
                ", Costo=" + costoBase +
                ", Gratuito=" + gratuito;
    }

}


