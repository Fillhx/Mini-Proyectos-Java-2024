import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Crearusuario extends JFrame {

    JTextField nameField, idField;
    JComboBox<String> rankComboBox;

    public Crearusuario(ArrayList<String> sharedData) {
        setTitle("Formulario de Soldado");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Campo para el nombre
        add(new JLabel("Nombre:"));
        nameField = new JTextField();
        add(nameField);

        // ComboBox para rango
        add(new JLabel("Rango:"));
        String[] ranks = {"Capitán", "Teniente", "General", "Soldado Raso"};
        rankComboBox = new JComboBox<>(ranks);
        add(rankComboBox);

        // Campo para misión
        add(new JLabel("Id:"));
        idField = new JTextField();
        add(idField);

        // Botones
        JButton saveButton = new JButton("Guardar");
        JButton backButton = new JButton("Volver");
        add(saveButton);
        add(backButton);

        // Acción para guardar datos
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String rank = (String) rankComboBox.getSelectedItem(); // Obtener el rango seleccionado
                String userId = idField.getText();

                if (name.isEmpty() || rank.isEmpty() || userId.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    sharedData.add("Nombre: " + name + ", Rango: " + rank + ", Id: " + userId);
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dispose(); // Cerrar ventana después de guardar
                }
            }
        });

        // Acción para volver a la ventana principal
        backButton.addActionListener(e -> dispose()); // Cierra la ventana actual

        setVisible(true);
    }
}