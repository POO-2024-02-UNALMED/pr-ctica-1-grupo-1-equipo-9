package gestorAplicacion.paquete1;
import java.util.*;
import java.io.Serializable;

public class Evento implements Serializable{
	private static final long serialVersionUID = 1L;
	private Biblioteca biblioteca;
	private Sala sala;
	ArrayList<Recurso> material;
	private TipoEvento tipo;
	private static ArrayList<TipoEvento> tipos = new ArrayList<TipoEvento>();
	static {
		tipos.add(TipoEvento.CHARLA);
		tipos.add(TipoEvento.PRESENTACION);
		tipos.add(TipoEvento.ESTUDIO);
	}
	
	enum TipoEvento {
		CHARLA,
		PRESENTACION,
		ESTUDIO,
	}
	
	public Evento(byte tipo, Biblioteca sede, Sala sala) {
		this.tipo = tipos.get(tipo);
		this.biblioteca = sede;
		this.sala = sala;
		material = new ArrayList<Recurso>();
	}
	
	public Biblioteca getBiblioteca() {
		return biblioteca;
	}
	
	public ArrayList<Recurso> getMaterial() {
		return material;
	}
	
	public Sala getSala() {
		return sala;
	}
	public TipoEvento getTipo() {
		return tipo;
	}
	
	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
	
	public void setMaterial(ArrayList<Recurso> material) {
		this.material = material;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}
	public static void setTipos(ArrayList<TipoEvento> tipos) {
		Evento.tipos = tipos;
	}
	
}
