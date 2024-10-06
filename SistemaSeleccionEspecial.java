public class SistemaSeleccionEspecial extends SistemaSeleccion {

    // Sobrescritura del método guardarDatosPostulantes
    public void guardarDatosPostulantes() {
        super.guardarDatosPostulantes(); // Llamada al método original
        
        // Sobrescritura para agregar comportamiento adicional
        System.out.println("Se ha realizado un guardado especial de los postulantes.");
        
    }
}
