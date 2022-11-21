package Ventanas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 21/11/2022 - 21:14
 */
public class ventanaGestion {
    public JPanel contenedorPrincipal;
    private JButton crearPedidoButton;
    private JButton calculosButton;
    private JButton estadisticasButton;
    private JButton buscarPedidoButton;
    private JButton atrasButton;

    public ventanaGestion(){

        crearPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        calculosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buscarPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        estadisticasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Gestion");
                frame.setContentPane(new ventanaGestion().contenedorPrincipal);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.dispose();
            }
        });
    }

}
