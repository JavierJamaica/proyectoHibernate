package Clases;

import javax.persistence.*;

/**
 * @author Javier Jamaica
 * 21/11/2022 - 20:20
 */
@Entity
@Table(name = "proyectos", schema = "proyectohibernate", catalog = "")
public class ProyectosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idproyectos", nullable = false)
    private int idproyectos;
    @Basic
    @Column(name = "nombreProyecto", nullable = false, length = 45)
    private String nombreProyecto;
    @Basic
    @Column(name = "ciudad", nullable = false, length = 45)
    private String ciudad;

    public int getIdproyectos() {
        return idproyectos;
    }

    public void setIdproyectos(int idproyectos) {
        this.idproyectos = idproyectos;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
