import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

    //Constructor
    public SistemaSeleccion(){
        this.puestos = new ArrayList<Puesto>();
        this.postulantes = new ArrayList<Postulante>();
        this.postulantesPorPuesto = new HashMap<Puesto, List<Postulante>>();
    }

    //Getters
    public List<Puesto> getPuestos() {
        return puestos;
    }

    public List<Postulante> getPostulantes() {
        return postulantes;
    }
    //Sobrecarga de métodos para agregar puestos
    public void agregarPuesto(Puesto puesto){
        puestos.add(puesto);
        postulantesPorPuesto.put(puesto, new ArrayList<Postulante>());
    }
/* 
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
*/
    //Sobrecarga de métodos para agregar postulantes
    public void agregarPostulante(Postulante postulante){
        postulantes.add(postulante);
    }
/* 
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
*/
    //Métodos para seleccionar postulantes
    public List<Postulante> seleccionarPostulantes(Puesto puesto) {
        List<Postulante> seleccionados = new ArrayList<>();
        for (Postulante postulante : postulantes) {
            if (postulante.getProfesion().equalsIgnoreCase(puesto.getProfesion()) &&
                postulante.cumpleRequisitos(puesto)) {
                seleccionados.add(postulante);
            }
        }
        return seleccionados;
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

    //Métodos para mostrar postulantes
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

    //Métodos para filtrar postulantes
    public List<Postulante> filtrarPostulantesPorExperiencia(int aniosExperiencia) {
        List<Postulante> filtrados = new ArrayList<>();
        for (Postulante postulante : postulantes) {
            if (postulante.getAniosExperiencia() >= aniosExperiencia) {
                filtrados.add(postulante);
            }
        }
        return filtrados;
    }

    public List<Postulante> filtrarPostulantesPorNivelEducacion(String nivelEducacion) {
        List<Postulante> filtrados = new ArrayList<>();
        for (Postulante postulante : postulantes) {
            if (postulante.getEducacion().equalsIgnoreCase(nivelEducacion)) {
                filtrados.add(postulante);
            }
        }
        return filtrados;
    }

    //Método para buscar postulante por ID
    public Postulante buscarPostulantePorId(String id) throws PostulanteNoEncontradoException {
        for (Postulante postulante : postulantes) {
            if (postulante.getID().equals(id)) {
                return postulante;
            }
        }
        throw new PostulanteNoEncontradoException("Postulante con ID " + id + " no encontrado.");
    }

    //Método para buscar puesto por ID
    public Puesto buscarPuestoPorId(int puestoId) throws PuestoNoEncontradoException {
        for (Puesto puesto : puestos) {
            if (puesto.getID() == puestoId) { // Comparar valores enteros
                return puesto;
            }
        }
        throw new PuestoNoEncontradoException("Puesto con ID " + puestoId + " no encontrado.");
    }

    //Métodos para editar y eliminar puestos
    public void editarPuesto(int id, String nombre, String descripcion, int minAniosExperiencia, String educacionRequerida, String profesion, List<Competencia> competenciasRequeridas) throws PuestoNoEncontradoException {
        Puesto puesto = buscarPuestoPorId(id);
        puesto.setNombre(nombre);
        puesto.setDescripcion(descripcion);
        puesto.getRequisitosAdicionales().setMinAniosExperiencia(minAniosExperiencia);
        puesto.getRequisitosAdicionales().setEducaciónRequerida(educacionRequerida);
        puesto.setProfesion(profesion);
        puesto.setCompetenciasRequeridas(competenciasRequeridas);
    }

    public void eliminarPuesto(int id) throws PuestoNoEncontradoException {
        Puesto puesto = buscarPuestoPorId(id);
        puestos.remove(puesto);
        postulantes.removeIf(postulante -> postulante.getProfesion().equalsIgnoreCase(puesto.getProfesion()));
    }

    // Método para cargar y guardar datos de puestos y postulantes
    public void cargarDatos() {
        cargarDatosPuestos();
        cargarDatosPostulantes();
    }

    public void guardarDatos() {
        guardarDatosPuestos();
        guardarDatosPostulantes();
    }

    private void cargarDatosPuestos() {
        try (BufferedReader br = new BufferedReader(new FileReader("puestos.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 7) { // Asegúrate de que la longitud sea 7 para incluir el nuevo parámetro
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    String descripcion = datos[2];
                    int numCompetencias = Integer.parseInt(datos[3]);
                    int minAniosExperiencia = Integer.parseInt(datos[4]);
                    String educacionRequerida = datos[5];
                    String profesion = datos[6]; // Este es el nuevo parámetro
                    List<Competencia> competenciasRequeridas = new ArrayList<>(); // Necesitarás cargar las competencias de alguna manera
                    RequisitosAdicionales requisitosAdicionales = new RequisitosAdicionales(minAniosExperiencia, educacionRequerida);

                    Puesto puesto = new Puesto(id, nombre, descripcion, competenciasRequeridas, requisitosAdicionales, profesion);
                    agregarPuesto(puesto);
                } else {
                    System.out.println("Línea con formato incorrecto: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los datos de los puestos: " + e.getMessage());
        }
    }

    private void cargarDatosPostulantes() {
        try (BufferedReader br = new BufferedReader(new FileReader("postulantes.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 6) { // Asegúrate de que la longitud sea 6 para incluir el nuevo parámetro
                    String id = datos[0];
                    String nombre = datos[1];
                    int aniosExperiencia = Integer.parseInt(datos[2]);
                    String nivelEducacion = datos[3];
                    String profesion = datos[4]; // Este es el nuevo parámetro
                    String[] competenciasArray = datos[5].split(";");
                    List<Competencia> competencias = new ArrayList<>();
                    for (String competenciaStr : competenciasArray) {
                        String[] comp = competenciaStr.split(":");
                        if (comp.length == 2) {
                            competencias.add(new Competencia(comp[0], comp[1]));
                        }
                    }
                    Postulante postulante = new Postulante(id, nombre, competencias, aniosExperiencia, nivelEducacion, profesion);
                    agregarPostulante(postulante);
                } else {
                    System.out.println("Línea con formato incorrecto: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los datos de los postulantes: " + e.getMessage());
        }
    }

    private void guardarDatosPuestos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("puestos.csv"))) {
            for (Puesto puesto : puestos) {
                bw.write(puesto.getID() + "," + puesto.getNombre() + "," + puesto.getDescripcion() + "," +
                         puesto.getCompetenciasRequeridas().size() + "," + puesto.getRequisitosAdicionales().getMinAniosExperiencia() + "," +
                         puesto.getRequisitosAdicionales().getEducacionRequerida() + "," + puesto.getProfesion());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los datos de los puestos: " + e.getMessage());
        }
    }

    private void guardarDatosPostulantes() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("postulantes.csv"))) {
            for (Postulante postulante : postulantes) {
                StringBuilder competenciasStr = new StringBuilder();
                for (Competencia competencia : postulante.getCompetencias()) {
                    if (competenciasStr.length() > 0) {
                        competenciasStr.append(";");
                    }
                    competenciasStr.append(competencia.getNombre()).append(":").append(competencia.getNivelRequerido());
                }
                bw.write(postulante.getID() + "," + postulante.getNombre() + "," + postulante.getAniosExperiencia() + "," +
                         postulante.getEducacion() + "," + postulante.getProfesion() + "," + competenciasStr.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los datos de los postulantes: " + e.getMessage());
        }
    }
}
