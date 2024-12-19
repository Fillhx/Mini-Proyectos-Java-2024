package VistaGUI;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import modelo.Soldado;


public class VentanaPrincipal extends JFrame {

    // Lista principal donde se almacenarán los datos
    private DefaultListModel<String> listModel;
    private JList<String> listaSoldados;
    // Componentes principales
    private JPanel panelSuperior, panelIzquierdo, paneldebotonesIzquierdos, panelCentral, panelDerecho, panelInformacion;
    private JLabel Titulo, hola;
    private JButton AgregarSoldado, Reset, mostrarInformacion, asignarMision, regañar, saludar, patrullar;
    private JTextArea areadeInformacion;
    private ActionListener listener;
    private Patrullar patrullarPanel;

    public VentanaPrincipal(ActionListener listener) {
        this.listener = listener;
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
        panelIzquierdo = new JPanel(new BorderLayout(10, 10)); // Inicialización del panelIzquierdo
        panelIzquierdo.setBorder(BorderFactory.createTitledBorder("Soldados"));
        listModel = new DefaultListModel<>();
        listaSoldados = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listaSoldados);
        panelIzquierdo.add(scrollPane, BorderLayout.CENTER);


        // Botones para agregar y resetear soldados
        paneldebotonesIzquierdos = new JPanel(new GridLayout(2, 1, 5, 5));
        AgregarSoldado = new JButton("Agregar Soldado");
        AgregarSoldado.addActionListener(listener);
        AgregarSoldado.setActionCommand("AgregarSoldado");
        Reset = new JButton("Reset");
        Reset.addActionListener(listener);
        Reset.setActionCommand("Reiniciar");
        paneldebotonesIzquierdos.add(AgregarSoldado);
        paneldebotonesIzquierdos.add(Reset);
        panelIzquierdo.add(paneldebotonesIzquierdos, BorderLayout.SOUTH);


        // Panel Central
        panelCentral = new JPanel(new GridLayout(5, 1, 10, 10));
        panelCentral.setBorder(BorderFactory.createTitledBorder("Acciones"));
        asignarMision = new JButton("Asignar Misión");
        asignarMision.addActionListener(listener);
        asignarMision.setActionCommand("AsignarMision");


        mostrarInformacion = new JButton("Mostrar Información");
        mostrarInformacion.addActionListener(listener);
        mostrarInformacion.setActionCommand("MostrarInformacion");
        regañar = new JButton("Regañar");
        regañar.addActionListener(listener);
        regañar.setActionCommand("Regañar");

        saludar = new JButton("Saludar");
        saludar.addActionListener(listener);
        saludar.setActionCommand("Saludar");

        patrullar = new JButton("Patrullar");
        patrullar.addActionListener(listener);
        patrullar.setActionCommand("Patrullar");

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
        hola = new JLabel("          Informacion detallada del soldado          ");
        panelInformacion.add(hola);
        panelDerecho.add(panelInformacion, BorderLayout.SOUTH);


        // Agregar paneles al frame principal
        add(panelSuperior, BorderLayout.NORTH);
        add(panelIzquierdo, BorderLayout.WEST);
        add(panelCentral, BorderLayout.CENTER);
        add(panelDerecho, BorderLayout.EAST);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // Actualizar área de texto con los datos almacenados
    public void updateTextArea(ArrayList<Soldado> datosdesoldados) {
        areadeInformacion.setText(""); // Limpiar el área de texto
        if (datosdesoldados.isEmpty()) {
            areadeInformacion.setText("No hay datos guardados.");
        } else {
            for (Soldado data : datosdesoldados) {
                areadeInformacion.append(data + "\n");
            }
        }
    }

    //Actualiza la lista de los nombres de los soldados registrados
    public void updatelistaSoldados(ArrayList<Soldado> soldados) {
        listModel.clear();
        for(Soldado soldado : soldados){
            listModel.addElement(soldado.getNombre());
        }
    }


