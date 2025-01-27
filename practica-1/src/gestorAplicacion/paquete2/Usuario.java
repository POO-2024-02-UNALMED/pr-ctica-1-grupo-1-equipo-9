package gestorAplicacion.paquete2;
import java.util.*; 
import gestorAplicacion.paquete1.*;

import java.util.ArrayList;
import java.io.Serializable;

public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	public static final int prestamosMaximos = 3;
    private ArrayList<Prestamo> prestamos; // Lista de préstamos realizados por el usuario
    private ArrayList<Multa> multas; // Lista de multas impuestas al usuario

    // Constructor de la clase Usuario
    public Usuario() {
        this.prestamos = new ArrayList<>();
        this.multas = new ArrayList<>();
    }

    // Método para obtener la lista de préstamos realizados por el usuario
    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    // Método para establecer la lista de préstamos realizados por el usuario
    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    // Método para obtener la lista de multas impuestas al usuario
    public ArrayList<Multa> getMultas() {
        return multas;
    }

    // Método para establecer la lista de multas impuestas al usuario
    public void setMultas(ArrayList<Multa> multas) {
        this.multas = multas;
    }

    // Método para eliminar una multa del registro del usuario
    public void eliminarMulta(Multa multa) {
        // Lógica para eliminar una multa del registro del usuario
        multas.remove(multa);
    }
}
