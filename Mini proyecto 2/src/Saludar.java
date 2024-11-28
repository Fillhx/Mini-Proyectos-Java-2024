import java.util.List;

import javax.swing.JOptionPane;

public class Saludar {

    public static String saludarSoldados(List<String> selectedSoldiers) {
        StringBuilder result = new StringBuilder();

        for (String soldier : selectedSoldiers) {
            if (soldier.length()>10){
            JOptionPane.showMessageDialog(null, "que nombre tan largoooo, hola "+ soldier);
        }else{
            JOptionPane.showMessageDialog(null, "hola "+ soldier);

        }
            
        }

        return result.toString();
    }
}
