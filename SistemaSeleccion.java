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
        this.puestos = new ArrayList<>();
        this.postulantes = new ArrayList<>();
        this.postulantesPorPuesto = new HashMap<>();
    }

    public void agregarPuesto(Puesto puesto){
        puestos.add(puesto);
        postulantesPorPuesto.put(puesto, new ArrayList<>());
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

        List<Competencia> competencias = new ArrayList<>();
        System.out.println("Ingrese competencia: ");
        String competencia = scanner.nextLine();
        System.out.println("Ingrese nivel de la competencia: ");
        String nivelCompetencia = scanner.nextLine();
        competencias.add(new Competencia(competencia, nivelCompetencia));

        Postulante postulante = new Postulante(id, nombre, competencias, años, educacion);
        agregarPostulante(postulante);
    }

    public List<Postulante> seleccionarPostulantes(Puesto puesto){
        return postulantesPorPuesto.getOrDefault(puesto, new ArrayList<>());
    }

    public List<Postulante> seleccionarPostulantes(Puesto puesto, int minAniosExperiencia, String educaciónRequerida){
        List<Postulante> postulantesFiltrados = new ArrayList<>();
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

    public Puesto buscarPuestoPorId(String puestoId) {
        int puestoIdInt = Integer.parseInt(puestoId); // Convertir puestoId a int
        for (Puesto puesto : puestos) {
            if (puesto.getID() == puestoIdInt) { // Comparar valores enteros
                return puesto;
            }
        }
        return null;
    }
}
