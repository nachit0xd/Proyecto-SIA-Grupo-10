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
        for (Competencia competenciaRequerida : puesto.getCompetenciasRequeridas()) {
            boolean cumple = false;
            for (Competencia competenciaPostulante : competencias) {
                if (competenciaRequerida.getNombre().equals(competenciaPostulante.getNombre()) &&
                    competenciaRequerida.getNivelRequerido().equals(competenciaPostulante.getNivelRequerido())) {
                    cumple = true;
                    break;
                }
            }
            if (!cumple) return false;
        }
        return true;
    }
     public boolean cumpleRequisitos(List<Competencia> competenciasRequeridas, int minAniosExperiencia, String educacionRequerida) {
    // Verificar las competencias requeridas
        for (Competencia competenciaRequerida : competenciasRequeridas) {
            boolean cumple = false;
            for (Competencia competenciaPostulante : competencias) {
                if (competenciaRequerida.getNombre().equals(competenciaPostulante.getNombre()) &&
                    competenciaRequerida.getNivelRequerido().equals(competenciaPostulante.getNivelRequerido())) {
                    cumple = true;
                    break;
                }
            }
            if (!cumple) return false;
        }

        // Verificar experiencia mínima
        if (aniosExperiencia < minAniosExperiencia) {
            return false;
        }

        // Verificar nivel de educación
        if (!educacion.equals(educacionRequerida)) {
            return false;
        }

        return true;
    }
}
