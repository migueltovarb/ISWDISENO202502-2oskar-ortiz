package claseTrabajo;

import claseEstudiante.claseEstudiante;

public class claseTrabajo {

    // Atributos
    private String titulo;
    private String descripcion;
    private claseEstudiante autor;

    // Constructor
    public claseTrabajo(String titulo, String descripcion, claseEstudiante autor) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
    }

    // Métodos getters y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public claseEstudiante getAutor() {
        return autor;
    }

    public void setAutor(claseEstudiante autor) {
        this.autor = autor;
    }

    // Mostrar información
    public void mostrarInfo() {
        System.out.println("Título: " + titulo);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Autor: " + autor.getNombre());
    }
}
