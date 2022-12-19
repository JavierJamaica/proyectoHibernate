package Ventanas;

import Clases.Funciones;
import Entidades.PiezasEntity;
import Entidades.ProveedoresEntity;
import TableModels.TableModelPieza;
import TableModels.TableModelProveedor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * @author Javier Jamaica
 * 19/12/2022 - 17:15
 */
public class verFiltrarProv extends JFrame {
    private JTable table1;
    private JButton atrasButton;
    private JButton buscarButton;
    private JPanel contenedorPrincipal;
    private JComboBox comboBox1;
    private JTextField dato;

    public verFiltrarProv() {
        barra();
        setContentPane(contenedorPrincipal);
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;
                JFrame frame = new VerProveedor();
                frame.setLocation(width / 3, height / 3);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                dispose();
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<ProveedoresEntity> proveedoresEntities = Funciones.verProvFiltro(comboBox1.getSelectedItem().toString(),dato.getText());
                if (proveedoresEntities.size()!=0){
                    table1.setModel(new TableModelProveedor(proveedoresEntities));

                } else {
                    JOptionPane.showMessageDialog(null, "No hay datos con ese filtro", "Codigo duplicado", JOptionPane.ERROR_MESSAGE);
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
}
