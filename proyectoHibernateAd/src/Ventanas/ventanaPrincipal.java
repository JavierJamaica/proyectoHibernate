package Ventanas;

import net.bytebuddy.asm.Advice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 21/11/2022 - 18:59
 */
public class ventanaPrincipal {
    public JPanel contenedorPrincipal;
    private JLabel logoLabel;
    private JButton salirButton;
    private JButton botonProv;
    private JButton botonPiezas;
    private JButton botonProyectos;
    private JButton botonGestion;
    private JLabel logo2;
    private JLabel tituloProveedor;
    private JLabel tituloPieza;
    private JLabel tituloProyectos;
    private JLabel tituloGestion;

    public ventanaPrincipal() {
        logoLabel.setSize(400, 180);
        ImageIcon imagen = new ImageIcon("src/Imagenes/logo1.png");
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(logoLabel.getWidth(), logoLabel.getHeight(), Image.SCALE_DEFAULT));
        logoLabel.setIcon(icon);

        logo2.setSize(149, 149);
        ImageIcon imagen2 = new ImageIcon("src/Imagenes/logo2.png");
        Icon icon2 = new ImageIcon(imagen2.getImage().getScaledInstance(logo2.getWidth(), logo2.getHeight(), Image.SCALE_DEFAULT));
        logo2.setIcon(icon2);

        botonProv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;

                JFrame frame = new JFrame("Proveedores");
                frame.setLocation(width / 3, height / 3);
                frame.setContentPane(new ventanaProveedores().contenedorPrincipal);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        botonPiezas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;

                JFrame frame = new JFrame("Piezas");
                frame.setLocation(width / 3, height / 3);
                frame.setContentPane(new ventanaPiezas().contenedorPrincipal);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        botonProyectos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;

                JFrame frame = new JFrame("Proyectos");
                frame.setLocation(width / 3, height / 3);
                frame.setContentPane(new ventanaProyectos().contenedorPrincipal);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        botonGestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;

                JFrame frame = new JFrame("Gestion");
                frame.setLocation(width / 3, height / 3);
                frame.setContentPane(new ventanaGestion().contenedorPrincipal);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}

