package militar.soldados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Soldado implements ActionListener {

    String nombre;
    String id;
    String rango;


    public void mostrarInformacion(){
        JFrame nuevaVentana = new JFrame("Nueva Ventana");
        nuevaVentana.setSize(300, 200);
        nuevaVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuevaVentana.setLayout(null);
        JLabel label = new JLabel("Acción realizada desde otra clase.");
        label.setBounds(50, 50, 200, 30);
        nuevaVentana.add(label);

        nuevaVentana.setVisible(true);
    }

    public void patrullar (){
        switch (rango) {
            case "1":
                System.out.println("anda dormite");
            case "2":
                System.out.println("vete escondido");
            case "3":
                System.out.println("vigila a esos soldados inexpertos");
            case "4":
                System.out.println("no dejes que nadie te diga que hacer");
                break;
        
            default:
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    }