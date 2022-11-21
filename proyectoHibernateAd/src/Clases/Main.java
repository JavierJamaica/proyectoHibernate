package Clases;

import Ventanas.ventanaPrincipal;

import javax.swing.*;
import java.awt.*;

/**
 * @author Javier Jamaica
 * 21/11/2022 - 18:58
 */
public class Main {
    public static void main(String[] args) {
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;

        JFrame frame = new JFrame("Principal");
        frame.setLocation( width /3 , height/3 );
        frame.setContentPane(new ventanaPrincipal().contenedorPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
