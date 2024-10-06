public class Persona {
    protected String nombre;
    protected String identificacion;

    // Constructor
    public Persona(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    // Método que será sobrescrito por las clases hijas
    public void mostrarDetalles() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Identificación: " + identificacion);
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
