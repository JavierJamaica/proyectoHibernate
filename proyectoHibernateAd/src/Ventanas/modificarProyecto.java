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
 * 19/12/2022 - 15:50
 */
public class modificarProyecto extends JFrame {
    private JPanel contenedorPrincipal;
    private JButton atrasButton;
    private JButton modificarButton;
    private JTextField ciudad;
    private JTextField nombre;
    private JTextField id;

    public modificarProyecto() {
        setContentPane(contenedorPrincipal);
        barra();
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
                ProyectosEntity pro = new ProyectosEntity();
                if (comprobarDatos(id, nombre, ciudad)) {


                    pro.setIdproyectos(id.getText());
                    pro.setNombreProyecto(nombre.getText());
                    pro.setCiudad(ciudad.getText());
                    switch (Funciones.modificarProyecto(pro)) {
                        case 0 -> JOptionPane.showMessageDialog(null, "Se ha actualizado el proyecto correctamente");
                        case 1 ->
                                JOptionPane.showMessageDialog(null, "El proyecto no existe", "Error", JOptionPane.ERROR_MESSAGE);
                        case 2 ->
                                JOptionPane.showMessageDialog(null, "Error al actualizar en la BD", "Error BD", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "El id no puede estar vacio!", "Codigo vacio", JOptionPane.WARNING_MESSAGE);
                }
                limpiarDatos();


            }
        });
    }

    private void limpiarDatos() {
        id.setText("");
        nombre.setText("");
        ciudad.setText("");
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

    public boolean comprobarDatos(JTextField id, JTextField nombre, JTextField ciudad) {
        return !id.getText().equals("") && !nombre.getText().equals("") && !ciudad.getText().equals("");
    }
}
