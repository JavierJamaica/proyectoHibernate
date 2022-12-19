package Ventanas;

import Clases.Funciones;
import Entidades.PiezasEntity;
import Entidades.ProyectosEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * @author Javier Jamaica
 * 19/12/2022 - 15:57
 */
public class eliminarProyecto extends JFrame {
    private JPanel contenedorPrincipal;
    private JButton eliminarButton;
    private JButton atrasButton;
    private JTextField id;

    public eliminarProyecto() {
        setContentPane(contenedorPrincipal);
        barra();
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
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProyectosEntity p = new ProyectosEntity();
                if (!id.getText().equals("")) {
                    p.setIdproyectos(id.getText());
                    switch (Funciones.borrarProyecto(p)) {
                        case 0 -> JOptionPane.showMessageDialog(null, "Se ha eliminado el proyecto correctamente");
                        case 1 ->
                                JOptionPane.showMessageDialog(null, "El proyecto no existe", "Error", JOptionPane.ERROR_MESSAGE);
                        case 2 ->
                                JOptionPane.showMessageDialog(null, "Error al eliminar en la BD", "Error BD", JOptionPane.ERROR_MESSAGE);
                    }


                } else {
                    JOptionPane.showMessageDialog(null, "Se debe de introducir un codigo\n para poder eliminar una pieza", "Codigo vacio", JOptionPane.WARNING_MESSAGE);
                }
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
