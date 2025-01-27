package gestorAplicacion.paquete2;

import java.util.ArrayList;
import gestorAplicacion.paquete1.Libro;
import java.io.Serializable;


/**
Paulina Gomez  Hincapie 
 */

public class Autor implements Serializable{
	private static final long serialVersionUID = 1L;
    private String nombre; // Nombre del autor
    private String nacionalidad; // Nacionalidad del autor
    private String corriente; // Corriente literaria del autor
    private ArrayList<Libro> obras; // Array de obras escritas por el autor

    // Constructor de la clase Autor
    public Autor(String nombre, String nacionalidad, String corriente) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.corriente = corriente;
        this.obras = new ArrayList<>();
    }
    
   
    
    public Autor() {
    	this("Autor anonimo", "Desconocido", "Desconocido");
    }

    // Método para obtener el nombre del autor
    public String getNombre() {
        return nombre;
    }

    // Método para establecer el nombre del autor
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para obtener la nacionalidad del autor
    public String getNacionalidad() {
        return nacionalidad;
    }

    // Método para establecer la nacionalidad del autor
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    // Método para obtener la corriente literaria del autor
    public String getCorriente() {
        return corriente;
    }

    // Método para establecer la corriente literaria del autor
    public void setCorriente(String corriente) {
        this.corriente = corriente;
    }

    // Método para obtener la lista de obras escritas por el autor
    public ArrayList<Libro> getObras() {
        return obras;
    }

    // Método para establecer la lista de obras escritas por el autor
    public void setObras(ArrayList<Libro> obras) {
        this.obras = obras;
    }
    public String toString() {
    	return nombre;
    }
}