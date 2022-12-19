package Ventanas;

import Clases.Funciones;
import Entidades.GestionEntity;
import Entidades.PiezasEntity;
import Entidades.ProveedoresEntity;
import Entidades.ProyectosEntity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Javier Jamaica
 * 19/12/2022 - 16:17
 */
public class crearGestion extends JFrame {
    private JPanel contenedorPrincipal;
    private JComboBox<ProveedoresEntity> prov;
    private JComboBox<PiezasEntity> pieza;
    private JComboBox<ProyectosEntity> proyecto;
    private JButton crear;
    private JButton atras;
    private JSpinner spinner1;

    static ArrayList<ProveedoresEntity> listaProveedores;
    static ArrayList<ProyectosEntity> listaProyectos;
    static ArrayList<PiezasEntity> listaPiezas;

    public crearGestion() {
        setContentPane(contenedorPrincipal);
        initCombox();

        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        crear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cant = (int) spinner1.getValue();

                if (cant > 0) {
                    String[] codigos = new String[3];
                    codigos[0] = prov.getSelectedItem().toString();
                    codigos[1] = pieza.getSelectedItem().toString();
                    codigos[2] = proyecto.getSelectedItem().toString();
                    GestionEntity g = new GestionEntity();
                    g.setCodProveedor(codigos[0]);
                    g.setCodPieza(codigos[1]);
                    g.setCodProyecto(codigos[2]);
                    g.setCantidad(cant);
                    switch (Funciones.crearGestion(g)) {
                        case 0 -> JOptionPane.showMessageDialog(null, "Se ha insertado la gestion correctamente");
                        case 1 ->
                                JOptionPane.showMessageDialog(null, "Error al insertar la gestion", "Error insertar", JOptionPane.ERROR_MESSAGE);
                        case 2 ->
                                JOptionPane.showMessageDialog(null, "Ya existe ese id", "Codigos duplicados", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "la cantidad tiene que ser mayor que 0", "Error", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
    }

    public void initCombox() {

        listaProyectos = Funciones.verProyectos();
        String[] codigosFuncionesProy = new String[listaProyectos.size()];
        for (int i = 0; i < listaProyectos.size(); i++) {
            codigosFuncionesProy[i] = listaProyectos.get(i).getIdproyectos();
        }
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel(codigosFuncionesProy);
        proyecto.setModel(defaultComboBoxModel);

        listaProveedores = Funciones.verProveedores();
        String[] codigosFuncionesProveedores = new String[listaProveedores.size()];
        for (int i = 0; i < listaProveedores.size(); i++) {
            codigosFuncionesProveedores[i] = listaProveedores.get(i).getIdProveedores();
        }
        DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel(codigosFuncionesProveedores);
        prov.setModel(defaultComboBoxModel2);

        listaPiezas = Funciones.verPiezas();
        String[] codigosFuncionesPiezas = new String[listaPiezas.size()];
        for (int i = 0; i < listaPiezas.size(); i++) {
            codigosFuncionesPiezas[i] = listaPiezas.get(i).getIdPiezas();
        }
        DefaultComboBoxModel defaultComboBoxModel3 = new DefaultComboBoxModel(codigosFuncionesPiezas);
        pieza.setModel(defaultComboBoxModel3);
    }
}

