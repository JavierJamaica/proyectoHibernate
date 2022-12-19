package Ventanas;

import Clases.Funciones;
import TableModels.TableModelPieza;
import TableModels.TableModelProyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 19/12/2022 - 16:05
 */
public class verProyectos extends JFrame {
    private JPanel contenedorPrincipal;
    private JTable table1;
    private JButton verButton;
    private JButton atrasButton;
public verProyectos() {
    setContentPane(contenedorPrincipal);
    verButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            table1.setModel(new TableModelProyecto(Funciones.verProyectos()));

        }
    });
    atrasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
            int height = pantalla.height;
            int width = pantalla.width;
            JFrame frame = new ventanaProyectos();
            frame.setLocation(width / 3, height / 3);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            dispose();
        }
    });
}
}
