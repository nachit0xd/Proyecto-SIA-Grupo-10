import java.util.List;

public class Postulante extends Persona {
    private List<Competencia> competencias;
    private int aniosExperiencia;
    private String educacion;
    private String profesion;

    // Constructor
    public Postulante(String id, String nombre, List<Competencia> competencias, int aniosExperiencia, String educacion, String profesion) {
        super(nombre, id); // Llamar al constructor de la clase padre
        this.competencias = competencias;
        this.aniosExperiencia = aniosExperiencia;
        this.educacion = educacion;
        this.profesion = profesion;
    }

    // Sobrescribir el método mostrarDetalles de la clase padre
    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles(); // Llamar al método de la clase padre
        System.out.println("Años de experiencia: " + aniosExperiencia);
        System.out.println("Educación: " + educacion);
        System.out.println("Profesión: " + profesion);
    }

    // Método para verificar si el postulante cumple con los requisitos de un puesto
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

    // Getters y setters
    public List<Competencia> getCompetencias() {
        return competencias;
    }

    public void setCompetencias(List<Competencia> competencias) {
        this.competencias = competencias;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getEducacion() {
        return educacion;
    }

    public void setEducacion(String educacion) {
        this.educacion = educacion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
}
