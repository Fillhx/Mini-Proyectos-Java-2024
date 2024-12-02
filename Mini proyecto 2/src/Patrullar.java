import java.awt.GridLayout;
import java.awt.event.ActionEvent;
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

    public Patrullar(Soldado soldado) {
        setTitle("Asignar Patrulla - " + soldado.getNombre());
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Campos de entrada
        add(new JLabel("Forma de Patrulla:"));
        formaPatrullaField = new JTextField();
        add(formaPatrullaField);

        add(new JLabel("Zona de Patrulla:"));
        zonaPatrullaField = new JTextField();
        add(zonaPatrullaField);

        // Botones
        guardarButton = new JButton("Guardar");
        cancelarButton = new JButton("Cancelar");
        add(guardarButton);
        add(cancelarButton);

        // Acción para el botón Guardar
        guardarButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String formaPatrulla = formaPatrullaField.getText();
                String zonaPatrulla = zonaPatrullaField.getText();

                if (formaPatrulla.isEmpty() || zonaPatrulla.isEmpty()) {
                    JOptionPane.showMessageDialog(Patrullar.this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Guardar la información en el soldado
                    soldado.setMision("Patrullar - Forma: " + formaPatrulla + ", Zona: " + zonaPatrulla);
                    JOptionPane.showMessageDialog(Patrullar.this, "La patrulla ha sido asignada correctamente.");
                    dispose(); // Cerrar ventana
                }
            }
                
            });


        // Acción para el botón Cancelar
        cancelarButton.addActionListener(e -> dispose());

        setVisible(true);
        }  
    }
            
        
    

    

