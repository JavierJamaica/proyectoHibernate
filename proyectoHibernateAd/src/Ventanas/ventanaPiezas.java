package Ventanas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * @author Javier Jamaica
 * 21/11/2022 - 21:14
 */
public class ventanaPiezas extends JFrame {
    public JPanel contenedorPrincipal;
    private JButton atrasButton;
    private JButton crearButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JButton buscarButton;

    public ventanaPiezas() {
        setContentPane(contenedorPrincipal);
        barra();
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
