import java.awt.BorderLayout;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Saludar {

    public static String saludarSoldados(List<String> selectedSoldiers) {
        StringBuilder result = new StringBuilder();

        for (String soldier : selectedSoldiers) {
            if (soldier.length()>10){
            showGreetingImage("solado.jpeg",soldier);
        }else{
            JOptionPane.showMessageDialog(null, "hola "+ soldier);

        }
            
        }

        return result.toString();
    }
}

private static void showGreetingImage(String imageName, String soldierName){
    String ImagePath = "C:\\Users\\laura\\Downloads" + imageName;
    ImageIcon icon = new ImageIcon(Saludar.class.getResource("C:\\Users\\laura\\Downloads"+ imageName));

    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    JLabel label = new JLabel(soldierName + "¡que nombre mas largo!", icon, JLabel.CENTER);
    
    panel.add(label, BorderLayout.CENTER);

    JFrame frame = new JFrame("saludo" + soldierName);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(400,400);
    frame.add(panel);
    frame.setVisible(true);
}

