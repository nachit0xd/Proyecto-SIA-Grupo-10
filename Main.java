import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SistemaSeleccion sistema = new SistemaSeleccion();
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame(sistema);
            frame.setVisible(true);
        });
    }
}