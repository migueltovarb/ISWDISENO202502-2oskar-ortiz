package claseMain;

import claseBiblioteca.claseBiblioteca;
import claseSala.claseSala;
import claseEstudiante.claseEstudiante;
import claseTrabajo.claseTrabajo;

public class claseMain {

    public static void main(String[] args) {

        // Crear biblioteca
        claseBiblioteca biblioteca = new claseBiblioteca("Biblioteca Central");

        // Crear estudiantes
        claseEstudiante e1 = new claseEstudiante("Oskar Ortiz", "20231234", "Ingeniería de Software");
        claseEstudiante e2 = new claseEstudiante("Laura Gómez", "20235678", "Administración");

        // Crear salas
        claseSala s1 = new claseSala("Sala de estudio 1", 10, true);
        claseSala s2 = new claseSala("Sala multimedia", 5, false);

        // Crear trabajos
        claseTrabajo t1 = new claseTrabajo("Sistema de reservas", "Proyecto final en Java", e1);
        claseTrabajo t2 = new claseTrabajo("Gestión de datos", "Trabajo sobre bases de datos", e2);

        // Agregar todo a la biblioteca
        biblioteca.agregarSala(s1);
        biblioteca.agregarSala(s2);
        biblioteca.registrarEstudiante(e1);
        biblioteca.registrarEstudiante(e2);
        biblioteca.registrarTrabajo(t1);
        biblioteca.registrarTrabajo(t2);

        // Mostrar toda la información
        biblioteca.mostrarBiblioteca();
    }
}
