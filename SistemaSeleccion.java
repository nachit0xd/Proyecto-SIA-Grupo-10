import.java.util.ArrayList
import.java.util.List
import.java.util.HashMap
import.java.util.Map

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

    public List<Postulante> seleccionarPostulantes(Puesto puesto){
        return postulantesPorPuesto.getOrDefault(puesto, new ArrayList<>());
    }

    public List<Postulante> seleccionarPostulantesPorCriterio(Puesto puesto, int minAniosExperiencia, String educaciónRequerida){
        List<Postulante> postulantesFiltrados = new ArrayList<>();
        for (Postulante postulante : postulantes){
            if (postulante.getAniosExperiencia() >= minAniosExperiencia && postulante.getEducacion().equals(educaciónRequerida)){
                postulantesFiltrados.add(postulante);
            }
        }
        return postulantesFiltrados;
    }
}