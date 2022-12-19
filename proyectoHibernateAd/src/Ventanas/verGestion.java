package Ventanas;

import Clases.Funciones;
import TableModels.TableModelGestion;
import TableModels.TableModelPieza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 19/12/2022 - 17:30
 */
public class verGestion extends JFrame {
    private JTable table1;
    private JButton verButton;
    private JButton atrasButton;
    private JPanel contenedor;

    public verGestion() {
        setContentPane(contenedor);
        verButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                table1.setModel(new TableModelGestion(Funciones.verGestiones()));            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;
                JFrame frame = new ventanaGestion();
                frame.setLocation(width / 3, height / 3);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                dispose();
            }
        });
    }
}
