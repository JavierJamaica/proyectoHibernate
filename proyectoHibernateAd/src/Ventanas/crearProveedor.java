package Ventanas;

import Clases.Funciones;
import Entidades.PiezasEntity;
import Entidades.ProveedoresEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * @author Javier Jamaica
 * 19/12/2022 - 14:50
 */
public class crearProveedor extends JFrame {
    private JPanel contenedorPrincipal;
    private JButton crearButton;
    private JButton atrasButton;
    private JTextField direccion;
    private JTextField apellidos;
    private JTextField nombre;
    private JTextField id;

    public crearProveedor() {

        setContentPane(contenedorPrincipal);
        barra();
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comprobarDatos(id, nombre, apellidos, direccion)) {
                    ProveedoresEntity prov = new ProveedoresEntity();
                    prov.setIdProveedores(id.getText());
                    prov.setNombreProv(nombre.getText());
                    prov.setApellidosProv(apellidos.getText());
                    prov.setDireccionPostal(direccion.getText());
                    switch (Funciones.crearProveedor(prov)) {
                        case 0 ->
                                JOptionPane.showMessageDialog(null, "Se ha insertado al nuevo proveedor correctamente");
                        case 1 ->
                                JOptionPane.showMessageDialog(null, "Error de BD al insertar pieza", "Error insertar", JOptionPane.ERROR_MESSAGE);
                        case 2 ->
                                JOptionPane.showMessageDialog(null, "Ya existe una pieza con el mismo codigo", "Codigo duplicado", JOptionPane.ERROR_MESSAGE);
                    }
                }
                limpiarDatos();
            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;
                JFrame frame = new ventanaProveedores();
                frame.setLocation(width / 3, height / 4);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                dispose();
            }
        });
    }

    private void limpiarDatos() {
        id.setText("");
        nombre.setText("");
        apellidos.setText("");
        direccion.setText("");
    }

    public boolean comprobarDatos(JTextField textoNombre, JTextField nombre, JTextField apellidos, JTextField direccion) {
        if (textoNombre.getText().equals("") || nombre.getText().equals("") || apellidos.getText().equals("") || direccion.getText().equals("")
        ) {
            JOptionPane.showMessageDialog(null, "Los datos tienen que estar" +
                    "completos", "Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
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
