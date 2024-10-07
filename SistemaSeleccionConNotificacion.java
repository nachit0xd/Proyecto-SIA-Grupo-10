import javax.swing.JOptionPane;

public class SistemaSeleccionConNotificacion extends SistemaSeleccion {


    public void agregarPostulante(Postulante postulante) {
        super.agregarPostulante(postulante); // Llama al método de la clase padre
        // Simular notificación al administrador
        JOptionPane.showMessageDialog(null, "Nuevo postulante agregado: " + postulante.getNombre(), "Notificación", JOptionPane.INFORMATION_MESSAGE);
    }
}
