import java.util.List;

public class Postulante{
    private int id;
    private String nombre;
    private List<Competencia> competencias;
    private int aniosExperiencia;
    private String educacion;

    //Constructor
    public Postulante(int id, String nombre, List<Competencia> competencias, int aniosExperiencia, String educacion){
        this.id = id;
        this.nombre = nombre;
        this.competencias = competencias;
        this.aniosExperiencia = aniosExperiencia;
        this.educacion = educacion;
    }

    //Setters y getters
    public void setID(int id){
        this.id = id;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setCompetencias(List<Competencia> competencias){
        this.competencias = competencias;
    }
    public void setAniosExperiencia(int aniosExperiencia){
        this.aniosExperiencia = aniosExperiencia;
    }
    public void setEducacion(String educacion){
        this.educacion = educacion;
    }
    public int getID(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public List<Competencia> getCompetencias(){
        return competencias;
    }
    public int getAniosExperiencia(){
        return aniosExperiencia;
    }
    public String getEducacion(){
        return educacion;
    }

    //Métodos de la clase
    public boolean cumpleRequisitos(Puesto puesto){
        for (Competencia competenciasRequeridas : puesto.getCompetenciasRequeridas()){
            boolean cumple = false;
            for (Competencia competenciasPostulante : competencias){
                if (competenciaRequerida.getNombre().equals(competenciaPostulante.getNombre()) &&
                    competenciaRequerida.getNivelRequerido().equals(competenciaPostulante.getNivelRequerido())){
                        cumple = true;
                        break;
                    } 
            }
            if (!cumple) return false;
        }

        if (puesto.getRequisitosAdicionales() != null){
            if (puesto.getRequisitosAdicionales().getMinAniosExperiencia() > aniosExperiencia){
                return false;
            }
            if (!puesto.getRequisitosAdicionales().getEducacionRequerida().equals(educacion)) {
                return false;
            }
        }
        return true;
    }
}