package Ventanas;

import javax.swing.*;
import java.awt.*;

/**
 * @author Javier Jamaica
 * 21/11/2022 - 18:59
 */
public class ventanaPrincipal {
    public JPanel contenedorPrincipal;
    private JLabel logoLabel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JLabel logo2;
    private JLabel tituloC;

    public ventanaPrincipal(){
        logoLabel.setSize(400, 180);
        ImageIcon imagen = new ImageIcon("src/Imagenes/logo1.png");
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(logoLabel.getWidth(), logoLabel.getHeight(), Image.SCALE_DEFAULT));
        logoLabel.setIcon(icon);

        logo2.setSize(149, 149);
        ImageIcon imagen2 = new ImageIcon("src/Imagenes/logo2.png");
        Icon icon2 = new ImageIcon(imagen2.getImage().getScaledInstance(logo2.getWidth(), logo2.getHeight(), Image.SCALE_DEFAULT));
        logo2.setIcon(icon2);
    }
}
