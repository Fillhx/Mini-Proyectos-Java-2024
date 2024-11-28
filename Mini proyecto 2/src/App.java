import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


public class App extends JFrame implements ActionListener {

    // Lista principal donde se almacenarán los datos
    public ArrayList<Soldado> datosdesoldados = new ArrayList<>();
    DefaultListModel<String> listModel;
    JList<String> listaSoldados;       


    // Componentes principales
    JPanel panelSuperior, panelIzquierdo, paneldebotonesIzquierdos, panelCentral, panelDerecho, panelInformacion;
    JLabel Titulo, hola;
    JButton AgregarSoldado, Reset, mostrarInformacion, asignarMision, regañar, saludar, patrullar;
    JTextArea areadeInformacion;


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
        panelIzquierdo = new JPanel(new BorderLayout(10, 10)); // Inicialización del panelIzquierdo
        panelIzquierdo.setBorder(BorderFactory.createTitledBorder("Soldados"));
        listModel = new DefaultListModel<>();
        listaSoldados = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listaSoldados);
        panelIzquierdo.add(scrollPane, BorderLayout.CENTER);


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
        hola = new JLabel("          Informacion detallada del soldado          ");
        panelInformacion.add(hola);
        panelDerecho.add(panelInformacion, BorderLayout.SOUTH);


        // Agregar paneles al frame principal
        add(panelSuperior, BorderLayout.NORTH);
        add(panelIzquierdo, BorderLayout.WEST);
        add(panelCentral, BorderLayout.CENTER);
        add(panelDerecho, BorderLayout.EAST);


        // Eventos de botones
        AgregarSoldado.addActionListener(this);
        mostrarInformacion.addActionListener(this);
        saludar.addActionListener(this);
        regañar.addActionListener(this);
        asignarMision.addActionListener(this);
        patrullar.addActionListener(this);
        setVisible(true);
    }


//verificamos que boton o campo se inicializo y concuerdo a eso ejecutamos varias funciones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == AgregarSoldado) {
            new Crearusuario(datosdesoldados, this); 
        } else if (e.getSource() == mostrarInformacion) {
            updateTextArea(); 
        } else if (e.getSource() == saludar) {
            performAction("saludar");
        } else if (e.getSource() == regañar) {
            List<String> selectedSoldiers = listaSoldados.getSelectedValuesList();
            regañarSoldados(selectedSoldiers);
        }else if (e.getSource() == patrullar) {
            List<String> selectedSoldiers = listaSoldados.getSelectedValuesList();
            if (selectedSoldiers.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona al menos un soldado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
                }
            
                // Abrir la ventana de patrulla para cada soldado seleccionado
                for (String soldierName : selectedSoldiers) {
                    for (Soldado soldier : datosdesoldados) {
                        if (soldier.getNombre().equals(soldierName)) {
                            new Patrullar(soldier); // Pasar el objeto Soldado a la ventana
                            break;
                        }
                    }
                }
       
        } else if(e.getSource() == asignarMision){
            List<String> selectedSoldiers = listaSoldados.getSelectedValuesList();
            AsignarMision asignarMision = new AsignarMision();
            asignarMision.asignarMision(selectedSoldiers, datosdesoldados);
        


        }
}

    public void performAction(String action) {
    // Obtener los soldados seleccionados
        List<String> selectedSoldiers = listaSoldados.getSelectedValuesList();
    if (selectedSoldiers.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona al menos un soldado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }
    // Limpiar el área de información
    areadeInformacion.setText("");

    // Delegar la acción
    if (action.equals("saludar")) {
        // Usa el método de la clase Saludar
        String result = Saludar.saludarSoldados(selectedSoldiers);
        areadeInformacion.append(result);
    } else {
        // Otras acciones (regañar, patrullar)
        for (String soldier : selectedSoldiers) {
            switch (action) {
                case "regañar":
                    areadeInformacion.append("El soldado " + soldier + " ha sido regañado.\n");
                    break;
                case "patrullar":
                    areadeInformacion.append("El soldado " + soldier + " ha sido asignado a patrullar.\n");
                    break;
            }
        }
    }
}


    // Actualizar área de texto con los datos almacenados
    public void updateTextArea() {
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
    public void updatelistaSoldados(String name) {
        listModel.addElement(name);
    }


    void regañarSoldados(List<String> selectedSoldiers) {
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
        actualizarListaVisual();
    }
        
        void actualizarListaVisual() {
            listModel.clear();
            for (Soldado soldier : datosdesoldados) {
                listModel.addElement(soldier.getNombre());
            }
        }
            
}