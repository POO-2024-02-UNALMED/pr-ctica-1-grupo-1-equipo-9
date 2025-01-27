package gestorAplicacion.paquete1;
import java.util.Date;

public interface Prestable {
    int getID();
    boolean isPrestado();
    boolean isDisponibleEvento();
    boolean isDisponibleParticular();
    
}