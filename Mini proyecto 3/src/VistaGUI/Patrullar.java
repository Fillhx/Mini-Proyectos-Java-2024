package VistaGUI;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Patrullar extends JFrame {
    private JTextField formaPatrullaField;
    private JTextField zonaPatrullaField;
    private JButton guardarButton, cancelarButton;
    private String soldadoID;

    public Patrullar(String soldadoID, String nombreSoldado, ActionListener listener) {
        this.soldadoID = soldadoID;
        // Configura las propiedades de la ventana
        setTitle("Asignar Patrulla - " + nombreSoldado); // Título dinámico con el nombre del soldado
        setSize(400, 250); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana al cerrarla
        setLayout(new GridLayout(4, 2, 10, 10)); // Distribución en cuadrícula con separación entre componentes
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Agrega el campo para la forma de patrulla
        add(new JLabel("Forma de Patrulla:")); // Etiqueta descriptiva
        formaPatrullaField = new JTextField(); // Campo de texto para ingresar la forma de patrulla
        add(formaPatrullaField);

        // Agrega el campo para la zona de patrulla
        add(new JLabel("Zona de Patrulla:")); // Etiqueta descriptiva
        zonaPatrullaField = new JTextField(); // Campo de texto para ingresar la zona de patrulla
        add(zonaPatrullaField);

        // Configura los botones
        guardarButton = new JButton("Guardar"); // Botón para guardar la misión
        cancelarButton = new JButton("Cancelar"); // Botón para cancelar la operación
        add(guardarButton);
        add(cancelarButton);

        // Configura la acción del botón Guardar
        guardarButton.addActionListener(listener);
        guardarButton.setActionCommand("ObtenerMision");

        // Configura la acción del botón Cancelar
        cancelarButton.addActionListener(e -> dispose()); // Cierra la ventana sin realizar ninguna acción

        // Hace visible la ventana
        setVisible(true);
    }

    public String obtenerMision(){
        String formaPatrulla = formaPatrullaField.getText();
        String zonaPatrulla = zonaPatrullaField.getText();

        // Valida que los campos no estén vacíos
        if (formaPatrulla.isEmpty() || zonaPatrulla.isEmpty()) {
            JOptionPane.showMessageDialog(Patrullar.this,
                    "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return "";
        } else {
            // Asigna la misión al soldado con los datos ingresados
            JOptionPane.showMessageDialog(Patrullar.this,
                    "La patrulla ha sido asignada correctamente.");
            dispose(); // Cierra la ventana actual
        }
        //Devuelve los datos de la patrulla que fue asignada
        return "Patrullar - Forma: " + formaPatrulla + ", Zona: " + zonaPatrulla;
    }

    public String obtenerIDSoldadoActual(){
        return this.soldadoID;
    }
}
            
        
    

    
