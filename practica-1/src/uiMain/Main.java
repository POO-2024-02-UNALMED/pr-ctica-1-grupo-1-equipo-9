package uiMain;
import gestorAplicacion.paquete1.*;
import gestorAplicacion.paquete2.*;
import baseDatos.Serializador;
import java.util.*;
/**
Paulina Gomez  Hincapie
Daniel Hincapie Cardona
 */

public class Main {
	static Scanner sc = new Scanner(System.in);
	static Sistema sistema = new Sistema();
    static int numeroMultas = 0;  // Atributo estático para el número de multas
    
    
	public static void main(String[] args) {
		byte opcion;
		byte op;
		boolean enSesion = false;	
		
		while (enSesion == false) {
			
	        System.out.println("   ***********************************************");
	        System.out.println("  *                                               *");
	        System.out.println(" *                📚Aquí se Lee o se Llora 📚       *");
	        System.out.println("*                                                    *");
	        System.out.println("****************************************************** \n");
	        System.out.println("                ┌─────────────────────┐");
	        System.out.println("                │        LIBRO        │");
	        System.out.println("                │                     │");
	        System.out.println("                │  \"Un libro abierto  │");
	        System.out.println("                │   es un cerebro     │");
	        System.out.println("                │   que habla.\"       │");
	        System.out.println("                │                     │");
	        System.out.println("                │                     │");
	        System.out.println("                │                     │");
	        System.out.println("                └─────────────────────┘ \n ");
	        
			System.out.println("Por favor, seleccione una opción: \n");
			System.out.println("---------------------------------------------------------- \n");
			System.out.println("1. Igrese al sistema: \n");
			
			System.out.println("---------------------------------------------------------- \n");
			System.out.println("Ingrese 1 para continuar \n");
			
			opcion = sc.nextByte();
			sc.nextLine();
			
			
			switch(opcion) {
			case 1:
				enSesion = true;
				System.out.println( "\n");
				System.out.println("Sesion iniciada correctamente \n");
				break;
			default: 
				System.out.println("Por favor, seleccione una opcion correcta \n");
			}
		}	
		
		do {
			System.out.println("Seleccione la opción que desea ejecutar \n");
			System.out.println("---------------------------------------------------------- \n");
			System.out.println("1. Consulta de disponibilidad para prestamo \n ");
			System.out.println("2. Consulta de disponibilidad para reserva de evento \n");
			System.out.println("3. Gestion de base de datos \n");
			System.out.println("4. Gestion de prestamos y reservas \n");
			System.out.println("5. Gestión de Multas \n");
			System.out.println("6. Salir del sistema \n");
			System.out.println("----------------------------------------------------------");
			op = sc.nextByte();
			
			switch(op) {
			case 1:
				pedirComputadorOLibro();
				break;
			case 2:
				recursoEvento();
				break;
			case 3:
				AgregarOEliminar();
				break;
			case 4:
				regresarPrestamo();
				break;
			case 5:
				gestionMultas();				
				break;
			case 6: 
				salirDelSistema(sistema);
				break;
			default:
				System.out.println("Opcion incorrecta, por favor, escoge otra opcion");
			}		
		}
		while (op != 6);
	}