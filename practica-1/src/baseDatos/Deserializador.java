package baseDatos;

import gestorAplicacion.paquete1.*; 
import gestorAplicacion.paquete2.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
*
Paulina Gomez Hincapie 
Daniel Hincapie Cardona
 */

public class Deserializador {
	
	public static void deserializar(Sistema sis) {
		deserializarBibliotecas(sis,new File("src\\baseDatos\\temp\\Bibliotecas.txt"));
    	deserializarLibros(sis,new File("src\\baseDatos\\temp\\Libros.txt"));
    	deserializarComputadores(sis,new File("src\\baseDatos\\temp\\Computadores.txt"));
    	deserializarAutores(sis,new File("src\\baseDatos\\temp\\Autores.txt"));
    	deserializarUsuario(sis, new File("src\\baseDatos\\temp\\Usuario.txt"));
    }
	
	public static void deserializarBibliotecas(Sistema sis, File ruta) {
		try {
			FileInputStream file = new FileInputStream(ruta);
			ObjectInputStream obin = new ObjectInputStream(file);
			sis.setBibliotecas((ArrayList<Biblioteca>) obin.readObject());
			obin.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error en la deserializacion de bibliotecas");
		}
		
		
	}
	
	public static void deserializarLibros(Sistema sis, File ruta) {
		try {
			FileInputStream file = new FileInputStream(ruta);
			ObjectInputStream obin = new ObjectInputStream(file);
			sis.setLibros((ArrayList<Libro>) obin.readObject());
			obin.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error en la deserializacion de libros");
		}
		
}
	
	public static void deserializarComputadores(Sistema sis, File ruta) {
		try {
			FileInputStream file = new FileInputStream(ruta);
			ObjectInputStream obin = new ObjectInputStream(file);
			sis.setComputadores((ArrayList<Computador>) obin.readObject());
			obin.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error en la deserializacion de computadores");
		}
		
}
	
	public static void deserializarAutores(Sistema sis, File ruta) {
		try {
			FileInputStream file = new FileInputStream(ruta);
			ObjectInputStream obin = new ObjectInputStream(file);
			sis.setAutores((ArrayList<Autor>) obin.readObject());
			obin.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error en la deserializacion de autores");
		}
		
		
}
	
	public static void deserializarUsuario(Sistema sis, File ruta) {
		try {
			FileInputStream file = new FileInputStream(ruta);
			ObjectInputStream obin = new ObjectInputStream(file);
			sis.setUser((Usuario) obin.readObject());
			obin.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error en la deserializacion del usuario");
		}
	
	}
	
}
