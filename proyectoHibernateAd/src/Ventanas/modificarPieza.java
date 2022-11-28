package Ventanas;

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
    private JComboBox comboId;
    private JComboBox comboDatoModif;
    private JSpinner precio;
    private JTextField textoNombre;
    private JTextArea textoDescripcion;
    private JButton atrasButton;
    private JButton modificarButton;
    private JButton botonConfirmarDatoModif;

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
                if (comprobarDatos(comboDatoModif, textoNombre, textoDescripcion, precio)) {
                    System.out.println(textoNombre.getText() + textoDescripcion.getText() + precio.getValue());
                }
            }
        });
        botonConfirmarDatoModif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (comboDatoModif.getSelectedIndex()) {
                    case 0 -> {
                        precio.setVisible(false);
                        textoDescripcion.setVisible(false);
                        textoNombre.setVisible(true);
                    }
                    case 1 -> {
                        modificarPieza.this.setSize(400,270);
                        precio.setVisible(false);
                        textoDescripcion.setVisible(true);
                        textoNombre.setVisible(false);
                    }
                    case 2 -> {
                        precio.setVisible(true);
                        textoDescripcion.setVisible(false);
                        textoNombre.setVisible(false);
                    }
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

    public boolean comprobarDatos(JComboBox comboBoxEditor, JTextField textoNombre, JTextArea textoDescripcion, JSpinner precio) {
        switch (comboBoxEditor.getSelectedIndex()) {
            case 0:
                if (textoNombre.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "El nombre no puede estar vacio", "Error!", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                break;
            case 1:
                if (textoDescripcion.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "La descripcion no puede estar vacia", "Error!", JOptionPane.ERROR_MESSAGE);
                    return false;
                }

                break;
            case 2:
                if (Double.parseDouble(precio.getValue().toString()) == 0.0) {
                    JOptionPane.showMessageDialog(null, "El precio debe ser mayor que 0!", "Error!", JOptionPane.ERROR_MESSAGE);
                    return false;
                }

                break;
        }

        return true;
    }
}
