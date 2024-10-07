import javax.swing.JOptionPane;

public class SistemaSeleccionConValidacion extends SistemaSeleccion {

    public void agregarPostulante(Postulante postulante) {
        // Verificar si el postulante ya existe
        for (Postulante p : getPostulantes()) {
            if (p.getID().equals(postulante.getID())) {
                // Mensaje de error, el postulante ya existe
                JOptionPane.showMessageDialog(null, "El postulante con ID " + postulante.getID() + " ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // No se agrega el postulante
            }
        }
        super.agregarPostulante(postulante); // Llama al método de la clase padre
    }
}
