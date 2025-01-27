package gestorAplicacion.paquete1;

import java.io.Serializable;

/**
Valentina Sierra Durango
 */

public class Copia extends Libro implements Serializable, Prestable{
	private static final long serialVersionUID = 1L;
    private int idCopia; // Identificador único de la copia
    private Libro copiaDe; // El libro del que es una copia
    private boolean disponibleEvento; // Indica si la copia está disponible para eventos
    private boolean disponibleParticular; // Indica si la copia está disponible para préstamos particulares
    private Biblioteca ubicacion; // La sede a la que está asignada esta copia

    // Constructor de la clase Copia
    public Copia(int idCopia, Libro libro, Biblioteca ubicacion) {
    	super(libro.getNombre(),1,libro.getIsbn(), libro.getAutor(),libro.getAño());
        this.idCopia = idCopia;
        this.disponibleEvento = true; // Por defecto, disponible para eventos
        this.disponibleParticular = true; // Por defecto, disponible para préstamos particulares
        this.ubicacion = ubicacion;
   	
    }
    
    // Método para obtener el identificador único de la copia
    public int getID() {
        return idCopia;
    }

    // Método para obtener el libro del que es una copia
    public Libro getCopiaDe() {
        return copiaDe;
    }

    // Método para verificar si la copia está disponible para eventos
    public boolean isDisponibleEvento() {
        return disponibleEvento;
    }

    // Método para establecer la disponibilidad de la copia para eventos
    public void setDisponibleEvento(boolean disponibleEvento) {
        this.disponibleEvento = disponibleEvento;
    }

    // Método para verificar si la copia está disponible para préstamos particulares
    public boolean isDisponibleParticular() {
        return disponibleParticular;
    }

    // Método para establecer la disponibilidad de la copia para préstamos particulares
    public void setDisponibleParticular(boolean disponibleParticular) {
        this.disponibleParticular = disponibleParticular;
    }

    // Método para obtener la sede a la que está asignada esta copia
    public Biblioteca getUbicacion() {
        return ubicacion;
    }

    // Método para establecer la sede a la que está asignada esta copia
    public void setUbicacion(Biblioteca ubicacion) {
        this.ubicacion = ubicacion;
    }
    public boolean isPrestado() {
    	return (!(disponibleEvento && disponibleParticular));
    }
    
    public String toString() {
    	return this.getNombre();
    }
    
    public String tipoRecurso() {
    	return "Copia";
    }
}
