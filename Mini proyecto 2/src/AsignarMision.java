import java.util.List;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class AsignarMision {

    public void asignarMision(List<String> selectedSoldiers, List<Soldado> datosdesoldados) {
        if (selectedSoldiers.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona al menos un soldado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (String soldierName : selectedSoldiers) {
            for (Soldado soldier : datosdesoldados) {
                if (soldier.getNombre().equals(soldierName)) {
                    // Muestra un mensaje personalizado
                    String saludo = "¡Hola " + soldier.getNombre() + "! Estás a punto de recibir una misión. ¿Estás listo?";

                    // Definimos las misiones según el rango
                    List<String> misiones = new ArrayList<>();
                    switch (soldier.getRango()) {
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
                        soldier.reducirNivel();  // Reducir el nivel y degradar rango
                        soldier.setMision("Desobedeció la misión.");
                    } else {
                        soldier.setMision(misionElegida);  // Asignar misión elegida
                        JOptionPane.showMessageDialog(null, "¡Misión aceptada! " + soldier.getNombre() + " está listo para cumplirla.");
                    }

                    
                }
            }
        }
    }
}
