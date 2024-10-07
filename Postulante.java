import java.util.List;

public class Postulante{
    //Atributos de la clase
    private int id;
    private String nombre;
    private List<Competencia> competencias;
    private int aniosExperiencia;
    private String educacion;
    private String profesion;

    //Constructor
    public Postulante(int id, String nombre, List<Competencia> competencias, int aniosExperiencia, String educacion, String profesion){
        this.id = id;
        this.nombre = nombre;
        this.competencias = competencias;
        this.aniosExperiencia = aniosExperiencia;
        this.educacion = educacion;
        this.profesion = profesion;
    }

    //Setters
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
    public void setProfesion(String profesion){
        this.profesion = profesion;
    }
    //Getters
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
    public String getProfesion(){
        return profesion;
    }
     // Métodos de la clase
     // Método que retorna true si el postulante cumple con los requisitos del puesto
     public boolean cumpleRequisitos(Puesto puesto) {
        if (this.aniosExperiencia < puesto.getRequisitosAdicionales().getMinAniosExperiencia()) {
            return false;
        }
        if (!this.educacion.equals(puesto.getRequisitosAdicionales().getEducacionRequerida())) {
            return false;
        }
        for (Competencia competenciaRequerida : puesto.getCompetenciasRequeridas()) {
            boolean cumple = false;
            for (Competencia competencia : this.competencias) {
                if (competencia.getNombre().equals(competenciaRequerida.getNombre()) &&
                    competencia.getNivelRequerido().equals(competenciaRequerida.getNivelRequerido())) {
                    cumple = true;
                    break;
                }
            }
            if (!cumple) {
                return false;
            }
        }
        return true;
    }
}
