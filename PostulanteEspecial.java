public class PostulanteEspecial extends Postulante {

    // Constructor
    public PostulanteEspecial(String id, String nombre, List<Competencia> competencias, int aniosExperiencia, String educacion, String profesion) {
        super(id, nombre, competencias, aniosExperiencia, educacion, profesion);
    }

    // Sobrescritura del método cumpleRequisitos
    public boolean cumpleRequisitos(Puesto puesto) {
        // Sobrescribimos para aplicar algún criterio especial
        if (this.getAniosExperiencia() < puesto.getRequisitosAdicionales().getMinAniosExperiencia()) {
            return false;
        }
        if (!this.getEducacion().equals(puesto.getRequisitosAdicionales().getEducacionRequerida())) {
            return false;
        }
        // Para "PostulanteEspecial", solo se necesita cumplir con la primera competencia
        Competencia primeraCompetencia = puesto.getCompetenciasRequeridas().get(0);
        for (Competencia competencia : this.getCompetencias()) {
            if (competencia.getNombre().equals(primeraCompetencia.getNombre()) &&
                competencia.getNivelRequerido().equals(primeraCompetencia.getNivelRequerido())) {
                return true;
            }
        }
        return false;
    }
}
