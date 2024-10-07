import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// Clase MainFrame (no confundir con la clase Main, aquí se crea la interfaz gráfica)
public class MainFrame extends JFrame {
    private SistemaSeleccion sistema;

    // Constructor
    public MainFrame(SistemaSeleccion sistema) {
        this.sistema = sistema;
        // Cargar datos guardados
        sistema.cargarDatos();

        // Configuración de la ventana
        setTitle("Sistema de Selección");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Mostrar el menú inicial
        showMainMenu();
    }

    // Métodos
    // Método para mostrar el menú principal
    private void showMainMenu() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        //Botones
        //Botón para mostrar el menú de postulantes
        JButton btnPostulantes = new JButton("Postulantes");
        btnPostulantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPostulantesMenu();
            }
        });

        //Botón para mostrar el menú de puestos
        JButton btnPuestos = new JButton("Puestos");
        btnPuestos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPuestosMenu();
            }
        });

        //Botón para generar un reporte de puestos y postulantes
        JButton btnGenerarReporte = new JButton("Generar Reporte");
        btnGenerarReporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarReporte();
            }
        });

        //Botón para salir del programa
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
        panel.add(btnGenerarReporte);
        panel.add(btnSalir);

        setContentPane(panel);
        revalidate();
        repaint();
    }

    // Método para mostrar el menú de postulantes
    private void showPostulantesMenu() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        //Botones
        //Botón para agregar un postulante nuevo
        JButton btnAgregarPostulante = new JButton("Agregar Postulante");
        btnAgregarPostulante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPostulante();
            }
        });

        //Botón para mostrar postulantes por puesto según el ID del puesto
        JButton btnMostrarPostulantesPorPuesto = new JButton("Mostrar Postulantes por Puesto");
        btnMostrarPostulantesPorPuesto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPostulantesPorPuesto();
            }
        });

        //Botón para mostrar todos los postulantes ingresados hasta el momento
        JButton btnMostrarTodosLosPostulantes = new JButton("Mostrar Todos los Postulantes");
        btnMostrarTodosLosPostulantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTodosLosPostulantes();
            }
        });

        //Botón para buscar un postulante por ID
        JButton btnBuscarPostulantePorId = new JButton("Buscar Postulante por ID");
        btnBuscarPostulantePorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPostulantePorId();
            }
        });

        //Botón para buscar postulantes por mínimo de años de experiencia
        JButton btnBuscarPostulantesPorExperiencia = new JButton("Buscar Postulantes por Mínimo de experiencia");
        btnBuscarPostulantesPorExperiencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPostulantesPorExperiencia();
            }
        });

        //Botón para buscar postulantes por nivel de educación
        JButton btnBuscarPostulantesPorEducacion = new JButton("Buscar Postulantes por Nivel de Educación");
        btnBuscarPostulantesPorEducacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPostulantesPorEducacion();
            }
        });

        //Botón para volver al menú principal
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
        panel.add(btnBuscarPostulantesPorExperiencia);
        panel.add(btnBuscarPostulantesPorEducacion);
        panel.add(btnVolver);

        setContentPane(panel);
        revalidate();
        repaint();
    }

    // Método para mostrar el menú de puestos
    private void showPuestosMenu() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
    
        //Botones
        //Botón para agregar un puesto nuevo
        JButton btnAgregarPuesto = new JButton("Agregar Puesto");
        btnAgregarPuesto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPuesto();
            }
        });
    
        //Botón para editar un puesto existente
        JButton btnEditarPuesto = new JButton("Editar Puesto");
        btnEditarPuesto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarPuesto();
            }
        });
    
        //Botón para eliminar un puesto existente
        JButton btnEliminarPuesto = new JButton("Eliminar Puesto");
        btnEliminarPuesto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarPuesto();
            }
        });
    
        //Botón para volver al menú principal
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMainMenu();
            }
        });
    
        panel.add(btnAgregarPuesto);
        panel.add(btnEditarPuesto);
        panel.add(btnEliminarPuesto);
        panel.add(btnVolver);
    
        setContentPane(panel);
        revalidate();
        repaint();
    }

    // Métodos para agregar postulantes y puestos
    private void agregarPostulante() {
        // Campos para ingresar los datos del postulante
        JTextField idField = new JTextField();
        JTextField nombreField = new JTextField();
        JTextField aniosExperienciaField = new JTextField();
        JTextField nivelEducacionField = new JTextField();
        JTextField competenciasField = new JTextField();
        JTextField profesionField = new JTextField();

        Object[] message = {
            "ID:", idField,
            "Nombre:", nombreField,
            "Años de Experiencia:", aniosExperienciaField,
            "Nivel de Educación:", nivelEducacionField,
            "Competencias (formato: nombre:nivel;nombre:nivel):", competenciasField,
            "Profesión:", profesionField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Agregar Postulante", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                 // Validaciones
                 if (idField.getText().trim().isEmpty() || nombreField.getText().trim().isEmpty() || profesionField.getText().trim().isEmpty() || competenciasField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos requeridos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Obtener los datos ingresados por el usuario   
                int id = Integer.parseInt(idField.getText().trim());
                String nombre = nombreField.getText().trim();
                int aniosExperiencia = Integer.parseInt(aniosExperienciaField.getText().trim());
                String nivelEducacion = nivelEducacionField.getText().trim();
                String profesion = profesionField.getText().trim();
                String[] competenciasArray = competenciasField.getText().split(";");


                // Verifica si el ID ya existe
                for (Postulante postulante : sistema.getPostulantes()) {
                    if (postulante.getID() == id) {
                        JOptionPane.showMessageDialog(this, "Ya existe un postulante con el ID ingresado.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                // Crear la lista de competencias
                List<Competencia> competencias = new ArrayList<>();
                for (String competenciaStr : competenciasArray) {
                    String[] comp = competenciaStr.split(":");
                    if (comp.length == 2) {
                        competencias.add(new Competencia(comp[0], comp[1]));
                    } else {
                        JOptionPane.showMessageDialog(this, "Formato de competencia inválido. Use el formato nombre:nivel.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                // Crear el postulante y agregarlo al sistema
                Postulante postulante = new Postulante(id, nombre, competencias, aniosExperiencia, nivelEducacion, profesion);
                sistema.agregarPostulante(postulante);
                JOptionPane.showMessageDialog(this, "Postulante agregado exitosamente.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Años de experiencia debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void agregarPuesto() {
        // Campos para ingresar los datos del puesto
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
                // Obtener los datos ingresados por el usuario 
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
                // Obtener el ID ingresado por el usuario
                int id = Integer.parseInt(idField.getText());
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

    // Métodos para buscar postulantes por experiencia y educación
    private void buscarPostulantesPorExperiencia() {
        JTextField aniosExperienciaField = new JTextField();

        Object[] message = {
            "Min. Años de Experiencia:", aniosExperienciaField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Buscar Postulantes por Minimo de experiencia", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                // Obtener los años de experiencia ingresados por el usuario
                int aniosExperiencia = Integer.parseInt(aniosExperienciaField.getText());
                // Filtrar los postulantes por años de experiencia
                List<Postulante> postulantes = sistema.filtrarPostulantesPorExperiencia(aniosExperiencia);
                StringBuilder sb = new StringBuilder();
                for (Postulante postulante : postulantes) {
                    sb.append("ID: ").append(postulante.getID()).append(", Nombre: ").append(postulante.getNombre()).append(", Años de Experiencia: ").append(postulante.getAniosExperiencia()).append("\n");
                }
                JTextArea textArea = new JTextArea(sb.toString());
                textArea.setEditable(false);
                JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Postulantes con " + aniosExperiencia + " años de experiencia", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void buscarPostulantesPorEducacion() {
        JTextField nivelEducacionField = new JTextField();

        Object[] message = {
            "Nivel de Educación:", nivelEducacionField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Buscar Postulantes por Nivel de Educación", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String nivelEducacion = nivelEducacionField.getText();
            List<Postulante> postulantes = sistema.filtrarPostulantesPorNivelEducacion(nivelEducacion);
            StringBuilder sb = new StringBuilder();
            for (Postulante postulante : postulantes) {
                sb.append("ID: ").append(postulante.getID()).append(", Nombre: ").append(postulante.getNombre()).append(", Nivel de Educación: ").append(postulante.getEducacion()).append("\n");
            }
            JTextArea textArea = new JTextArea(sb.toString());
            textArea.setEditable(false);
            JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Postulantes con nivel de educación: " + nivelEducacion, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Método para editar un puesto
    private void editarPuesto() {
        JTextField idField = new JTextField();

        Object[] message = {
         "ID del Puesto a Editar:", idField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Editar Puesto", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                // Obtener el ID ingresado por el usuario
                int id = Integer.parseInt(idField.getText());
                Puesto puesto = sistema.buscarPuestoPorId(id);

                JTextField nombreField = new JTextField(puesto.getNombre());
                JTextField descripcionField = new JTextField(puesto.getDescripcion());
                JTextField minAniosExperienciaField = new JTextField(String.valueOf(puesto.getRequisitosAdicionales().getMinAniosExperiencia()));
                JTextField educacionRequeridaField = new JTextField(puesto.getRequisitosAdicionales().getEducacionRequerida());
                JTextField competenciasField = new JTextField(); // Necesitarás convertir las competencias a String
                JTextField profesionField = new JTextField(puesto.getProfesion());

                Object[] editMessage = {
                    "Nombre:", nombreField,
                    "Descripción:", descripcionField,
                    "Años Mínimos de Experiencia:", minAniosExperienciaField,
                    "Educación Requerida:", educacionRequeridaField,
                    "Competencias (separadas por ;):", competenciasField,
                    "Profesión:", profesionField
                };

                int editOption = JOptionPane.showConfirmDialog(this, editMessage, "Editar Puesto", JOptionPane.OK_CANCEL_OPTION);
                if (editOption == JOptionPane.OK_OPTION) {
                    puesto.setNombre(nombreField.getText());
                    puesto.setDescripcion(descripcionField.getText());
                    puesto.getRequisitosAdicionales().setMinAniosExperiencia(Integer.parseInt(minAniosExperienciaField.getText()));
                    puesto.getRequisitosAdicionales().setEducaciónRequerida(educacionRequeridaField.getText());
                    puesto.setProfesion(profesionField.getText());
                    // Se necesita actualizar las competencias también
                    JOptionPane.showMessageDialog(this, "Puesto editado exitosamente.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID del Puesto debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (PuestoNoEncontradoException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Método para eliminar un puesto
    private void eliminarPuesto() {
        JTextField idField = new JTextField();

        Object[] message = {
            "ID del Puesto a Eliminar:", idField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Eliminar Puesto", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                int id = Integer.parseInt(idField.getText());
                Puesto puesto = sistema.buscarPuestoPorId(id);
                sistema.getPuestos().remove(puesto);
                JOptionPane.showMessageDialog(this, "Puesto eliminado exitosamente.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID del Puesto debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (PuestoNoEncontradoException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Método para generar un reporte
    private void generarReporte() {
        String nombreArchivo = JOptionPane.showInputDialog(this, "Ingrese el nombre del archivo para el reporte (ej. reporte.txt):");
        if (nombreArchivo != null && !nombreArchivo.trim().isEmpty()) {
            sistema.generarReporte(nombreArchivo);
            JOptionPane.showMessageDialog(this, "Reporte generado exitosamente en " + nombreArchivo);
        } else {
            JOptionPane.showMessageDialog(this, "Nombre de archivo no válido.", "Error", JOptionPane.ERROR_MESSAGE);
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
