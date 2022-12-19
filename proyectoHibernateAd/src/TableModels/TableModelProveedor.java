package TableModels;

import Entidades.PiezasEntity;
import Entidades.ProveedoresEntity;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author Javier Jamaica
 * 19/12/2022 - 15:31
 */
public class TableModelProveedor extends AbstractTableModel {
    String[] cabecera = {"ID", "NOMBRE", "APELLDIDOS", "DIRECCION POSTAL"};
    private final List<ProveedoresEntity> proveedoresEntities;

    /**
     * Constructor del model empleado
     *
     * @param proveedoresEntities recibe una lista para poder mostrarla luego en una tabla
     */
    public TableModelProveedor(List<ProveedoresEntity> proveedoresEntities) {
        this.proveedoresEntities = proveedoresEntities;
    }

    /**
     * funcion para saber cuantas filas tendra la tabla
     *
     * @return devuelve el numero de empleados de la lista
     */
    @Override
    public int getRowCount() {
        return proveedoresEntities.size();
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
            case 0 -> proveedoresEntities.get(rowIndex).getIdProveedores();
            case 1 -> proveedoresEntities.get(rowIndex).getNombreProv();
            case 2 -> proveedoresEntities.get(rowIndex).getApellidosProv();
            case 3 -> proveedoresEntities.get(rowIndex).getDireccionPostal();
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
