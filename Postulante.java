import java.util.List;

public class Postulante{
    private String id;
    private String nombre;
    private List<Competencia> competencias;
    private int aniosExperiencia;
    private String educacion;

    //Constructor
    public Postulante(String id, String nombre, List<Competencia> competencias, int aniosExperiencia, String educacion){
        this.id = id;
        this.nombre = nombre;
        this.competencias = competencias;
        this.aniosExperiencia = aniosExperiencia;
        this.educacion = educacion;
    }

    //Setters
    public void setID(String id){
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
    //Getters
    public String getID(){
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

     // Métodos de la clase
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
