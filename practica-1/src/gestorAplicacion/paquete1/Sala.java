package gestorAplicacion.paquete1;
import java.io.Serializable;

public class Sala implements Serializable{
	private static final long serialVersionUID = 1L;
	private Biblioteca biblioteca;
	private String nombre;
	private int capacidad;
	
	public Sala(Biblioteca biblioteca, String nombre, int capacidad) {
		this.biblioteca = biblioteca;
		this.nombre = nombre;
		this.capacidad = capacidad;
	}
	public String getNombre() {
		return nombre;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public Biblioteca getBiblioteca() {
		return biblioteca;
	}
	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String toString() {
		return nombre;
	}