package Ventanas;

import Clases.Funciones;
import TableModels.TableModelGestion;
import TableModels.TableModelPieza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

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
        barra();
        verButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                table1.setModel(new TableModelGestion(Funciones.verGestiones()));
            }
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

    public void barra() {

        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("Ayuda");
        jMenu.setMnemonic(KeyEvent.VK_F);
        jMenu.getAccessibleContext().setAccessibleDescription("Cosas");
        jMenuBar.add(jMenu);
        JMenuItem menuItem;
        menuItem = new JMenuItem("Ayuda");
        menuItem.setMnemonic(KeyEvent.VK_P);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "New Project");
        jMenu.add(menuItem);
        setJMenuBar(jMenuBar);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Ni dios ni nadie puede ayudarte.");
            }
        });
    }
}
