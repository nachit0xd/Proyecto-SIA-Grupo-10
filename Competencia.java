public class Competencia{
    //Atributos de la clase
    private String nombre;
    private String nivelRequerido;

    //Constructor
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
    //Método toString que retorna el nombre y el nivel requerido de la competencia
    public String toString() {
        return nombre + " (" + nivelRequerido + ")";
    }
}
