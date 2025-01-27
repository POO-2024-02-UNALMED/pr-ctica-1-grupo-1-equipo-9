package gestorAplicacion.paquete1;

import java.io.Serializable;

/**
Alejandro Avendano Serna
 */

public class PC extends Computador implements Serializable, Prestable{
	private static final long serialVersionUID = 1L;
    private Computador modelo; // El modelo de computador al que pertenece esta PC
    private boolean disponibleEvento; // Indica si el pc está disponible para eventos
    private boolean disponibleParticular; // Indica si el pc está disponible para préstamos particulares
    private Biblioteca sede; // La sede a la que está asignada esta PC
    

    // Constructor de la clase PC
    public PC(Computador modelo, boolean estado, Biblioteca sede) {
    	super(modelo.getNombre(),modelo.getIdRecurso(),modelo.getMarca(),modelo.getGama());
        this.modelo = modelo;
        this.disponibleEvento = true;
        this.disponibleParticular = true;
        this.sede = sede;
    }

    // Método para obtener el modelo de computador al que pertenece esta PC
    public Computador getModelo() {
        return modelo;
    }

    // Método para establecer el modelo de computador al que pertenece esta PC
    public void setModelo(Computador modelo) {
        this.modelo = modelo;
    }
    
    // Método para mirar si está disponible para evento
    public boolean isDisponibleEvento() {
		return disponibleEvento;
	}
    
    // Método para mirar si está disponible para particular
    public boolean isDisponibleParticular() {
		return disponibleParticular;
	}
    
 // Método cambiar estado para evento
    public void setDisponibleEvento(boolean disponibleEvento) {
		this.disponibleEvento = disponibleEvento;
	}
    
    // Método cambiar estado para particular
    public void setDisponibleParticular(boolean disponibleParticular) {
		this.disponibleParticular = disponibleParticular;
	}

    // Método para obtener la sede a la que está asignada esta PC
    public Biblioteca getSede() {
        return sede;
    }

    // Método para establecer la sede a la que está asignada esta PC
    public void setSede(Biblioteca sede) {
        this.sede = sede;
    }
    
    public boolean isPrestado() {
    	return (!(disponibleEvento && disponibleParticular));
    }
    
    public int getID() {
    	return this.getIdRecurso();
    }
    
    public String tipoRecurso() {
    	return "Pc";
    }
    
}
