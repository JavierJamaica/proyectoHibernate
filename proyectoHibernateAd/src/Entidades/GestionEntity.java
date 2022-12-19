package Entidades;

import javax.persistence.*;

/**
 * @author Javier Jamaica
 * 21/11/2022 - 20:20
 */
@Entity
@IdClass(GestionEntityPK.class)
public class GestionEntity {
    @Id
    @Column(name = "codProveedor", nullable = false)
    private int codProveedor;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codPieza", nullable = false)
    private int codPieza;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codProyecto", nullable = false)
    private int codProyecto;
    @Basic
    @Column(name = "cantidad", nullable = false, precision = 0)
    private float cantidad;

    public int getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(int codProveedor) {
        this.codProveedor = codProveedor;
    }

    public int getCodPieza() {
        return codPieza;
    }

    public void setCodPieza(int codPieza) {
        this.codPieza = codPieza;
    }

    public int getCodProyecto() {
        return codProyecto;
    }

    public void setCodProyecto(int codProyecto) {
        this.codProyecto = codProyecto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
}
