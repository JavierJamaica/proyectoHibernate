package Clases;

import javax.persistence.*;

/**
 * @author Javier Jamaica
 * 21/11/2022 - 20:20
 */
@Entity
@Table(name = "piezas", schema = "proyectohibernate", catalog = "")
public class PiezasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPiezas", nullable = false)
    private int idPiezas;
    @Basic
    @Column(name = "nombrePieza", nullable = false, length = 45)
    private String nombrePieza;
    @Basic
    @Column(name = "precioPieza", nullable = false, precision = 0)
    private double precioPieza;
    @Basic
    @Column(name = "descripcionPieza", nullable = false, length = 80)
    private String descripcionPieza;

    public int getIdPiezas() {
        return idPiezas;
    }

    public void setIdPiezas(int idPiezas) {
        this.idPiezas = idPiezas;
    }

    public String getNombrePieza() {
        return nombrePieza;
    }

    public void setNombrePieza(String nombrePieza) {
        this.nombrePieza = nombrePieza;
    }

    public double getPrecioPieza() {
        return precioPieza;
    }

    public void setPrecioPieza(double precioPieza) {
        this.precioPieza = precioPieza;
    }

    public String getDescripcionPieza() {
        return descripcionPieza;
    }

    public void setDescripcionPieza(String descripcionPieza) {
        this.descripcionPieza = descripcionPieza;
    }
}
