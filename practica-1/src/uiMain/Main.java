package uiMain;
import gestorAplicacion.paquete1.*;
import gestorAplicacion.paquete2.*;
import baseDatos.Serializador;
import java.util.*;
/**
Paulina Gomez  Hincapie
Daniel Hincapie Cardona
 */

 //DHC - Comentarios pendientes - 478 onwards
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
	
	/* PRIMERA FUNCIONALIDAD
	 * 
	 * permite buscar libros o computadoras disponibles en una sede de la biblioteca y gestionar un préstamo a nombre del usuario.
	 */
	
	private static void pedirComputadorOLibro() {
	    int op1;
	    System.out.println("Comprobando historial de multas... \n");
	    if (! sistema.getUser().getMultas().isEmpty() ) {
	    	System.out.println("Lo lamento, debes pagar tus multas primero para realizar algún prestamo \n");
	    	return ;
	    }
	    else if(sistema.getUser().getPrestamos().size() == Usuario.prestamosMaximos) {
	    		System.out.println("Lo lamento, ya has solicitado el numero máximo de prestamos \n");
	    		return ;
	    }
	    System.out.println("Ingresa el recurso del cual deseas consultar disponibilidad \n");
	    System.out.println("0. Libro \n1. Computador \n2. Volver al menú principal. ");
	    op1 = sc.nextByte();
	    switch (op1) {
	    
	    //CASO LIBRO
	    
        case 0:
            while(true) {
                System.out.println("Ingrese el nombre del libro que desees consultar o ingrese 0 para volver al menú anterior: ");
                sc.nextLine();
                String nombre = sc.nextLine();
                if(nombre.equals("0")) {
                    break;
                }
                Copia copia = null;
                
              //Busca en la base de datos de libros si existe un libro con ese nombre, no importa la sede
                
                boolean encontrado = false;
                boolean disponible = false;
                ArrayList<Biblioteca> sedes = new ArrayList<Biblioteca>(); 
                for (Libro l : sistema.getLibros()) { 
                    if (l.getNombre().equalsIgnoreCase(nombre)) {
                        encontrado = true;
                        System.out.println("Libro encontrado");
                        System.out.println("El libro: " + "'" + nombre + "'" + " Se encuentra disponible en las siguientes sedes: ");
                        for(Biblioteca m : sistema.getBibliotecas()) {
                        	for(Copia o : m.getCopias()) {
                        		if(o.getNombre().equalsIgnoreCase(nombre)){
                        			disponible = true;
                        			
        	                        //Si comprueba que existe ese libro, muestra las sedes que tengan al menos una copia del mismo.
                        			
        	                            if (m.hayCopia(nombre, "Particular")) {
        	    	                		System.out.println(sistema.getBibliotecas().indexOf(m) + ". " + m.getSede());
        	                                sedes.add(m);
        	                            }
        	                        
        	                        break;
                        		}
                        	}
                        }
                    }
                }
                
                
                if(encontrado == false) {
                    System.out.println("Libro no encontrado");
                    continue;
                }
                if(encontrado == true) {
                	if(disponible == true) {

	                	System.out.println("Seleccione el indice de la sede de su preferencia para realizar el prestamo: \n");
	                	byte op = sc.nextByte();
	                	copia = sistema.getBibliotecas().get(op).hallarcopiaPorNombre(nombre);
	                	System.out.println("Ingrese numericamente el dia hasta el cual desea hacer el prestamo: \n");
	                	int dia = sc.nextInt();
	                	System.out.println("Ingrese numericamente el mes hasta el cual desea hacer el prestamo: \n");
	                	int mes = sc.nextInt();
	                	
	                	// Fecha hasta la cual se hace el prestamo.
	                	
	                	Calendar calendar = Calendar.getInstance();
	                	calendar.set(2025, mes - 1, dia); 
	                	Date fecha = calendar.getTime();
	                	
	                	// Fecha actual
	                	
	                	Date fecha2 = new Date();

	                	// Remueve la copia de la base de datos de la sede y realiza el prestamo a nombre del usuario
	                	
	                	//System.out.println(sistema.getBibliotecas().get(op1).getCopias());
	                	Prestamo prestamo = new Prestamo(sistema.getUser(),Prestamo.Tipo.PARTICULAR, fecha2, fecha, copia,sistema.getBibliotecas().get(op1));
	                	sistema.getUser().getPrestamos().add(prestamo);
	                	sistema.getBibliotecas().get(op).remover(copia);
	                	System.out.println("¡El prestamo se ha realizado con exito!");
	                	System.out.println("Por favor regresa tu libro ;)");	                	}
                	else if(disponible == false) {
                		System.out.println("El libro no cuenta con copias en este momento.");
                	}
                }
            }
            break;
            
        //CASO COMPUTADOR
            
        case 1:
            while(true) {
                System.out.println("Ingrese el nombre del computador que desees consultar o ingrese 0 para volver al menú anterior");
                sc.nextLine();
                String nombre = sc.nextLine();
                if(nombre.equals("0")) {
                    break;
                }
                PC pc = null;
                
              //Busca en la base de datos de libros si existe un libro con ese nombre, no importa la sede.
                
                boolean encontradopc = false;
                boolean disponiblepc = false;
                ArrayList<Biblioteca> sedes = new ArrayList<Biblioteca>(); // Move this line outside the loop
                for (Computador l : sistema.getComputadores()) { 
                    if (l.getNombre().equalsIgnoreCase(nombre)) {
                        encontradopc = true;
                        System.out.println("Computador encontrado");
                        System.out.println("El computador: " + "'" + nombre + "'" + " Se encuentra disponible en las siguientes sedes: ");
                        for(Biblioteca m : sistema.getBibliotecas()) {
                        	for(PC o : m.getPCS()) {
                        		if(o.getNombre().equalsIgnoreCase(nombre)){
                        			disponiblepc = true;
                        			
        	                        //Si comprueba que existe ese computador, muestra las sedes que tengan al menos un ejemplar del mismo.
                        			
        	                            if (m.hayPC(nombre, "Particular")) {
        	    	                		System.out.println(sistema.getBibliotecas().indexOf(m) + ". " + m.getSede());
        	                                sedes.add(m);
        	                            }
        	                        
        	                        break;
                        		}
                        	}
                        }
                    }
                }
                
                
                if(encontradopc == false) {
                    System.out.println("Computador no encontrado");
                    continue;
                }
                if(encontradopc == true) {
                	if(disponiblepc == true) {
	                	System.out.println("Seleccione el indice de la sede de su preferencia para realizar el prestamo: ");
	                	byte op = sc.nextByte();
	                	pc = sistema.getBibliotecas().get(op).hallarpcPorNombre(nombre);
	                	// sistema.getBibliotecas().get(op).remover(copia);
	                	System.out.println("Ingrese numericamente el dia hasta el cual desea hacer el prestamo: ");
	                	int dia = sc.nextInt();
	                	System.out.println("Ingrese numericamente el mes hasta el cual desea hacer el prestamo: ");
	                	int mes = sc.nextInt();
	                	
	                	// Fecha hasta la cual se hace el prestamo.
	                	
	                	Calendar calendar = Calendar.getInstance();
	                	calendar.set(2025, mes - 1, dia); // Note: Month value is 0-based in java.util.Calendar.
	                	Date fecha = calendar.getTime();
	                	
	                	// Fecha actual.
	                	
	                	Date fecha2 = new Date();

	                	// Remueve la copia de la base de datos de la sede y realiza el prestamo a nombre del usuario.
	                	
	                	sistema.getBibliotecas().get(op).remover(pc);
	                	Prestamo prestamo = new Prestamo(sistema.getUser(),Prestamo.Tipo.PARTICULAR, fecha2, fecha, pc,sistema.getBibliotecas().get(op1));
	                	sistema.getUser().getPrestamos().add(prestamo);
	                	System.out.println("¡El prestamo se ha realizado con exito!");
	                	System.out.println("Por favor regresa tu computador ;)");
                	}
                	else if(disponiblepc == false) {
                		System.out.println("El computador no cuenta con disponibilidad en este momento.");
                	}
                }
            }
            break;

        case 2:
            System.out.println("Volviendo al menú principal");
            break;
        default:
            System.out.println("Ingrese una opción correcta");
    }
}
     
	/*TERCERA FUNCIONALIDAD 
	 * Gestion base de datos:  encargado de agregar o eliminar recursos de la base de datos general y,
	 *  posteriormente, actualizar las copias correspondientes en cada sede.
	 */
