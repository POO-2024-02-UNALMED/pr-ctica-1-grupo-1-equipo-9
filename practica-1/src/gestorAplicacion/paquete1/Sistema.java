package gestorAplicacion.paquete1;

import gestorAplicacion.*; 
import gestorAplicacion.paquete2.Autor;
import gestorAplicacion.paquete2.Usuario;
import baseDatos.*;
import java.util.ArrayList;
import java.io.Serializable;


public class Sistema implements Serializable {
	private static final long serialVersionUID = 1L;
	private Usuario user;
	private ArrayList<Biblioteca> bibliotecas = new ArrayList<>();
	private ArrayList<Libro> libros = new ArrayList<Libro>();	
	private ArrayList<Computador> computadores = new ArrayList<Computador>();
	private ArrayList<Autor> autores = new ArrayList<Autor>();

	public Sistema() {
		Deserializador.deserializar(this);
	}
	
	public ArrayList<Biblioteca> getBibliotecas() {
		return bibliotecas;
	}
	
	public ArrayList<Autor> getAutores() {
		return autores;
	}
	public ArrayList<Computador> getComputadores() {
		return computadores;
	}
	public ArrayList<Libro> getLibros() {
		return libros;
	}
	
	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
	}
	
	public void setBibliotecas(ArrayList<Biblioteca> bibliotecas) {
		this.bibliotecas = bibliotecas;
	}
	public void setComputadores(ArrayList<Computador> computadores) {
		this.computadores = computadores;
	}
	
	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}
	
	public Usuario getUser() {
		return user;
	}
	
	public void setUser(Usuario user) {
		this.user = user;
	}
	
	
}
