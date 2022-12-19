package Ventanas;

import Clases.Funciones;
import Entidades.ProveedoresEntity;
import Entidades.ProyectosEntity;
import TableModels.TableModelProveedor;
import TableModels.TableModelProyecto;

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
public class verFiltrarProyectos extends JFrame {
    private JPanel contenedorPrincipal;
    private JTable table1;
    private JButton buscarButton;
    private JButton atrasButton;
    private JComboBox comboBox1;
    private JTextField textField1;

    public verFiltrarProyectos() {
        setContentPane(contenedorPrincipal);
    atrasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
            int height = pantalla.height;
            int width = pantalla.width;
            JFrame frame = new verProyectos();
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
            ArrayList<ProyectosEntity> proyectosEntities = Funciones.verProyectosvFiltro(comboBox1.getSelectedItem().toString(),textField1.getText());
            if (proyectosEntities.size()!=0){
                table1.setModel(new TableModelProyecto(proyectosEntities));

            } else {
                JOptionPane.showMessageDialog(null, "No hay datos con ese filtro", "Error", JOptionPane.ERROR_MESSAGE);
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
