import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    private SistemaSeleccion sistema;

    // Constructor
    public MainFrame(SistemaSeleccion sistema) {
        this.sistema = sistema;
        sistema.cargarDatos(); 

        setTitle("Sistema de Selección");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Mostrar el menú inicial
        showMainMenu();
    }

    // Métodos
    // Método para mostrar el menú principal
    private void showMainMenu() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton btnPostulantes = new JButton("Postulantes");
        btnPostulantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPostulantesMenu();
            }
        });

        JButton btnPuestos = new JButton("Puestos");
        btnPuestos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPuestosMenu();
            }
        });

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sistema.guardarDatos(); // Guardar datos de puestos y postulantes
                System.exit(0);
            }
        });

        panel.add(btnPostulantes);
        panel.add(btnPuestos);
        panel.add(btnSalir);

        setContentPane(panel);
        revalidate();
        repaint();
    }

    // Método para mostrar el menú de postulantes
    private void showPostulantesMenu() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton btnAgregarPostulante = new JButton("Agregar Postulante");
        btnAgregarPostulante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPostulante();
            }
        });

        JButton btnMostrarPostulantesPorPuesto = new JButton("Mostrar Postulantes por Puesto");
        btnMostrarPostulantesPorPuesto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPostulantesPorPuesto();
            }
        });

        JButton btnMostrarTodosLosPostulantes = new JButton("Mostrar Todos los Postulantes");
        btnMostrarTodosLosPostulantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTodosLosPostulantes();
            }
        });

        JButton btnBuscarPostulantePorId = new JButton("Buscar Postulante por ID");
        btnBuscarPostulantePorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPostulantePorId();
            }
        });

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMainMenu();
            }
        });

        panel.add(btnAgregarPostulante);
        panel.add(btnMostrarPostulantesPorPuesto);
        panel.add(btnMostrarTodosLosPostulantes);
        panel.add(btnBuscarPostulantePorId);
        panel.add(btnVolver);

        setContentPane(panel);
        revalidate();
        repaint();
    }

    // Método para mostrar el menú de puestos
    private void showPuestosMenu() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JButton btnAgregarPuesto = new JButton("Agregar Puesto");
        btnAgregarPuesto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPuesto();
            }
        });

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMainMenu();
            }
        });

        panel.add(btnAgregarPuesto);
        panel.add(btnVolver);

        setContentPane(panel);
        revalidate();
        repaint();
    }

    // Métodos para agregar postulantes y puestos
    private void agregarPostulante() {
        JTextField idField = new JTextField();
        JTextField nombreField = new JTextField();
        JTextField aniosExperienciaField = new JTextField();
        JTextField nivelEducacionField = new JTextField();
        JTextField competenciasField = new JTextField();
        JTextField profesionField = new JTextField(); // Nuevo campo

        Object[] message = {
            "ID:", idField,
            "Nombre:", nombreField,
            "Años de Experiencia:", aniosExperienciaField,
            "Nivel de Educación:", nivelEducacionField,
            "Competencias (separadas por ;):", competenciasField,
            "Profesión:", profesionField // Nuevo campo
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Agregar Postulante", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String id = idField.getText();
                String nombre = nombreField.getText();
                int aniosExperiencia = Integer.parseInt(aniosExperienciaField.getText());
                String nivelEducacion = nivelEducacionField.getText();
                String profesion = profesionField.getText(); // Obtener nuevo campo
                String[] competenciasArray = competenciasField.getText().split(";");
                List<Competencia> competencias = new ArrayList<>();
                for (String competenciaStr : competenciasArray) {
                    String[] comp = competenciaStr.split(":");
                    if (comp.length == 2) {
                        competencias.add(new Competencia(comp[0], comp[1]));
                    }
                }
                Postulante postulante = new Postulante(id, nombre, competencias, aniosExperiencia, nivelEducacion, profesion);
                sistema.agregarPostulante(postulante);
                JOptionPane.showMessageDialog(this, "Postulante agregado exitosamente.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error en el formato de los datos. Por favor, revise los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void agregarPuesto() {
        JTextField idField = new JTextField();
        JTextField nombreField = new JTextField();
        JTextField descripcionField = new JTextField();
        JTextField minAniosExperienciaField = new JTextField();
        JTextField educacionRequeridaField = new JTextField();
        JTextField competenciasField = new JTextField();
        JTextField profesionField = new JTextField(); // Nuevo campo

        Object[] message = {
            "ID:", idField,
            "Nombre:", nombreField,
            "Descripción:", descripcionField,
            "Años Mínimos de Experiencia:", minAniosExperienciaField,
            "Educación Requerida:", educacionRequeridaField,
            "Competencias (separadas por ;):", competenciasField,
            "Profesión:", profesionField // Nuevo campo
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Agregar Puesto", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                int id = Integer.parseInt(idField.getText());
                String nombre = nombreField.getText();
                String descripcion = descripcionField.getText();
                int minAniosExperiencia = Integer.parseInt(minAniosExperienciaField.getText());
                String educacionRequerida = educacionRequeridaField.getText();
                String profesion = profesionField.getText(); // Obtener nuevo campo
                String[] competenciasArray = competenciasField.getText().split(";");
                List<Competencia> competenciasRequeridas = new ArrayList<>();
                for (String competenciaStr : competenciasArray) {
                    String[] comp = competenciaStr.split(":");
                    if (comp.length == 2) {
                        competenciasRequeridas.add(new Competencia(comp[0], comp[1]));
                    }
                }
                RequisitosAdicionales requisitosAdicionales = new RequisitosAdicionales(minAniosExperiencia, educacionRequerida);
                Puesto puesto = new Puesto(id, nombre, descripcion, competenciasRequeridas, requisitosAdicionales, profesion);
                sistema.agregarPuesto(puesto);
                JOptionPane.showMessageDialog(this, "Puesto agregado exitosamente.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error en el formato de los datos. Por favor, revise los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Métodos para mostrar postulantes y puestos
    private void mostrarPostulantesPorPuesto() {
        JTextField idPuestoField = new JTextField();

        Object[] message = {
            "ID del Puesto:", idPuestoField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Mostrar Postulantes por Puesto", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                int idPuesto = Integer.parseInt(idPuestoField.getText());
                Puesto puestoSeleccionado = sistema.buscarPuestoPorId(idPuesto);
                List<Postulante> postulantes = sistema.seleccionarPostulantes(puestoSeleccionado);
                StringBuilder sb = new StringBuilder();
                for (Postulante postulante : postulantes) {
                    sb.append("ID: ").append(postulante.getID()).append(", Nombre: ").append(postulante.getNombre()).append("\n");
                }
                JTextArea textArea = new JTextArea(sb.toString());
                textArea.setEditable(false);
                JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Postulantes para el Puesto " + puestoSeleccionado.getNombre(), JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID del Puesto debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (PuestoNoEncontradoException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void mostrarTodosLosPostulantes() {
        List<Postulante> postulantes = sistema.getPostulantes();
        StringBuilder sb = new StringBuilder();
        for (Postulante postulante : postulantes) {
            sb.append("ID: ").append(postulante.getID()).append(", Nombre: ").append(postulante.getNombre()).append("\n");
        }
        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Todos los Postulantes", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para buscar postulante por ID
    private void buscarPostulantePorId() {
        JTextField idField = new JTextField();

        Object[] message = {
            "ID del Postulante:", idField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Buscar Postulante por ID", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String id = idField.getText();
                Postulante postulante = sistema.buscarPostulantePorId(id);
                StringBuilder sb = new StringBuilder();
                sb.append("ID: ").append(postulante.getID()).append("\n");
                sb.append("Nombre: ").append(postulante.getNombre()).append("\n");
                sb.append("Años de Experiencia: ").append(postulante.getAniosExperiencia()).append("\n");
                sb.append("Nivel de Educación: ").append(postulante.getEducacion()).append("\n");
                sb.append("Competencias: ").append(postulante.getCompetencias()).append("\n");
                sb.append("Profesión: ").append(postulante.getProfesion()).append("\n"); // Mostrar nuevo campo
                JTextArea textArea = new JTextArea(sb.toString());
                textArea.setEditable(false);
                JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Detalles del Postulante", JOptionPane.INFORMATION_MESSAGE);
            } catch (PostulanteNoEncontradoException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Método main
    public static void main(String[] args) {
        SistemaSeleccion sistema = new SistemaSeleccion();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame(sistema).setVisible(true);
            }
        });
    }
}