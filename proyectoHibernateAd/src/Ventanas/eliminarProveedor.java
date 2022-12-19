package Ventanas;

import Clases.Funciones;
import Entidades.ProveedoresEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * @author Javier Jamaica
 * 19/12/2022 - 15:18
 */
public class eliminarProveedor extends JFrame {
    private JTextField id;
    private JButton atrasButton;
    private JButton eliminarButton;
    private JPanel contenedorPrincipal;

    public eliminarProveedor() {
        barra();
        setContentPane(contenedorPrincipal);
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;
                JFrame frame = new ventanaProveedores();
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
                ProveedoresEntity p = new ProveedoresEntity();
                if (!id.getText().equals("")) {
                    p.setIdProveedores(id.getText());
                    switch (Funciones.borrarProveedor(p)) {
                        case 0 -> JOptionPane.showMessageDialog(null, "Se ha eliminado al proveedor correctamente");
                        case 1 ->
                                JOptionPane.showMessageDialog(null, "El proveedor no existe", "Error", JOptionPane.ERROR_MESSAGE);
                        case 2 ->
                                JOptionPane.showMessageDialog(null, "Error al eliminar en la BD", "Error BD", JOptionPane.ERROR_MESSAGE);
                    }


                } else {
                    JOptionPane.showMessageDialog(null, "El id no puede estar vacio", "Error", JOptionPane.WARNING_MESSAGE);
                }
                limpiarDatos();
            }
        });
    }

    private void limpiarDatos() {
        id.setText(""
        );
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
