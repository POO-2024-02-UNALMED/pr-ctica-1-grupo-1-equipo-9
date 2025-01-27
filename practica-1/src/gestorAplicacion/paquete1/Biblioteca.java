package gestorAplicacion.paquete1;
import gestorAplicacion.paquete2.*;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;
import java.util.*;
import java.util.ArrayList;
import java.io.Serializable;


public class Biblioteca implements Serializable{
	private static final long serialVersionUID = 1L;
    // Atributos de la clase Biblioteca
	static private int totalSedes;
    private String nombre;
    private String sede;
    private ArrayList<Sala> salas;
    private ArrayList<Libro> libros;
    private ArrayList<Copia> copias;
    private ArrayList<Computador> computadores;
    private ArrayList<PC> pcs;
    private ArrayList<Prestamo> prestamos;

    // Constructor de la clase Biblioteca
    public Biblioteca(String nombre, String sede) {
        this.nombre = nombre;
        this.sede = sede;
        this.salas = new ArrayList<>();
        this.libros = new ArrayList<>();
        this.computadores = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.copias = new ArrayList<>();
        this.pcs = new ArrayList<PC>();
        totalSedes++;
    }

    // Métodos para obtener y establecer el nombre de la biblioteca
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos para obtener y establecer la sede de la biblioteca
    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    // Métodos para obtener y establecer la lista de libros de la biblioteca
    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }
    
    // Métodos para obtener y establecer la lista de copias de la biblioteca
    public ArrayList<Copia> getCopias() {
        return copias;
    }

    public void setCopias(ArrayList<Copia> copias) {
        this.copias = copias;
    }

    // Métodos para obtener y establecer la lista de computadores de la biblioteca
    public ArrayList<Computador> getComputadores() {
        return computadores;
    }

    public void setComputadores(ArrayList<Computador> computadores) {
        this.computadores = computadores;
    }
    
    // Métodos para obtener y establecer la lista de pcs de la biblioteca
    public ArrayList<PC> getPCS() {
        return pcs;
    }

    public void setPCS(ArrayList<PC> pcs) {
        this.pcs = pcs;
    }

    // Métodos para obtener y establecer la lista de préstamos de la biblioteca
    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
    
    public void añadirSala(Sala sala) {
    	salas.add(sala);
    }
    public void añadirCopia(Copia copia) {
    	copias.add(copia);
    }
    public void añadirPC(PC pc) {
    	pcs.add(pc);
    }
    public ArrayList<Sala> getSalas() {
		return salas;
	}
    public static int getTotalSedes() {
		return totalSedes;
	}
    
    public static void setTotalSedes(int totalSedes) {
		Biblioteca.totalSedes = totalSedes;
	}

    // Método para verificar si hay una copia disponible para un propósito específico
    public boolean hayCopia(String nombreLibro, String proposito) {
        boolean estado = false;
        for (Copia copia : copias) {
        	// Verificar la disponibilidad según el propósito
        	if (copia.getNombre().equalsIgnoreCase(nombreLibro) && proposito.equals("Evento") && copia.isDisponibleEvento()) {
        		estado=true; // Hay una copia disponible para eventos
        	} else if (copia.getNombre().equalsIgnoreCase(nombreLibro) && proposito.equals("Particular") && copia.isDisponibleParticular()) {
        		estado=true; // Hay una copia disponible para préstamos particulares
        	}
        }
        return estado; // No se encontraron copias disponibles para el propósito específico
    }
    
    // Método para verificar si hay un pc disponible para un propósito específico
    public boolean hayPC(String nombreComputador, String proposito) {
        boolean estado = false;
        for (PC pc : pcs) {
        	// Verificar la disponibilidad según el propósito
        	if (pc.getNombre().equalsIgnoreCase(nombreComputador) && proposito.equals("Evento") && pc.isDisponibleEvento()) {
        		estado=true; // Hay una copia disponible para eventos
        	} else if (pc.getNombre().equalsIgnoreCase(nombreComputador) && proposito.equals("Particular") && pc.isDisponibleParticular()) {
        		estado=true; // Hay una copia disponible para préstamos particulares
        	}
        }
        return estado; // No se encontraron copias disponibles para el propósito específico
    }


	
	// Método para encontrar el estado de una copia por su ID
	//public String encontrar(int idCopia) {
        //for (Prestamo prestamo : prestamos) {
            // Verificar si la copia está en préstamo
            //for (Copia copia : prestamo.getCopiasPrestadas()) {
                //if (copia.getIdCopia() == idCopia) {
                    //return "A préstamo";
                //}
            //}
       //}

        // Si no se encontró en los préstamos, se asume que está en la biblioteca
        //return "En biblioteca";
    //}
	
	public Copia hallarcopiaPorNombre(String nombre) {
		for (Copia c : copias) {
			if (c.getNombre().equalsIgnoreCase(nombre)) {
				return c;
			}

			}

		return null;
		}
	public PC hallarpcPorNombre(String nombre) {
		for (PC p : pcs) {
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				return p;
			}
			
		}
		return null;
	}
	
	// Devuelve una lista con las copias disponibles pero sin repetir la misma copia varias veces
	public List<Copia> listaCopiasUnicas() {
		List<Copia> lista = copias.stream()
                .collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparing(Copia::getNombre))),
                                           ArrayList::new));
		return lista;
	}
	
	// Devuelve una lista con los pcs disponibles pero sin repetir el mismo pc varias veces
	public List<PC> listaPcsUnicos() {
		List<PC> lista = pcs.stream()
                .collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparing(PC::getNombre))),
                                           ArrayList::new));
		return lista;
	}
	
	public void remover(Copia copia) {
		copias.remove(copia);
	}
	
	public void remover(PC pc) {
		pcs.remove(pc);
	}
}
