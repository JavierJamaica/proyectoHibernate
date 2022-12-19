package TableModels;

import Entidades.GestionEntity;
import Entidades.PiezasEntity;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author Javier Jamaica
 * 19/12/2022 - 17:33
 */
public class TableModelGestion extends AbstractTableModel {
    String[] cabecera = {"ID PROVEEDOR", "ID PIEZA", "ID PROYECTO", "CANTIDAD"};
    private final List<GestionEntity> gestionEntities;

    /**
     * Constructor del model empleado
     *
     * @param gestionEntities recibe una lista para poder mostrarla luego en una tabla
     */
    public TableModelGestion(List<GestionEntity> gestionEntities) {
        this.gestionEntities = gestionEntities;
    }

    /**
     * funcion para saber cuantas filas tendra la tabla
     *
     * @return devuelve el numero de empleados de la lista
     */
    @Override
    public int getRowCount() {
        return gestionEntities.size();
    }

    /**
     * Mediante el array cabecera asigna las columnas de la tabla
     *
     * @return devuelve el numero de columnas de la tabla
     */
    @Override
    public int getColumnCount() {
        return cabecera.length;
    }

    /**
     * Funcion para escribir los datos
     *
     * @param rowIndex    las filas que seran escritas
     * @param columnIndex las columnas que seran escritas
     * @return
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> gestionEntities.get(rowIndex).getCodProveedor();
            case 1 -> gestionEntities.get(rowIndex).getCodPieza();
            case 2 -> gestionEntities.get(rowIndex).getCodProyecto();
            case 3 -> gestionEntities.get(rowIndex).getCantidad();
            default -> "";
        };
    }

    /**
     * @param column the column being queried
     * @return
     */
    @Override
    public String getColumnName(int column) {
        return cabecera[column];
    }
}
