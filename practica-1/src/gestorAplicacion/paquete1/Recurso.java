package gestorAplicacion.paquete1;

import gestorAplicacion.paquete2.*;
import java.io.Serializable;

/**
Alejandro Avendano Serna
 */

public abstract class Recurso implements Serializable{
	private static final long serialVersionUID = 1L;
    private String nombre;
    private int idRecurso;
    public abstract String getDescripcion();

    // Constructor de la clase Recurso
    public Recurso(String nombre, int idRecurso) {
        this.nombre = nombre;
        this.idRecurso = idRecurso;
    }

    // Métodos para obtener el nombre del recurso
    public String getNombre() {
        return nombre;
    }

    // Métodos para establecer el nombre del recurso
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos para obtener el ID del recurso
    public int getIdRecurso() {
        return idRecurso;
    }

    // Métodos para establecer el ID del recurso
    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }
    
    public String tipoRecurso() {
    	return "Recurso";
    }
    
    public String toString() {
    	return nombre;
    }
}

