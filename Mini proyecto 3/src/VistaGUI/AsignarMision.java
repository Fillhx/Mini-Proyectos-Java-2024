package VistaGUI;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AsignarMision {

    public String asignarMision(String nombreSoldado, String rangoSoldado) {
        String mision = "";
        // Muestra un mensaje personalizado
        String saludo = "¡Hola " + nombreSoldado + "! Estás a punto de recibir una misión. ¿Estás listo?";

        // Definimos las misiones según el rango
        List<String> misiones = new ArrayList<>();
        switch (rangoSoldado) {
            case "General":
                misiones.add("Planificar una estrategia avanzada.");
                misiones.add("Liderar una reunión de comandantes.");
                misiones.add("Revisar las fuerzas enemigas.");
                break;
            case "Capitán":
                misiones.add("Supervisar la logística del equipo.");
                misiones.add("Coordinar las operaciones de los tenientes.");
                misiones.add("Ejecutar un ataque sorpresa.");
                break;
            case "Teniente":
                misiones.add("Liderar una escuadra de entrenamiento.");
                misiones.add("Patrullar la zona asignada.");
                misiones.add("Preparar a las tropas para un ejercicio nocturno.");
                break;
            case "Soldado Raso":
                misiones.add("Realizar patrullas de seguridad.");
                misiones.add("Limpiar el campo de batalla.");
                misiones.add("Revisar el equipo de los soldados.");
                break;
            default:
                misiones.add("Recibir una misión secreta.");
                break;
        }

        // Mostrar las misiones para elegir
        String misionElegida = (String) JOptionPane.showInputDialog(null, "Elige tu misión",
                saludo, JOptionPane.QUESTION_MESSAGE, null,
                misiones.toArray(), misiones.get(0));

        // Si el soldado decide no aceptar la misión
        if (misionElegida == null) {
            JOptionPane.showMessageDialog(null, "¡El soldado ha desobedecido la orden! Su rango ha sido reducido.");
            mision = "Desobedeció la misión.";
        } else {
            mision = misionElegida;  // Asignar misión elegida
            JOptionPane.showMessageDialog(null, "¡Misión aceptada! " + nombreSoldado + " está listo para cumplirla.");
        }
        return mision;
    }
}
