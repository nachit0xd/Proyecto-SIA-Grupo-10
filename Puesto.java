import java.util.List;

public class Puesto{
    private int id;
    private String nombre;
    private String descripcion;
    private List<Competencia> competenciasRequeridas;
    private RequisitosAdicionales requisitosAdicionales;

    //Constructor
    public Puesto(String id, String nombre, String descripcion, List<Competencia> competenciasRequeridas, RequisitosAdicionales requisitosAdicionales){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.competenciasRequeridas = competenciasRequeridas;
        this.requisitosAdicionales = requisitosAdicionales;
    }

    //Setters y getters
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
}