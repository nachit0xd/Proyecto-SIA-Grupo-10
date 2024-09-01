public class Competencia{
    private String nombre;
    private String nivelRequerido;

    public Competencia(String nombre, String nivelRequerido){
        this.nombre = nombre;
        this.nivelRequerido = nivelRequerido;
    }

    //Setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setNivelRequerido(String nivelRequerido){
        this.nivelRequerido = nivelRequerido;
    }
       //Getters
    public String getNombre(){
        return this.nombre;
    }  
    public String getNivelRequerido(){
        return this.nivelRequerido;
    }
}