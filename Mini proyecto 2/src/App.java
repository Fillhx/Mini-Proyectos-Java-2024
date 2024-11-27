import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class App extends JFrame implements ActionListener {

    // Lista principal donde se almacenarán los datos
    private static ArrayList<String> userData = new ArrayList<>();

    // Componentes principales
    private JPanel panelSuperior, panelIzquierdo, paneldebotonesIzquierdos, panelCentral, panelDerecho, panelInformacion;
    private JLabel Titulo;
    private JButton AgregarSoldado, Reset, mostrarInformacion, asignarMision, regañar, saludar, patrullar, editarInformacion, eliminarSoldado;
    private JTextArea areadeInformacion;

    public static void main(String[] args) {

        // Look and Feel
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        new App();
    }

    public App() {

        // Configuración interfaz
        setTitle("Sistema de Gestión de Rangos Militares");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel Superior
        panelSuperior = new JPanel();
        Titulo = new JLabel("Sistema de Gestión - Rangos Militares");
        Titulo.setFont(new Font("Arial", Font.BOLD, 18));
        panelSuperior.add(Titulo);

        // Panel Izquierdo
        panelIzquierdo = new JPanel(new BorderLayout(10, 10));
        panelIzquierdo.setBorder(BorderFactory.createTitledBorder("Gestión de Soldados"));

        // Botones para agregar y resetear soldados
        paneldebotonesIzquierdos = new JPanel(new GridLayout(2, 1, 5, 5));
        AgregarSoldado = new JButton("Agregar Soldado");
        Reset = new JButton("Reset");
        paneldebotonesIzquierdos.add(AgregarSoldado);
        paneldebotonesIzquierdos.add(Reset);
        panelIzquierdo.add(paneldebotonesIzquierdos, BorderLayout.SOUTH);

        // Panel Central
        panelCentral = new JPanel(new GridLayout(5, 1, 10, 10));
        panelCentral.setBorder(BorderFactory.createTitledBorder("Acciones"));
        asignarMision = new JButton("Asignar Misión");
        mostrarInformacion = new JButton("Mostrar Información");
        regañar = new JButton("Regañar");
        saludar = new JButton("Saludar");
        patrullar = new JButton("Patrullar");

        panelCentral.add(asignarMision);
        panelCentral.add(mostrarInformacion);
        panelCentral.add(regañar);
        panelCentral.add(saludar);
        panelCentral.add(patrullar);

        // Panel Derecho -- Información del Soldado
        panelDerecho = new JPanel(new BorderLayout(10, 10));
        panelDerecho.setBorder(BorderFactory.createTitledBorder("Información del Soldado"));

        // Área de texto para mostrar información
        areadeInformacion = new JTextArea();
        areadeInformacion.setEditable(false);
        areadeInformacion.setFont(new Font("Monospaced", Font.PLAIN, 14));
        panelDerecho.add(new JScrollPane(areadeInformacion), BorderLayout.CENTER);

        // Botones para editar información
        panelInformacion = new JPanel(new GridLayout(1, 2, 5, 5));
        editarInformacion = new JButton("Editar Información");
        eliminarSoldado = new JButton("Eliminar Soldado");
        panelInformacion.add(editarInformacion);
        panelInformacion.add(eliminarSoldado);

        panelDerecho.add(panelInformacion, BorderLayout.SOUTH);

        // Agregar paneles al frame principal
        add(panelSuperior, BorderLayout.NORTH);
        add(panelIzquierdo, BorderLayout.WEST);
        add(panelCentral, BorderLayout.CENTER);
        add(panelDerecho, BorderLayout.EAST);

        // Eventos de botones
        AgregarSoldado.addActionListener(this);
        mostrarInformacion.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == AgregarSoldado) {
            new Crearusuario(userData); // Abre el formulario para agregar soldados
        } else if (e.getSource() == mostrarInformacion) {
            updateTextArea(); // Muestra la información de los soldados
        }
    }

    // Actualizar área de texto con los datos almacenados
    public void updateTextArea() {
        areadeInformacion.setText(""); // Limpiar el área de texto
        if (userData.isEmpty()) {
            areadeInformacion.setText("No hay datos guardados.");
        } else {
            for (String data : userData) {
                areadeInformacion.append(data + "\n");
            }
        }
    }
}