    public void regañarSoldados(List<String> selectedSoldiers, ArrayList<Soldado> datosdesoldados) {
        if (selectedSoldiers.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona al menos un soldado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;}
        List<Soldado> soldadosAEliminar = new ArrayList<>();
        areadeInformacion.setText("");
        // Iterar sobre los soldados seleccionados
        for (String soldierName : selectedSoldiers){
            for (Soldado soldier : datosdesoldados){
                if (soldier.getNombre().equals(soldierName)){
                    boolean sigueActivo = soldier.reducirNivel();
                    if(!sigueActivo){
                        soldadosAEliminar.add(soldier);
                        areadeInformacion.append("El soldado " + soldier.getNombre() + " ha sido eliminado (nivel 0).\n");
                    }else{
                        areadeInformacion.append("El soldado " + soldier.getNombre() + " ha sido regañado. Nivel actual: " + soldier.getNivel() + ".\n");
                    }break;}
            }
        }
        // Eliminar soldados cuyo nivel llegó a 0
        datosdesoldados.removeAll(soldadosAEliminar);
        actualizarListaVisual(datosdesoldados);
    }

    // Limpia la lista actual de soldados y la actualiza con los nuevos soldados que fueron registrados
    void actualizarListaVisual(ArrayList<Soldado> datosdesoldados) {
        listModel.clear();
        for (Soldado soldier : datosdesoldados) {
            listModel.addElement(soldier.getNombre());
        }
    }

    // Muestra un mensaje de advertencia utilizando un cuadro de diálogo.
    public void mostrarMensajeJOptionPaneAdvertencia(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    // Limpia el área de información y establece un nuevo mensaje.
    public void limpiarDatosAreaInformacion(String mensaje) {
        areadeInformacion.setText(mensaje);
    }

    // Agrega un mensaje al área de información sin borrar el contenido existente.
    public void ponerDatosAreaInformacion(String mensaje) {
        areadeInformacion.append(mensaje);
    }

    // Agrega un mensaje específico al área de información indicando que un soldado ha sido regañado.
    public void ponerDatosAreaInformacionReganiarSoldado(String soldado) {
        areadeInformacion.append("El soldado " + soldado + " ha sido regañado.\n");
    }

    // Agrega un mensaje específico al área de información indicando que un soldado ha sido asignado a patrullar.
    public void ponerDatosAreaInformacionPatrullarSoldado(String soldado) {
        areadeInformacion.append("El soldado " + soldado + " ha sido asignado a patrullar.\n");
    }

    // Saluda a los soldados seleccionados mediante una llamada a la clase Saludar.
    public static String saludarSoldados(List<String> selectedSoldiers) {
        return Saludar.saludarSoldados(selectedSoldiers);
    }

    // Obtiene la lista de soldados seleccionados del componente listaSoldados.
    public List<String> obtenerListaSoldadosSeleccionados() {
        return listaSoldados.getSelectedValuesList();
    }

    // Crea una nueva instancia del panel Crearusuario con la lista de soldados.
    public void crearUsuarioPanel(ArrayList<Soldado> datosdesoldados) {
        new Crearusuario(datosdesoldados, this);
    }

    // Asigna una misión a un soldado con base en su nombre y rango.
    // Devuelve un mensaje con el resultado de la asignación.
    public String asignarMision(String nombreSoldado, String rangoSoldado) {
        AsignarMision asignarMision = new AsignarMision();
        return asignarMision.asignarMision(nombreSoldado, rangoSoldado);
    }

    // Inicializa el panel de patrullaje para un soldado específico.
    public void ponerPatrullarSoldado(String soldadoID, String nombreSoldado) {
        this.patrullarPanel = new Patrullar(soldadoID, nombreSoldado, listener);
    }

    // Obtiene la misión actual desde el panel de patrullaje.
    public String obtenerMision() {
        return this.patrullarPanel.obtenerMision();
    }

    // Obtiene el ID del soldado actualmente en patrullaje desde el panel.
    public String obtenerIDSoldadoActualPatrullar() {
        return this.patrullarPanel.obtenerIDSoldadoActual();
    }
    
}