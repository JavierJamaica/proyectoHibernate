package Entidades;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Javier Jamaica
 * 21/11/2022 - 20:20
 */
public class GestionEntityPK implements Serializable {
    @Column(name = "codProveedor", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codProveedor;
    @Column(name = "codPieza", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codPieza;
    @Column(name = "codProyecto", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codProyecto;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GestionEntityPK that = (GestionEntityPK) o;
        return codProveedor == that.codProveedor && codPieza == that.codPieza && codProyecto == that.codProyecto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codProveedor, codPieza, codProyecto);
    }
}
