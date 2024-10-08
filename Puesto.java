import java.util.List;

public class Puesto{
    //Atributos de la clase
    private int id;
    private String nombre;
    private String descripcion;
    private List<Competencia> competenciasRequeridas;
    private RequisitosAdicionales requisitosAdicionales;
    private String profesion;

    //Constructor
    public Puesto(int id, String nombre, String descripcion, List<Competencia> competenciasRequeridas, RequisitosAdicionales requisitosAdicionales, String profesion){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.competenciasRequeridas = competenciasRequeridas;
        this.requisitosAdicionales = requisitosAdicionales;
        this.profesion = profesion;
    }

    //Setters
    public void setID(int id){
        this.id = id;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public void setCompetenciasRequeridas(List<Competencia> competenciasRequeridas){
        this.competenciasRequeridas = competenciasRequeridas;
    }
    public void setRequisitosAdicionales(RequisitosAdicionales requisitosAdicionales){
        this.requisitosAdicionales = requisitosAdicionales;
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
    public String getDescripcion(){
        return descripcion;
    }
    public List<Competencia> getCompetenciasRequeridas(){
        return competenciasRequeridas;
    }
    public RequisitosAdicionales getRequisitosAdicionales(){
        return requisitosAdicionales;
    }
    public String getProfesion(){
        return profesion;
    }
}