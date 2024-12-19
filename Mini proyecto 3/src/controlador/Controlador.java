package controlador;
import modelo.Batallon;
import modelo.Soldado;
import vistaGUI.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import vistaconsola.VistaConsola;

/**
 * Clase Controlador
 *
 * Esta clase sirve como puente entre el modelo (Batallon), la vista principal (VentanaPrincipal) y la vista de consola (VistaConsola).
 * Maneja las interacciones del usuario mediante un menú en consola, permitiendo realizar operaciones como agregar soldados,
 * asignar misiones, mostrar información y más.
 */

public class Controlador implements ActionListener {
    private Batallon batallon;
    private VentanaPrincipal ventanaPrincipal;
    private VistaConsola vistaConsola;

    public Controlador() {
        // Inicializa el modelo y las vistas
        this.batallon = new Batallon();
        this.ventanaPrincipal = new VentanaPrincipal(this);
        this.vistaConsola = new VistaConsola();

        // Ejecuta la vista de consola para interactuar con el usuario
        ejecutarVistaConsola();
    }

    /**
     * Método ejecutarVistaConsola.
     *
     * Muestra un menú principal al usuario en la consola y maneja las opciones seleccionadas.
     * Permite realizar diversas acciones sobre los soldados en el batallón, como agregarlos,
     * asignarles misiones, mostrar información o interactuar con ellos.
     */
    private void ejecutarVistaConsola() {
        int opcion = 0;
        do {
            // Muestra el menú principal y obtiene la opción seleccionada por el usuario
            opcion = vistaConsola.mostrarMenuPrincipal();

            switch (opcion) {
                case 1:
                    // Agregar un nuevo soldado al batallón
                    String nombreSoldado = vistaConsola.obtenerValorString("Ingrese el nombre del soldado:");
                    String rangoSoldado = vistaConsola.obtenerRangoSoldado();
                    String idSoldado = vistaConsola.obtenerIdSoldado(batallon.getDatosdesoldados());
                    batallon.agregarSoldado(new Soldado(nombreSoldado, rangoSoldado, idSoldado));
                    vistaConsola.mostrarMensaje("Soldado agregado correctamente");
                    ventanaPrincipal.updatelistaSoldados(batallon.getDatosdesoldados());
                    break;
                case 2:
                    // Asignar una misión a un soldado existente
                    int numeroSoldado = vistaConsola.seleccionarSoldado(batallon.getDatosdesoldados(), "Seleccione un soldado a asignar su misión");
                    if (numeroSoldado != -1) {
                        Soldado soldadoSeleccionado = batallon.getDatosdesoldados().get(numeroSoldado);
                        String misionSoldado = vistaConsola.obtenerMision(soldadoSeleccionado.getRango());
                        batallon.asignarMision(soldadoSeleccionado.getId(), misionSoldado);
                        if (!misionSoldado.equals("Desobedeció la misión.")) {
                            vistaConsola.mostrarMensaje("¡Misión aceptada! " + soldadoSeleccionado.getNombre() + " está listo para cumplirla.");
                        }
                    }
                    break;
                case 3:
                    // Mostrar información de todos los soldados
                    vistaConsola.mostrarMensaje("Información de los soldados agregados:");
                    vistaConsola.mostrarSoldados(batallon.getDatosdesoldados());
                    break;
                case 4:
                    // Regañar a un soldado y, si es necesario, eliminarlo
                    int numeroSoldadoARegañar = vistaConsola.seleccionarSoldado(batallon.getDatosdesoldados(), "Seleccione un soldado a regañar");
                    if (numeroSoldadoARegañar != -1) {
                        Soldado soldadoARegañar = vistaConsola.reganiarSoldado(batallon.getDatosdesoldados().get(numeroSoldadoARegañar));
                        if (!soldadoARegañar.getId().equals("-1")) {
                            batallon.getDatosdesoldados().remove(soldadoARegañar);
                        }
                        ventanaPrincipal.updatelistaSoldados(batallon.getDatosdesoldados());
                    }
                    break;
                case 5:
                    // Saludar a un soldado
                    int numeroSoldadoASaludar = vistaConsola.seleccionarSoldado(batallon.getDatosdesoldados(), "Seleccione un soldado a saludar");
                    if (numeroSoldadoASaludar != -1) {
                        vistaConsola.saludarSoldado(batallon.getDatosdesoldados().get(numeroSoldadoASaludar).getNombre());
                    }
                    break;
                case 6:
                    // Asignar una misión de patrulla a un soldado
                    int numeroSoldadoPatrullar = vistaConsola.seleccionarSoldado(batallon.getDatosdesoldados(), "Seleccione un soldado que vaya a patrullar");
                    if (numeroSoldadoPatrullar != -1) {
                        batallon.getDatosdesoldados().get(numeroSoldadoPatrullar).setMision(vistaConsola.ponerPatrullarSoldado());
                        vistaConsola.mostrarMensaje("La patrulla ha sido asignada correctamente.");
                    }
                    break;
                case 7:
                    // Reiniciar la lista de soldados
                    batallon.getDatosdesoldados().clear();
                    ventanaPrincipal.updatelistaSoldados(batallon.getDatosdesoldados());
                    vistaConsola.mostrarMensaje("Conjunto de soldados reiniciado satisfactoriamente");
                    break;
                case 8:
                    // Salir del programa
                    vistaConsola.mostrarMensaje("Ha salido del programa exitosamente.");
                    break;
            }
        } while (opcion != 8); // Repite hasta que se seleccione la opción de salir

        // Cierra la ventana principal al salir
        ventanaPrincipal.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<String> selectedSoldiers;
        List<Soldado> datosdesoldados;
        String comando = e.getActionCommand();

        switch (comando) {
            case "AgregarSoldado":
                // Abre el panel para agregar un nuevo soldado al batallón
                ventanaPrincipal.crearUsuarioPanel(batallon.getDatosdesoldados());
                break;
            case "MostrarInformacion":
                // Actualiza el área de texto con la información del batallón
                ventanaPrincipal.updateTextArea(batallon.getDatosdesoldados());
                break;
            case "Saludar":
                // Realiza la acción de saludar para los soldados seleccionados
                performAction("saludar");
                break;
            case "Regañar":
                // Obtiene los soldados seleccionados y aplica la acción de regañar
                selectedSoldiers = ventanaPrincipal.obtenerListaSoldadosSeleccionados();
                ventanaPrincipal.regañarSoldados(selectedSoldiers, batallon.getDatosdesoldados());
                break;
            case "Patrullar":
                selectedSoldiers = ventanaPrincipal.obtenerListaSoldadosSeleccionados();
                if (selectedSoldiers.isEmpty()) {
                    // Avisa al usuario si no hay soldados seleccionados
                    ventanaPrincipal.mostrarMensajeJOptionPaneAdvertencia("Por favor, selecciona al menos un soldado.");
                    break;
                }

                datosdesoldados = batallon.getDatosdesoldados();
                // Abre la ventana de patrulla para cada soldado seleccionado
                for (String soldierName : selectedSoldiers) {
                    for (Soldado soldado : datosdesoldados) {
                        if (soldado.getNombre().equals(soldierName)) {
                            ventanaPrincipal.ponerPatrullarSoldado(soldado.getId(), soldado.getNombre()); // Pasar el objeto Soldado a la ventana
                            break;
                        }
                    }
                }
                break;
            case "AsignarMision":
                // Asigna una misión a los soldados
                List<String> soldadosSeleccionados = ventanaPrincipal.obtenerListaSoldadosSeleccionados();

                if (soldadosSeleccionados.isEmpty()) {
                    ventanaPrincipal.mostrarMensajeJOptionPaneAdvertencia("Por favor, selecciona al menos un soldado.");
                }else{
                    for (String nombreSoldado : soldadosSeleccionados) {
                        Soldado soldadoActual = batallon.buscarSoldadoPorNombre(nombreSoldado);
                        batallon.asignarMision(soldadoActual.getId(), ventanaPrincipal.asignarMision(soldadoActual.getNombre(), soldadoActual.getRango()));
                    }
                }
                break;
            case "ObtenerMision":
                // Obtiene la mision de un soldado
                Soldado soldadoColocarMision = batallon.buscarSoldadoPorID(ventanaPrincipal.obtenerIDSoldadoActualPatrullar());
                if (!soldadoColocarMision.getId().equals("-1")) {
                    soldadoColocarMision.setMision(ventanaPrincipal.obtenerMision());
                }
                break;
            case "Reiniciar":
                batallon.getDatosdesoldados().clear();
                ventanaPrincipal.updatelistaSoldados(batallon.getDatosdesoldados());
                break;
        }
    }

