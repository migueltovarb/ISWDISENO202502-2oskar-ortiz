package claseBiblioteca;

import java.util.ArrayList;
import claseSala.claseSala;
import claseEstudiante.claseEstudiante;
import claseTrabajo.claseTrabajo;

public class claseBiblioteca {

    // Atributos
    private String nombre;
    private ArrayList<claseSala> salas;
    private ArrayList<claseEstudiante> estudiantes;
    private ArrayList<claseTrabajo> trabajos;

    // Constructor
    public claseBiblioteca(String nombre) {
        this.nombre = nombre;
        this.salas = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
        this.trabajos = new ArrayList<>();
    }

    // Métodos para agregar elementos
    public void agregarSala(claseSala sala) {
        salas.add(sala);
    }

    public void registrarEstudiante(claseEstudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void registrarTrabajo(claseTrabajo trabajo) {
        trabajos.add(trabajo);
    }

	public void mostrarBiblioteca() {
		// TODO Auto-generated method stub
		
	}
}

