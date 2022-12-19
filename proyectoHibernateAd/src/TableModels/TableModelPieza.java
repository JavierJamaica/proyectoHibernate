package TableModels;

import Entidades.PiezasEntity;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author Javier Jamaica
 * 19/12/2022 - 14:42
 */
public class TableModelPieza extends AbstractTableModel {
    String[] cabecera = {"ID", "NOMBRE", "PRECIO", "DESCRIPCION"};
    private final List<PiezasEntity> piezasEntities;

    /**
     * Constructor del model empleado
     *
     * @param piezasEntities recibe una lista para poder mostrarla luego en una tabla
     */
    public TableModelPieza(List<PiezasEntity> piezasEntities) {
        this.piezasEntities = piezasEntities;
    }

    /**
     * funcion para saber cuantas filas tendra la tabla
     *
     * @return devuelve el numero de empleados de la lista
     */
    @Override
    public int getRowCount() {
        return piezasEntities.size();
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
            case 0 -> piezasEntities.get(rowIndex).getIdPiezas();
            case 1 -> piezasEntities.get(rowIndex).getNombrePieza();
            case 2 -> piezasEntities.get(rowIndex).getPrecioPieza();
            case 3 -> piezasEntities.get(rowIndex).getDescripcionPieza();
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