    public void performAction(String action) {
        // Obtener los soldados seleccionados
        List<String> selectedSoldiers = ventanaPrincipal.obtenerListaSoldadosSeleccionados();
        if (selectedSoldiers.isEmpty()) {
            // Avisa al usuario si no hay soldados seleccionados
            ventanaPrincipal.mostrarMensajeJOptionPaneAdvertencia("Por favor, selecciona al menos un soldado.");
        } else {
            // Limpiar el área de información antes de mostrar nuevos datos
            ventanaPrincipal.limpiarDatosAreaInformacion("");

            // Delegar la acción según el comando proporcionado
            if (action.equals("saludar")) {
                // Ejecuta el saludo para los soldados seleccionados
                String result = VentanaPrincipal.saludarSoldados(selectedSoldiers);
                ventanaPrincipal.ponerDatosAreaInformacion(result);
            } else {
                // Otras acciones como regañar o patrullar
                for (String soldado : selectedSoldiers) {
                    switch (action) {
                        case "regañar":
                            ventanaPrincipal.ponerDatosAreaInformacionReganiarSoldado(soldado);
                            break;
                        case "patrullar":
                            ventanaPrincipal.ponerDatosAreaInformacionPatrullarSoldado(soldado);
                            break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Configura el tema visual Nimbus para la interfaz gráfica
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Controlador(); // Inicia la aplicación
    }
}

