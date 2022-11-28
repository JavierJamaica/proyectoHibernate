package Entidades;

import javax.persistence.*;

/**
 * @author Javier Jamaica
 * 21/11/2022 - 20:20
 */
@Entity
@Table(name = "proveedores", schema = "proyectohibernate", catalog = "")
public class ProveedoresEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idProveedores", nullable = false)
    private int idProveedores;
    @Basic
    @Column(name = "nombreProv", nullable = false, length = 45)
    private String nombreProv;
    @Basic
    @Column(name = "apellidosProv", nullable = false, length = 45)
    private String apellidosProv;
    @Basic
    @Column(name = "direccionPostal", nullable = false, length = 45)
    private String direccionPostal;

    public int getIdProveedores() {
        return idProveedores;
    }

    public void setIdProveedores(int idProveedores) {
        this.idProveedores = idProveedores;
    }

    public String getNombreProv() {
        return nombreProv;
    }

    public void setNombreProv(String nombreProv) {
        this.nombreProv = nombreProv;
    }

    public String getApellidosProv() {
        return apellidosProv;
    }

    public void setApellidosProv(String apellidosProv) {
        this.apellidosProv = apellidosProv;
    }

    public String getDireccionPostal() {
        return direccionPostal;
    }

    public void setDireccionPostal(String direccionPostal) {
        this.direccionPostal = direccionPostal;
    }
}
