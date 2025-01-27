package gestorAplicacion.paquete2;

import java.util.Date;
import java.io.Serializable;

/**
Paulina Gomez  Hincapie 
 */


public class Multa implements Serializable{
	private static final long serialVersionUID = 1L;
    private int idMulta; // Identificador único de la multa
    private String tipo; // Tipo de la multa (por ejemplo, "Retraso en la devolución")
    private Date fechaImpuesta; // Fecha en la que se impuso la multa
    private Usuario usuario; // Usuario al que se impuso la multa
    private static int numeroMultas;

    // Constructor de la clase Multa
    public Multa(String tipo, Date fechaImpuesta, Usuario usuario) {
        this.idMulta = numeroMultas;
        this.tipo = tipo;
        this.fechaImpuesta = fechaImpuesta;
        this.usuario = usuario;
        setNumeroMultas(getNumeroMultas() + 1);
    }

    // Método para obtener el identificador único de la multa
    public int getIdMulta() {
        return idMulta;
    }

    // Método para obtener el tipo de la multa
    public String getTipo() {
        return tipo;
    }

    // Método para establecer el tipo de la multa
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Método para obtener la fecha en la que se impuso la multa
    public Date getFechaImpuesta() {
        return fechaImpuesta;
    }

    // Método para obtener el usuario al que se impuso la multa
    public Usuario getUsuario() {
        return usuario;
    }

    // Método para pagar la multa
    public String pagarMulta() {
        // Eliminar la multa del registro del usuario
        usuario.eliminarMulta(this);
        // Notificar al usuario sobre el pago exitoso de la multa
        return("La multa de ID: "+idMulta+" con tipo '" + tipo + "' y Fecha " + fechaImpuesta + " ha sido pagada.");
    }

	public static int getNumeroMultas() {
		return numeroMultas;
	}

	public static void setNumeroMultas(int numeroMultas) {
		Multa.numeroMultas = numeroMultas;
	}

}