import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SistemaSeleccion{
    private List<Puesto> puestos;
    private List<Postulante> postulantes;
    private Map<Puesto, List<Postulante>> postulantesPorPuesto;

    public SistemaSeleccion(){
        this.puestos = new ArrayList<Puesto>();
        this.postulantes = new ArrayList<Postulante>();
        this.postulantesPorPuesto = new HashMap<Puesto, List<Postulante>>();
    }

    public void agregarPuesto(Puesto puesto){
        puestos.add(puesto);
        postulantesPorPuesto.put(puesto, new ArrayList<Postulante>());
    }

    public void agregarPuesto(Scanner scanner){
        System.out.println("Ingrese el ID del puesto: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el nombre del puesto: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la descripción del puesto: ");
        String descripcion = scanner.nextLine();
        System.out.println("Ingrese el número de competencias requeridas: ");
        int numCompetencias = scanner.nextInt();
        scanner.nextLine();
        List<Competencia> competencias = new ArrayList<Competencia>();
        for (int i = 0; i < numCompetencias; i++){
            System.out.println("Ingrese competencia " + (i + 1) + ": ");
            String competencia = scanner.nextLine();
            System.out.println("Ingrese nivel de la competencia " + (i + 1) + ": ");
            String nivelCompetencia = scanner.nextLine();
            competencias.add(new Competencia(competencia, nivelCompetencia));
        }
        System.out.println("Ingrese el mínimo de años de experiencia requeridos: ");
        int minAniosExperiencia = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el nivel de educación requerido: ");
        String educacionRequerida = scanner.nextLine();
        RequisitosAdicionales requisitosAdicionales = new RequisitosAdicionales(minAniosExperiencia, educacionRequerida);
        Puesto puesto = new Puesto(id, nombre, descripcion, competencias, requisitosAdicionales);
        agregarPuesto(puesto);
    }

    public void agregarPostulante(Postulante postulante){
        postulantes.add(postulante);
        for (Puesto puesto : puestos){
            if (postulante.cumpleRequisitos(puesto)){
                postulantesPorPuesto.get(puesto).add(postulante);
            }
        }
    }

    public void agregarPostulante(Scanner scanner){
        System.out.println("Ingrese el ID del postulante: ");
        String id = scanner.nextLine();
        System.out.println("Ingrese el nombre del postulante: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese años de experiencia del postulante: ");
        int años = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese nivel de educación del postulante: ");
        String educacion = scanner.nextLine();

        List<Competencia> competencias = new ArrayList<Competencia>();
        System.out.println("Ingrese competencia: ");
        String competencia = scanner.nextLine();
        System.out.println("Ingrese nivel de la competencia: ");
        String nivelCompetencia = scanner.nextLine();
        competencias.add(new Competencia(competencia, nivelCompetencia));

        Postulante postulante = new Postulante(id, nombre, competencias, años, educacion);
        agregarPostulante(postulante);
    }

    public List<Postulante> seleccionarPostulantes(Puesto puesto){
        return postulantesPorPuesto.getOrDefault(puesto, new ArrayList<Postulante>());
    }

    public List<Postulante> seleccionarPostulantes(Puesto puesto, int minAniosExperiencia, String educaciónRequerida){
        List<Postulante> postulantesFiltrados = new ArrayList<Postulante>();
        for (Postulante postulante : postulantes){
            if (postulante.getAniosExperiencia() >= minAniosExperiencia && postulante.getEducacion().equals(educaciónRequerida)){
                postulantesFiltrados.add(postulante);
            }
        }
        return postulantesFiltrados;
    }

    public void mostrarPostulantesPorPuesto(Puesto puesto){
        List<Postulante> seleccionados = seleccionarPostulantes(puesto);
        if (seleccionados.isEmpty()) {
            System.out.println("No hay postulantes para el puesto " + puesto.getNombre());
        } else {
            System.out.println("Postulantes para el puesto " + puesto.getNombre() + ":");
            for (Postulante postulante : seleccionados) {
                System.out.println("ID: " + postulante.getID() + ", Nombre: " + postulante.getNombre() +
                        ", Años de experiencia: " + postulante.getAniosExperiencia() +
                        ", Educación: " + postulante.getEducacion());
            }
        }
    }

    public void mostrarTodosLosPostulantes() {
        if (postulantes.isEmpty()) {
            System.out.println("No hay postulantes registrados.");
        } else {
            for (Postulante postulante : postulantes) {
                System.out.println("ID: " + postulante.getID() + ", Nombre: " + postulante.getNombre() +
                        ", Años de experiencia: " + postulante.getAniosExperiencia() +
                        ", Educación: " + postulante.getEducacion());
            }
        }
    }

    public Puesto buscarPuestoPorId(String puestoId) {
        int puestoIdInt = Integer.parseInt(puestoId); // Convertir puestoId a int
        for (Puesto puesto : puestos) {
            if (puesto.getID() == puestoIdInt) { // Comparar valores enteros
                return puesto;
            }
        }
        return null;
    }
    // Métodos para guardar y cargar datos
    public void guardarDatos() {
        try (PrintWriter pw = new PrintWriter(new File("puestos.csv"))) {
            for (Puesto puesto : puestos) {
                pw.println(puesto.getID() + "," + puesto.getNombre() + "," + puesto.getDescripcion() + "," +
                        puesto.getCompetenciasRequeridas().size() + "," + puesto.getRequisitosAdicionales().getMinAniosExperiencia() + "," +
                        puesto.getRequisitosAdicionales().getEducacionRequerida());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public void cargarDatos() {
        try (BufferedReader br = new BufferedReader(new FileReader("puestos.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 6) {
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    String descripcion = datos[2];
                    List<Competencia> competenciasRequeridas = new ArrayList<>(); // Necesitarás cargar las competencias de alguna manera
                    int minAniosExperiencia = Integer.parseInt(datos[4]);
                    String educacionRequerida = datos[5];
                    RequisitosAdicionales requisitosAdicionales = new RequisitosAdicionales(minAniosExperiencia, educacionRequerida);
    
                    Puesto puesto = new Puesto(id, nombre, descripcion, competenciasRequeridas, requisitosAdicionales);
                    puestos.add(puesto);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }
}
