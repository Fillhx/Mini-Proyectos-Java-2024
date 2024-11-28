
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class AsignarMision extends JFrame  {

        public void asignarMision(List<String> selectedSoldiers, List<Soldado> datosdesoldados) {
        if (selectedSoldiers.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona al menos un soldado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Solicitar misión al usuario
        String mission = JOptionPane.showInputDialog(null, "Ingresa la misión para los soldados seleccionados:");

        if (mission == null || mission.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La misión no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Asignar misión a los soldados seleccionados
        for (String soldierName : selectedSoldiers) {
            for (Soldado soldier : datosdesoldados) {
                if (soldier.getNombre().equals(soldierName)) {
                    soldier.setMision(mission); // Asignar misión al soldado
                    break;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Misión asignada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
}
