package es.ieselcanaveral.dam2.aadd.lle;
//Holaa
import java.util.Scanner;

import es.ieselcanaveral.dam2.aadd.lle.dao.IContinenteDAO;
import es.ieselcanaveral.dam2.aadd.lle.dao.IPaisDAO;
import es.ieselcanaverla.dam2.aadd.lle.dao.impl.ContinenteDAOImpl;
import es.ieselcanaverla.dam2.aadd.lle.dao.impl.PaisDAOImpl; 
public class Principal {
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);

       
        GestorConexion gestorConexion = new GestorConexion();

        while (true) {
        	 System.out.println("Introduzca la operación a realizar en la base de datos:");
             System.out.println("1.Consultar Paises Continente SA");
             System.out.println("2. Añadir un nuevo continente 'Antártida'");
             System.out.println("3. Actualizar el nombre de un país con Código 107");
             System.out.println("4. Eliminar el continente con Código '02'");
             System.out.println("5.Consultar paises por 'Sa' de continente Americano");
             System.out.println("6. Salir");

            int opcion = r.nextInt();
            r.nextLine();

            switch (opcion) {
                case 1:
                	  tratamientoOpcion1(); 
                      break;
                case 2:
                	 tratamientoOpcion2();
                    break;
                case 3:
                	 tratamientoOpcion3();
                	 break;
                case 4:
                	 tratamientoOpcion4();
             		break;
                case 5:
               	 tratamientoOpcion5();
            		break;
                case 6:
                    System.out.println("Saliendo del programa.");
                    return;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }



	private static void tratamientoOpcion1() {
		GestorConexion gestorConexion = new GestorConexion(); 
        IPaisDAO paisDAO = new PaisDAOImpl(gestorConexion);
        paisDAO.consultarPaisesContinenteSA();
    }
    
	private static void tratamientoOpcion2() {
	    GestorConexion gestorConexion = new GestorConexion(); 
	    IContinenteDAO continenteDAO = new ContinenteDAOImpl(gestorConexion);
	    continenteDAO.agregarContinenteAntartida();
	}


	private static void tratamientoOpcion3() {
		GestorConexion gestorConexion = new GestorConexion(); 
	    IPaisDAO paisDAO = new PaisDAOImpl(gestorConexion);
	    paisDAO.actualizarNombrePaisConCodigo107();
	}


	private static void tratamientoOpcion4() {
		GestorConexion gestorConexion = new GestorConexion(); 
	    IContinenteDAO continenteDAO = new ContinenteDAOImpl(gestorConexion);
	    continenteDAO.eliminarContinenteConCodigo02();
	}


	private static void tratamientoOpcion5() {
	    GestorConexion gestorConexion = new GestorConexion();
	    IPaisDAO paisDAO = new PaisDAOImpl(gestorConexion);

	    String inicioCapital = "Sa";
	    String codigoContinente = "02"; 
	    paisDAO.consultarPaisesPorCapital(inicioCapital, codigoContinente);
	}


}

