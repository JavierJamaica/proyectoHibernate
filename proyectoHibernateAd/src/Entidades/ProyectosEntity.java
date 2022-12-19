package Entidades;

import javax.persistence.*;

/**
 * @author Javier Jamaica
 * 21/11/2022 - 20:20
 */
@Entity
@Table(name = "proyectos", schema = "proyectohibernate")

public class ProyectosEntity {
    @Id
    @Column(name = "idproyectos", nullable = false)
    private String idproyectos;
    @Basic
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombreProyecto;
    @Basic
    @Column(name = "ciudad", nullable = false, length = 45)
    private String ciudad;

    public String getIdproyectos() {
        return idproyectos;
    }

    public void setIdproyectos(String idproyectos) {
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
