import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaSeleccion sistema = new SistemaSeleccion();
        sistema.cargarDatos();

         // Datos iniciales de postulantes
        Postulante postulante1 = new Postulante("001", "Carlos Pérez", List.of(
            new Competencia("Java", "Avanzado"),
            new Competencia("Bases de Datos", "Intermedio")
        ), 4, "Licenciatura");

        Postulante postulante2 = new Postulante("002", "Ana García", List.of(
            new Competencia("SQL", "Avanzado"),
            new Competencia("Python", "Intermedio")
        ), 3, "Grado Universitario");

        int opcion;
        do {
            System.out.println("\n--- Menú del Sistema de Selección ---");
            System.out.println("1. Insertar o agregar postulante");
            System.out.println("2. Mostrar postulantes por puesto");
            System.out.println("3. Mostrar todos los postulantes");
            System.out.println("4. Agregar puesto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    //sistema.agregarPostulantePorMenú(scanner);
                    sistema.agregarPostulante(scanner);
                    break;
                case 2:
                    System.out.println("Ingrese el ID del puesto: ");
                    String puestoId = scanner.nextLine();
                    Puesto puesto = sistema.buscarPuestoPorId(puestoId);  // Implementa la función para buscar puesto
                    if (puesto != null) {
                        sistema.mostrarPostulantesPorPuesto(puesto);
                    } else {
                        System.out.println("Puesto no encontrado.");
                    }
                    break;
                case 3:
                    sistema.mostrarTodosLosPostulantes();
                    break;
                case 4:
                    sistema.agregarPuesto(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    sistema.guardarDatos();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}

