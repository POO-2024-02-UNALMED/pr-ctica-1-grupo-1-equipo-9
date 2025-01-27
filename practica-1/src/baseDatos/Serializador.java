package baseDatos;
import gestorAplicacion.paquete1.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
Paulina Gomez  Hincapie 
Daniel Hincapie Cardona
 */


public class Serializador {
	
	  public static void serializar(Sistema sis) {
	    	serializarBibliotecas(sis,new File("src\\baseDatos\\temp\\Bibliotecas.txt"));
	    	serializarLibros(sis,new File("src\\baseDatos\\temp\\Libros.txt"));
	    	serializarComputadores(sis,new File("src\\baseDatos\\temp\\Computadores.txt"));
	    	serializarAutores(sis,new File("src\\baseDatos\\temp\\Autores.txt"));
	    	serializarUsuario(sis, new File("src\\baseDatos\\temp\\Usuario.txt"));
	    }
	  
	  public static void serializarBibliotecas(Sistema sis, File ruta) {
		  try {
			  FileOutputStream file = new FileOutputStream(ruta);
	          ObjectOutputStream out = new ObjectOutputStream(file);
	          out.writeObject(sis.getBibliotecas());
	          out.close();
	          file.close();
		  } catch (IOException e){
			  System.out.println("Error en la serializacion");
			  
		  }
		  
	  }
	  
	  public static void serializarLibros(Sistema sis, File ruta) {
		  try {
			  FileOutputStream file = new FileOutputStream(ruta);
	          ObjectOutputStream out = new ObjectOutputStream(file);
	          out.writeObject(sis.getLibros());
	          out.close();
	          file.close();
		  } catch (IOException e){
			  System.out.println("Error en la serializacion");
			  
		  }
		  
	  }
	  
	  public static void serializarComputadores(Sistema sis, File ruta) {
		  try {
			  FileOutputStream file = new FileOutputStream(ruta);
	            ObjectOutputStream out = new ObjectOutputStream(file);
	            out.writeObject(sis.getComputadores());
	            out.close();
	            file.close();
		  } catch (IOException e){
			  System.out.println("Error en la serializacion");
			  
		  }
		  
	  }
	  
	  public static void serializarAutores(Sistema sis, File ruta) {
		  try {
			  FileOutputStream file = new FileOutputStream(ruta);
	            ObjectOutputStream out = new ObjectOutputStream(file);
	            out.writeObject(sis.getAutores());
	            out.close();
	            file.close();
		  } catch (IOException e){
			  System.out.println("Error en la serializacion");
			  
		  }
		  
	  }
	  
	  public static void serializarUsuario(Sistema sis, File ruta) {
		  try {
			  FileOutputStream file = new FileOutputStream(ruta);
	            ObjectOutputStream out = new ObjectOutputStream(file);
	            out.writeObject(sis.getUser());
	            out.close();
	            file.close();
		  } catch (IOException e){
			  System.out.println("Error en la serializacion");
			  
		  }
	  }
	  
	  
}
