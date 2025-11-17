package claseSala;

public class claseSala {

    // Atributos
    private String nombreSala;
    private int capacidad;
    private boolean disponible;

    // Constructor
    public claseSala(String nombreSala, int capacidad, boolean disponible) {
        this.nombreSala = nombreSala;
        this.capacidad = capacidad;
        this.disponible = disponible;
    }

    // Métodos getters y setters
    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Mostrar información
    public void mostrarInfo() {
        System.out.println("Sala: " + nombreSala);
        System.out.println("Capacidad: " + capacidad);
        System.out.println("Disponible: " + (disponible ? "Sí" : "No"));
    }
}

