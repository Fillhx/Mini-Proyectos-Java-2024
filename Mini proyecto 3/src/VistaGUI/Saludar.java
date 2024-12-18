package VistaGUI;

import java.util.List;

import javax.swing.JOptionPane;

public class Saludar {

    // Método estático que saluda a una lista de soldados seleccionados.
    public static String saludarSoldados(List<String> selectedSoldiers) {
        // Utiliza un StringBuilder para construir el resultado final. Es más eficiente que concatenar cadenas directamente.
        StringBuilder result = new StringBuilder();

        // Recorre la lista de nombres de soldados.
        for (String soldier : selectedSoldiers) {
            // Verifica si el nombre del soldado tiene más de 10 caracteres.
            if (soldier.length() > 10) {
                // Muestra un mensaje para nombres largos.
                JOptionPane.showMessageDialog(null, "que nombre tan largoooo, hola " + soldier);
            } else {
                // Muestra un mensaje para nombres cortos o de longitud aceptable.
                JOptionPane.showMessageDialog(null, "hola " + soldier);
            }
        }

        // Retorna el resultado como una cadena. Actualmente, este StringBuilder no se utiliza
        // para almacenar información, lo que lo hace innecesario en este contexto.
        return result.toString();
    }
}
