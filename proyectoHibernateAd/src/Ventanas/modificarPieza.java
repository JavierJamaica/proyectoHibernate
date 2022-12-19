package Ventanas;

import Clases.Funciones;
import Entidades.PiezasEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * @author Javier Jamaica
 * 28/11/2022 - 21:04
 */
public class modificarPieza extends JFrame {
    private JPanel contenedorPrincipal;
    private JTextField textoNombre;
    private JTextArea textoDescripcion;
    private JButton atrasButton;
    private JButton modificarButton;
    private JTextField id;
    private JTextField nombre;
    private JTextField desc;
    private JTextField precio;

    public modificarPieza() {
        barra();
        setContentPane(contenedorPrincipal);
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
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PiezasEntity piezas = new PiezasEntity();
                    if (comprobarDatos(id, nombre, desc, precio)) {
                        ;
                        if (!id.getText().equals("")) {
                            piezas.setIdPiezas(id.getText());
                            piezas.setNombrePieza(nombre.getText());

                            piezas.setPrecioPieza(Double.parseDouble(precio.getText()));


                            piezas.setDescripcionPieza(desc.getText());
                            switch (Funciones.modificarPieza(piezas)) {
                                case 0 ->
                                        JOptionPane.showMessageDialog(null, "Se ha actualizado la pieza correctamente");
                                case 1 ->
                                        JOptionPane.showMessageDialog(null, "La pieza no existe", "Error", JOptionPane.ERROR_MESSAGE);
                                case 2 ->
                                        JOptionPane.showMessageDialog(null, "Error al actualizar en la BD", "Error BD", JOptionPane.ERROR_MESSAGE);
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Se debe de introducir un codigo\n para poder modificar una pieza", "Codigo vacio", JOptionPane.WARNING_MESSAGE);
                        }
                        limpiarDatos();


                    } else {
                        JOptionPane.showMessageDialog(null, "Los datos no pueden estar vacios", "Error", JOptionPane.WARNING_MESSAGE);

                    }
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "El precio tiene que ser un numero", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
        });

    }

    private void limpiarDatos() {
        id.setText("");
        nombre.setText("");
        desc.setText("");
        precio.setText("");
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

    public boolean comprobarDatos(JTextField id, JTextField textoNombre, JTextField textoDescripcion, JTextField precio) {
        if (id.getText().equals("") || textoDescripcion.getText().equals("") || textoNombre.getText().equals("") || precio.getText().equals("")) {
            try {
                Double.parseDouble(precio.getText());
                return true;
            } catch (NumberFormatException e) {
                System.out.println("Errr");
            }

            return false;
        }

        return true;
    }
}
