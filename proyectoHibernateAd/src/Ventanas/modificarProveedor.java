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
 * 19/12/2022 - 15:03
 */
public class modificarProveedor extends JFrame {

    private JButton atrasButton;
    private JButton modificarButton;
    private JPanel contenedorPrincipal;
    private JTextField id;
    private JTextField nombre;
    private JTextField apellido;
    private JTextField direccion;

    public modificarProveedor() {
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
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProveedoresEntity prov = new ProveedoresEntity();
                if (comprobarDatos(id, nombre, apellido, direccion)) {


                    prov.setIdProveedores(id.getText());
                    prov.setNombreProv(nombre.getText());
                    prov.setApellidosProv(apellido.getText());
                    prov.setDireccionPostal(direccion.getText());


                    switch (Funciones.modificarProv(prov)) {
                        case 0 -> JOptionPane.showMessageDialog(null, "Se ha actualizado el proveedor correctamente");
                        case 1 ->
                                JOptionPane.showMessageDialog(null, "el proveedor no existe", "Error", JOptionPane.ERROR_MESSAGE);
                        case 2 ->
                                JOptionPane.showMessageDialog(null, "Error al modificar", "Error BD", JOptionPane.ERROR_MESSAGE);
                    }


                    limpiarDatos();


                } else {
                    JOptionPane.showMessageDialog(null, "Los datos no pueden estar vacios", "Error", JOptionPane.WARNING_MESSAGE);

                }
            }
        });


    }

    private void limpiarDatos() {
        id.setText("");
        nombre.setText("");
        apellido.setText("");
        direccion.setText("");
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

    public boolean comprobarDatos(JTextField id, JTextField textoNombre, JTextField apellido, JTextField direccion) {
        return !id.getText().equals("") && !apellido.getText().equals("") && !textoNombre.getText().equals("") && !direccion.getText().equals("");
    }


}
