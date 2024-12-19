package vistaGUI;


import javax.swing.*;

import modelo.Soldado;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Crearusuario extends JFrame {

    private JTextField nameField, idField;
    private JComboBox<String> rankComboBox;

    public Crearusuario(ArrayList<Soldado> datoscompartidos, VentanaPrincipal appContext) {
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

        // Campo para ID
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
                String rank = (String) rankComboBox.getSelectedItem();
                String userId = idField.getText();

                // Validación de campos vacíos
                if (name.isEmpty() || rank.isEmpty() || userId.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validación de ID numérico
                if (!userId.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "El ID debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar ID único
                for (Soldado data : datoscompartidos) {
                    if (data.getId().equals(userId)) {
                        JOptionPane.showMessageDialog(null, "El ID ya está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                // Agregar datos al sistema
                Soldado nuevSoldado = new Soldado(name, rank, userId);
                datoscompartidos.add(nuevSoldado);
                appContext.updatelistaSoldados(datoscompartidos); // Actualizar la lista en el panel izquierdo
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose(); // Cerrar ventana después de guardar
            }
        });

        // Acción para volver a la ventana principal
        backButton.addActionListener(e -> dispose()); // Cierra la ventana actual

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}