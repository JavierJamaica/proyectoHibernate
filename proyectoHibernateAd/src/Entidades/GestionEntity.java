package Entidades;

import javax.persistence.*;

/**
 * @author Javier Jamaica
 * 21/11/2022 - 20:20
 */
@Entity
@IdClass(GestionEntityPK.class)
@Table(name = "gestion", schema = "proyectohibernate")

public class GestionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    @Column(name = "codProveedor", nullable = false)
    private String codProveedor;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codPieza", nullable = false)
    private String codPieza;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codProyecto", nullable = false)
    private String codProyecto;
    @Basic
    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    public String getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(String codProveedor) {
        this.codProveedor = codProveedor;
    }

    public String getCodPieza() {
        return codPieza;
    }

    public void setCodPieza(String codPieza) {
        this.codPieza = codPieza;
    }

    public String getCodProyecto() {
        return codProyecto;
    }

    public void setCodProyecto(String codProyecto) {
        this.codProyecto = codProyecto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
