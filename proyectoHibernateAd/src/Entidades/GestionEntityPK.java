package Entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Javier Jamaica
 * 21/11/2022 - 20:20
 */
@Table(name = "gestion", schema = "proyectohibernate")

public class GestionEntityPK implements Serializable {
    @Column(name = "codProveedor", nullable = false)
    @Id
    private String codProveedor;
    @Column(name = "codPieza", nullable = false)
    @Id
    private String codPieza;
    @Column(name = "codProyecto", nullable = false)
    @Id
    private String codProyecto;

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
