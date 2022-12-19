package Ventanas;

import Clases.Funciones;
import Entidades.PiezasEntity;
import Entidades.ProveedoresEntity;
import Entidades.ProyectosEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * @author Javier Jamaica
 * 19/12/2022 - 15:41
 */
public class crearProyecto extends JFrame {
    private JPanel contenedorPrincipal;
    private JTextField id;
    private JButton atrasButton;
    private JTextField nombre;
    private JButton crearButton;
    private JTextField ciudad;


    public crearProyecto() {
        barra();
        setContentPane(contenedorPrincipal);
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
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comprobarDatos(id, nombre, ciudad)) {
                    ProyectosEntity prov = new ProyectosEntity();
                    prov.setIdproyectos(id.getText());
                    prov.setNombreProyecto(nombre.getText());
                    prov.setCiudad(ciudad.getText());
                    switch (Funciones.crearProyecto(prov)) {
                        case 0 -> JOptionPane.showMessageDialog(null, "Se ha insertado el proyecto correctamente");
                        case 1 ->
                                JOptionPane.showMessageDialog(null, "Error al insertar el proyecto", "Error insertar", JOptionPane.ERROR_MESSAGE);
                        case 2 ->
                                JOptionPane.showMessageDialog(null, "Ya existe un proyecto con el mismo id", "Error", JOptionPane.ERROR_MESSAGE);
                    }
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

    public boolean comprobarDatos(JTextField textoNombre, JTextField nombre, JTextField ciudad) {
        if (textoNombre.getText().equals("") || nombre.getText().equals("") ||
                ciudad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Los datos tienen que estar" +
                    "completos!", "Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
