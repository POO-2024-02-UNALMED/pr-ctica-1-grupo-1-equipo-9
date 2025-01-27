package gestorAplicacion.paquete1;
import gestorAplicacion.paquete2.Autor;

import java.util.ArrayList;
import java.io.Serializable;


public class Libro extends Recurso implements Serializable {
	private static final long serialVersionUID = 1L;
	static protected int totalLibros;
    protected String isbn;
    protected Autor autor;
    protected int año;

    // Constructor de la clase Libro
    public Libro(String nombre, int idRecurso, String isbn, Autor autor, int año) {
        super(nombre, idRecurso); // Llama al constructor de la clase base (Recurso)
        this.isbn = isbn;
        this.autor = autor;
        this.año = año;
        autor.getObras().add(this);
        totalLibros++;
    }
    
    public Libro() {
    	this("Libro sin nombre", 0, "",new Autor(),0);
    }
    

    // Métodos para obtener el ISBN del libro
    public String getIsbn() {
        return isbn;
    }

    // Métodos para establecer el ISBN del libro
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Métodos para obtener el autor del libro
    public Autor getAutor() {
        return autor;
    }

    // Métodos para establecer el autor del libro
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    // Métodos para obtener el año de publicación del libro
    public int getAño() {
        return año;
    }
    
    public static int getTotalLibros() {
		return totalLibros;
	}

    // Métodos para establecer el año de publicación del libro
    public void setAño(int año) {
        this.año = año;
    }
    
    public String tipoRecurso() {
    	return "Libro";
    }
    
    public String toString() {
    	return this.getNombre();
    }
}

