package Ventanas;

import Clases.Funciones;
import Entidades.PiezasEntity;
import TableModels.TableModelPieza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Javier Jamaica
 * 19/12/2022 - 16:56
 */
public class verFiltrarPieza extends JFrame {
    private JComboBox campo;
    private JTextField dato;
    private JButton buscarButton;
    private JPanel contenedorPrincipal;
    private JTable table1;
    private JButton atrasButton;

    public verFiltrarPieza() {
        setContentPane(contenedorPrincipal);
        barra();
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<PiezasEntity> piezasEntities = Funciones.verPiezasFiltro(campo.getSelectedItem().toString(),dato.getText());
                if (piezasEntities.size()!=0){
                    table1.setModel(new TableModelPieza(piezasEntities));

                } else {
                    JOptionPane.showMessageDialog(null, "No hay datos con ese filtro", "Codigo duplicado", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;
                JFrame frame = new verPiezas();
                frame.setLocation(width / 3, height / 3);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                dispose();
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