private static void AgregarOEliminar() {
	String nombre;
	Biblioteca sede;
	Byte op;
	Autor autor;
	System.out.println("Seleccione la acción que desee realizar: \n0. Agregar libro\n1. Remover libro\n2. Agregar computador\n3. Remover computador");
	op = sc.nextByte();
	switch(op) {
	
	
	//AGREGAR LIBRO
	
	case 0:
		System.out.println("Para evitar temas de duplicados, por favor ingresa el codigo ISBN del libro que deseas agragar para comprobar que aun no se encuentra en nuestro sistema: ");
		String isbn = sc.nextLine();
		
		//verifica si el libro a agregar ya existe en la base de datos, buscando por codigo isbn.
		
		for (Libro l : sistema.getLibros()) {
			if (l.getIsbn().equalsIgnoreCase(isbn)) {
				System.out.println("El libro ya se encuentra en la base de datos de la biblioteca");
				return;
			}
		}
		
		//si el libro no se encuentra, procede a pedir los datos para el registro.
		
		System.out.println("El libro no se encuentra en la base de datos de la biblioteca");
		System.out.println("Ingrese el nombre del libro a registrar: ");
		nombre = sc.nextLine();
		System.out.println("Ingrese el año de publicacion: ");
		int año = sc.nextInt();
		System.out.println("Seleccione el autor del libro: ");
		for (int i = 0; i < sistema.getAutores().size(); i++) {
			System.out.println((i+1) + ". " + sistema.getAutores().get(i));
		}
		System.out.println("\n0. Crear autor");
		op = sc.nextByte();
		
		if (op == 0) {
			System.out.println("Ingrese el nombre del autor: ");
			String nombreAutor = sc.nextLine();
			System.out.println("Ingrese la nacionalidad del autor: ");
			String nacionalidad = sc.nextLine();
			System.out.println("Ingrese la corriente del autor: ");
			String corriente = sc.nextLine();
			
			autor = new Autor(nombreAutor, nacionalidad, corriente);
			
		}
		else {
			autor = sistema.getAutores().get(op-1);
		}
		//Crea el nuevo libro con la informacion solicitada y agrega las copias.
		
		Libro libroNuevo = new Libro(nombre, sistema.getLibros().size(), isbn, autor, año);
		sistema.getLibros().add(libroNuevo);
		System.out.println("¿A que sede deseas agregar las copias del libro?");
		for (Biblioteca b : sistema.getBibliotecas()) {
			System.out.println(sistema.getBibliotecas().indexOf(b) + ". " + b.getNombre());
		}
		sede = sistema.getBibliotecas().get(sc.nextInt());
		System.out.println("Cuantas copias de este libro deseas agregar");
		int num = sc.nextInt();
		for (int i = 0; i <= num; i++) {
			sede.añadirCopia(new Copia(sede.getCopias().size(), libroNuevo, sede));
		}
		System.out.println("¡Copias añadidas con exito!");

		break;
		
	// ELIMINAR LIBRO
		
	case 1:
		// Despliega lista de libros actuales para consultar cual se desea eliminar.
		
		System.out.println("Seleccione el libro que desea eliminar: ");
		for (Libro l : sistema.getLibros()) {
			System.out.println(sistema.getLibros().indexOf(l) + ". " + l.getNombre());
		}
		// Elimina el libro solicitado de toda base de datos.
		
		Libro aEliminar = sistema.getLibros().get(sc.nextInt());
		for (Prestamo p: sistema.getUser().getPrestamos()) {
			if (p.getCopiasPrestadas() != null && aEliminar.getNombre().equalsIgnoreCase(p.getCopiasPrestadas().get(0).getNombre())) {
				System.out.println("No puedes eliminar este recurso ya que se encuentra en prestamo");
				return ;
			}
		}
		
		for(Biblioteca s : sistema.getBibliotecas()) {
			for(Copia copia : s.getCopias()) {
				if (copia.getNombre().equalsIgnoreCase(aEliminar.getNombre()) && s.getCopias().contains(aEliminar)) {
					s.getCopias().remove(copia);
				}
				
			}
		}
		sistema.getLibros().remove(aEliminar);
		System.out.println("Libro eliminado con exito ");
		break;
		
	// AGREGAR COMPUTADOR
	case 2:
		System.out.println("Para evitar añadir un modelo duplicado, por favor ingrese el nombre del computador: ");
		sc.nextLine();
		nombre = sc.nextLine();
		//verifica si el computador a agregar ya existe en la base de datos, buscando por modelo.
		
		for (Computador c : sistema.getComputadores()) {
			if (c.getNombre().equalsIgnoreCase(nombre)) {
				System.out.println("La biblioteca ya cuenta con este computador");
				return;
			}
		}
		// Si no existe, procede a solicitar informacion del nuevo computador.
		
		System.out.println("Ingrese la marca del computador a registrar: ");
		String marca = sc.nextLine();
		System.out.println("Ingrese la gama del computador a registrar: ");
		String gama = sc.nextLine();
		System.out.println("Seleccione el autor del libro: ");
		
		// Crea la nueva instancia del computador y agrega los pcs a cada sede.
		
		Computador computadorNuevo = new Computador(nombre, sistema.getComputadores().size(), marca, gama);
		sistema.getComputadores().add(computadorNuevo);
		System.out.println("¿A que sede deseas agregar los PCs de este modelo?");
		for (Biblioteca b : sistema.getBibliotecas()) {
			System.out.println(sistema.getBibliotecas().indexOf(b) + ". " + b.getNombre());
		}
		sede = sistema.getBibliotecas().get(sc.nextInt());
		System.out.println("Cuantos PCs de este modelo deseas agregar");
		int num1 = sc.nextInt();
		for (int i = 0; i <= num1; i++) {
			sede.añadirPC(new PC(computadorNuevo, true, sede));
		}
		System.out.println("¡PCs añadidos con exito!");

		break;
		
	// ELIMINAR PC
		
	case 3:
		// Despliega lista de computadores para consultar cual se desea eliminar.
		
		System.out.println("Seleccione la referencia del computador que desea eliminar: ");
		for (Computador c : sistema.getComputadores()) {
			System.out.println(sistema.getComputadores().indexOf(c) + ". " + c.getNombre());
		}
		// Elimina computador de toda base de datos.
		
		Computador aEliminar1 = sistema.getComputadores().get(sc.nextInt());
		for (Prestamo p: sistema.getUser().getPrestamos()) {
			if (p.getPcsPrestados() != null && aEliminar1.getNombre().equalsIgnoreCase(p.getPcsPrestados().get(0).getNombre())) {
				System.out.println("No puedes eliminar este recurso ya que se encuentra en prestamo");
				return ;
			}
		}
		
		for(Biblioteca s : sistema.getBibliotecas()) {
			for(PC pc : s.getPCS()) {
				if (pc.getNombre().equalsIgnoreCase(aEliminar1.getNombre()) && s.getPCS().contains(aEliminar1)) {
					s.getPCS().remove(pc);
				}
				
			}
		}
		sistema.getComputadores().remove(aEliminar1);
		System.out.println("Computador removido con éxito");
		break;
		
	default :
		System.out.println("Opcion incorrecta");
		
	}
	
}
	
	
	/**
	 * Funcionalidad encargada de realizar reservas para un evento, reservando sala y prestando recursos para
	 * su realizacion
	 */
	private static void recursoEvento() {
		Byte op;
		Byte op2 = 0;
		Prestamo prestamo;
		// Despliega lista de sedes para ver en cual se desea realizar el evento
		System.out.println("Seleccione la sede en la cual se requiere hacer la reserva para evento: ");
		for (Biblioteca b : sistema.getBibliotecas()) {
			System.out.println(sistema.getBibliotecas().indexOf(b) + ". " + b.getNombre());
		}
		Biblioteca sede = sistema.getBibliotecas().get(sc.nextByte());
		// Consulta de tipo de evento y seleccion de sala disponible para su realizacion
		System.out.println("Seleccione que tipo de evento desea reservar: ");
		System.out.println("0. Charla\n1. Presentacion\n2. Estudio");
		op = sc.nextByte();
		if (sede.getSalas().isEmpty()) {
			System.out.println("No hay salas disponibles para realizar un evento ");
			return ;
		}
		System.out.println("Seleccione la sala que desea reservar: ");
		for (int i = 0; i < sede.getSalas().size(); i++) {
			System.out.println(i + ". " + sede.getSalas().get(i).getNombre() + " / Con capacidad para: " + sede.getSalas().get(i).getCapacidad() + " personas" );
		}
		// Consulta de material necesitado para la realizacion del evento
		op2 = sc.nextByte();
		Evento evento = new Evento(op, sede, sede.getSalas().get(op2)); 
		System.out.println("¿Que recursos deseas reservar para el evento?");
		System.out.println("0. Libros\n1. Computadores");
		switch(sc.nextByte()) {
		// Caso libro
		case 0:
			// Despliega lista de copias disponibles en esa sede para el evento
			System.out.println("Lista de libros disponibles para reserva de evento: ");
			for (int i = 0; i < sede.listaCopiasUnicas().size(); i++) {
				System.out.println(i + ". " + sede.listaCopiasUnicas().get(i).getNombre());
			}
			// Se selecciona el libro y se genera el prestamo a nombre del usuario
			System.out.println("Por favor seleccione el libro a reservar para evento: ");
			op2 = sc.nextByte();
			Date fecha = new Date();
			prestamo = new Prestamo(sistema.getUser(),Prestamo.Tipo.EVENTO,evento.getSala(),fecha,fecha,sede.listaCopiasUnicas().get(op2), sede);
			sede.getPrestamos().add(prestamo);
			System.out.println("Reserva realizada con exito en sala: " + prestamo.getSala() + " con el siguiente material: ");
			System.out.println(prestamo.getCopiasPrestadas());
			break;
		// Caso computador
		case 1:
			// Despliega lista de pcs disponibles en esa sede para el evento
			System.out.println("Lista de computadores disponibles para evento: ");
			for (int i = 0; i < sede.listaPcsUnicos().size(); i++) {
				System.out.println(i + ". " + sede.listaPcsUnicos().get(i).getNombre());
			}
			// Se selecciona el computador y se genera el prestamo a nombre del usuario
			System.out.println("Por favor seleccione el computador a reservar para evento: ");
			op2 = sc.nextByte();
			fecha = new Date();
			prestamo = new Prestamo(sistema.getUser(),Prestamo.Tipo.EVENTO,evento.getSala(),fecha,fecha,sede.listaPcsUnicos().get(op2), sede);
			sede.getPrestamos().add(prestamo);
			System.out.println("Reserva realizada con exito en sala: " + prestamo.getSala() + " con el siguiente material: ");
			System.out.println(prestamo.getPcsPrestados());
			break;
		default:
			System.out.println("Material incorrecto");
		}
		
		
			
		}
		
	// Método para devolver un préstamo específico
	private static void regresarPrestamo() {
	    // Mostrar los préstamos vigentes para que el usuario elija cuál devolver
		ArrayList<Prestamo> prestamosUsuario = sistema.getUser().getPrestamos();
	    if (prestamosUsuario.isEmpty()) {
	        System.out.println("No tienes préstamos vigentes para devolver.");
	        return;
	    }

	    System.out.println("Selecciona el préstamo que deseas gestionar:");
	    int i = 0;
	    for (Prestamo prestamo : prestamosUsuario) {
	        System.out.println(i+". Tipo: " + prestamo.getTipo().toString() + 
                    ", Fecha de Inicio: " + prestamo.getFechaInicio() + 
                    ", Fecha de Fin: " + prestamo.getFechaFin() +
                    ", Sede: " + prestamo.getSede().getNombre());
	        
            System.out.println("Items Prestados: ");
            if(prestamo.getCopiasPrestadas() != null) {
            	System.out.println("Copia: "+prestamo.getCopiasPrestadas());
            }
            if(prestamo.getPcsPrestados() != null) {
            	System.out.println("PC: "+prestamo.getPcsPrestados());
            }
	        i++;
	    }
	    System.out.println(i + ". Volver al menu principal");

	    int opcion = sc.nextInt();
	    sc.nextLine(); // Consumir la nueva línea después del número
	    
	    if (opcion == i) {
	    	return;
	    }

	    else if (opcion < 0 || opcion > prestamosUsuario.size()) {
	        System.out.println("Opción no válida. Debes seleccionar un número de préstamo válido.");
	        return;
	    }

	    Prestamo prestamoSeleccionado = sistema.getUser().getPrestamos().get(opcion);
	    System.out.println("¿Desea regresar o extender su prestamo? \n0. Regresar \n1. Extender \n2. Volver al menu principal");
	    byte op = sc.nextByte();
	    Date fechaActual = new Date();
	    switch (op) {
	    case 0:
	    	// Realizar las acciones necesarias para marcar las Copias y PC como disponibles nuevamente
		    ArrayList<Copia> copiasPrestadas = prestamoSeleccionado.getCopiasPrestadas();
		    if(copiasPrestadas != null) {
		    	prestamoSeleccionado.getCopiasPrestadas().get(0).getUbicacion().getCopias().add(prestamoSeleccionado.getCopiasPrestadas().get(0));
		    	for (Copia copia : copiasPrestadas) {
			        copia.setDisponibleEvento(true); // Marcar la copia como disponible para eventos
			        copia.setDisponibleParticular(true); // Marcar la copia como disponible para particulares
			    }
		    }

		    ArrayList<PC> pcsPrestados = prestamoSeleccionado.getPcsPrestados();
		    if(pcsPrestados != null) {
		    prestamoSeleccionado.getPcsPrestados().get(0).getSede().getPCS().add(prestamoSeleccionado.getPcsPrestados().get(0));
			    for (PC pc : pcsPrestados) {
			        pc.setDisponibleParticular(true); // Marcar la PC como disponible para particulares
			        pc.setDisponibleEvento(true); // Marcar la copia como disponible para eventos
			    }
		    }

		    // Eliminar el préstamo seleccionado de la lista de préstamos
		    sistema.getUser().getPrestamos().remove(prestamoSeleccionado);

		    // Calcular si el préstamo se ha devuelto antes de la fecha de vencimiento
		    if (fechaActual.before(prestamoSeleccionado.getFechaFin())) {
		        // El préstamo se ha devuelto antes de la fecha de vencimiento, no hay multa
		        System.out.println("¡Préstamo devuelto exitosamente antes de la fecha de vencimiento!");
		    } else {
		        // El préstamo se ha devuelto después de la fecha de vencimiento, generar multa
		        int diasDeRetraso = calcularDiasDeRetraso(fechaActual, prestamoSeleccionado.getFechaFin());
		        double valorMulta = calcularValorMulta(diasDeRetraso);

		        // Crear una nueva multa y agregarla al usuario
		        Multa multa = new Multa("Retraso en la devolución", new Date(), sistema.getUser());
		        numeroMultas++;
		        sistema.getUser().getMultas().add(multa);

		        System.out.println("¡Préstamo devuelto con retraso de " + diasDeRetraso + " días! Se ha generado una multa de $" + valorMulta);
		        
	    }
	    break;
	    case 1:
	    	if (fechaActual.before(prestamoSeleccionado.getFechaFin())) {
	    		System.out.println("Ingrese numericamente el nuevo dia hasta el cual desea extender el prestamo: ");
            	int dia = sc.nextInt();
            	System.out.println("Ingrese numericamente el nuevo mes hasta el cual desea extender el prestamo: ");
            	int mes = sc.nextInt();
            	// Fecha hasta la cual se extiende el prestamo
            	Calendar calendar = Calendar.getInstance();
            	calendar.set(2023, mes - 1, dia); 
            	Date fecha = calendar.getTime();
	    		prestamoSeleccionado.setFechaFin(fecha);
	    		System.out.println("Prestamo extendido con exito ");
	    	} else {
	    		Multa prueba = new Multa("Retraso en la devolución.", new Date(), sistema.getUser());
				sistema.getUser().getMultas().add(prueba);
	    		System.out.println("Lo lamento, tu prestamo ya caducó, no se puede hacer la extension");
	    	}
	    	break;
	    case 2: 
	    	break;
	    default:
	    System.out.println("Opcion no valida");
	    	
	    	
	    }
	}


	// Método para calcular los días de retraso entre dos fechas
	static private int calcularDiasDeRetraso(Date fechaActual, Date fechaVencimiento) {
	    long diferencia = fechaActual.getTime() - fechaVencimiento.getTime();
	    return (int) (diferencia / (1000 * 60 * 60 * 24)); // Milisegundos a días
	}

	// Método para calcular el valor de la multa basado en los días de retraso
	static private double calcularValorMulta(int diasDeRetraso) {
	    // Puedes definir tu propia lógica para calcular el valor de la multa
	    // Por ejemplo, $1 por cada día de retraso
	    return diasDeRetraso * 1.0;
	}

	public static void gestionMultas() {

	    List<Multa> multasPendientes = sistema.getUser().getMultas();
		if(sistema.getUser().getMultas().isEmpty()) {
			Multa prueba = new Multa("Retraso en la devolución.", new Date(), sistema.getUser());
			sistema.getUser().getMultas().add(prueba);
		} else {
	        System.out.println("Multas pendientes:");
	        for (Multa multa : multasPendientes) {
				System.out.println("- ID: "+multa.getIdMulta()+" Tipo: " + multa.getTipo().toString() + ", Fecha: " + multa.getFechaImpuesta());
	        }
		    // Solicita al usuario que ingrese el ID de la multa que desea pagar
		    System.out.print("Ingresa el ID de la multa que deseas pagar: ");
		    int MultaAPagar = sc.nextInt();
		    sc.nextLine(); // Limpia el buffer

		    // Busca la multa en la lista de multas del usuario
		    Multa multaAPagar = null;
		    List<Multa> multasPendientes1 = sistema.getUser().getMultas();
		    for (Multa multa : multasPendientes1) {
		    	if (multa.getIdMulta() == MultaAPagar) {
		            multaAPagar = multa;
		            break;
		        }
		    }

		    if (multaAPagar != null) {
		        String mensajePago = multaAPagar.pagarMulta();
		        System.out.println(mensajePago);
		    } else {
		        System.out.println("Multa no encontrada. Verifica el ID de la multa.");
		        gestionMultas();
		    }
	    }
	}
	
	
	/** 
	 * Metodo para cerrar el programa y serializar los objetos
	 */
	static void salirDelSistema(Sistema sis) {
		System.out.println("Saliendo del sistema");
		Serializador.serializar(sis);
		System.exit(0);
	}
	
	
		
}