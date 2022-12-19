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
 * 28/11/2022 - 20:00
 */
public class crearPieza extends JFrame {
    private JPanel contenedorPrincipal;
    private JTextField textoNombre;
    private JTextArea textoDescripcion;
    private JButton atrasButton;
    private JButton crearPiezaButton;
    private JSpinner precio;
    private JTextField id;
    private JSpinner spinner1;

    public crearPieza() {
        setContentPane(contenedorPrincipal);
        double min = 0.00;
        double value = 0.00;
        double max = 1000.00;
        double stepSize = 0.01;
        SpinnerNumberModel model = new SpinnerNumberModel(value, min, max, stepSize);
        precio.setModel(model);


        barra();
        crearPiezaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comprobarDatos(textoNombre, textoDescripcion, precio)) {
                    System.out.print(textoNombre.getText() + textoDescripcion.getText() + Double.parseDouble(precio.getValue().toString()));
                    PiezasEntity pieza = new PiezasEntity();
                    pieza.setIdPiezas(id.getText());
                    pieza.setNombrePieza(textoNombre.getText());
                    pieza.setDescripcionPieza(textoDescripcion.getText());
                    pieza.setPrecioPieza(Double.parseDouble(precio.getValue().toString()));
                    switch (Funciones.crearPieza(pieza)) {
                        case 0 -> JOptionPane.showMessageDialog(null, "Se ha insertado la nueva pieza correctamente");
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
                JFrame frame = new ventanaPiezas();
                frame.setLocation(width / 3, height / 3);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                dispose();
            }
        });
    }
    private void limpiarDatos() {
    id.setText("");
    precio.setValue(0);
    textoDescripcion.setText("");
    textoNombre.setText("");
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

    public boolean comprobarDatos(JTextField textoNombre, JTextArea textoDescripcion, JSpinner precio) {
        if (textoNombre.getText().equals("") || textoDescripcion.getText().equals("") ||
                Double.parseDouble(precio.getValue().toString()) == 0.0) {
            JOptionPane.showMessageDialog(null, "Los datos tienen que estar" +
                    "completos y el precio debe ser mayor que 0!", "Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
