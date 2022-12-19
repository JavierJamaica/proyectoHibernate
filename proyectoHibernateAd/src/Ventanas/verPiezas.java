package Ventanas;

import Clases.Funciones;
import TableModels.TableModelPieza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 19/12/2022 - 14:44
 */
public class verPiezas extends JFrame {
    private JPanel panel1;
    private JButton verButton;
    private JButton atrasButton;
    private JTable table1;

    public verPiezas() {
        setContentPane(panel1);
        verButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table1.setModel(new TableModelPieza(Funciones.verPiezas()));
            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;
                JFrame frame = new ventanaPiezas();
                frame.setLocation(width / 3, height / 3);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                dispose();
            }
        });
    }
}
