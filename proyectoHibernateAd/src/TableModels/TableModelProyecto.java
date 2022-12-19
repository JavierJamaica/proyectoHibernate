package TableModels;

import Entidades.ProveedoresEntity;
import Entidades.ProyectosEntity;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author Javier Jamaica
 * 19/12/2022 - 16:03
 */
public class TableModelProyecto extends AbstractTableModel {

    String[] cabecera = {"ID", "NOMBRE", "CIUDAD"};
    private final List<ProyectosEntity> proyectosEntities;

    /**
     * Constructor del model empleado
     *
     * @param proyectosEntities recibe una lista para poder mostrarla luego en una tabla
     */
    public TableModelProyecto(List<ProyectosEntity> proyectosEntities) {
        this.proyectosEntities = proyectosEntities;
    }

    /**
     * funcion para saber cuantas filas tendra la tabla
     *
     * @return devuelve el numero de empleados de la lista
     */
    @Override
    public int getRowCount() {
        return proyectosEntities.size();
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
            case 0 -> proyectosEntities.get(rowIndex).getIdproyectos();
            case 1 -> proyectosEntities.get(rowIndex).getNombreProyecto();
            case 2 -> proyectosEntities.get(rowIndex).getCiudad();
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
