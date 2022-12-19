package Clases;

import Entidades.PiezasEntity;
import Entidades.ProveedoresEntity;
import Entidades.ProyectosEntity;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.PersistenceException;
import java.util.ArrayList;

/**
 * @author Javier Jamaica
 * 19/12/2022 - 13:54
 */
public class Funciones {

    public static int crearProyecto(ProyectosEntity pro) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(pro);
            tx.commit();
            session.close();
            return 0;
        } catch (HibernateException e) {
            session.close();
            return 1;
        } catch (PersistenceException e) {
            return 2;
        }
    }

    public static int crearProveedor(ProveedoresEntity prov) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(prov);
            tx.commit();
            session.close();
            return 0;
        } catch (HibernateException e) {
            session.close();
            return 1;
        } catch (PersistenceException e) {
            return 2;
        }
    }


    public static int crearPieza(PiezasEntity pieza) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(pieza);
            tx.commit();
            session.close();
            return 0;
        } catch (HibernateException e) {
            session.close();
            return 1;
        } catch (PersistenceException e) {
            return 2;
        }
    }

    public static ProyectosEntity obtenerCodProyecto(String cod) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        ProyectosEntity proyectos = new ProyectosEntity();
        try {
            proyectos = (ProyectosEntity) session.get(ProyectosEntity.class, cod);
            tx.commit();
            session.close();
            return proyectos;
        } catch (ObjectNotFoundException ignored) {

        }
        tx.commit();
        session.close();
        return new ProyectosEntity();
    }

    public static PiezasEntity obtenerCodPieza(String cod) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        PiezasEntity piezas = new PiezasEntity();
        try {
            piezas = (PiezasEntity) session.get(PiezasEntity.class, cod);
            tx.commit();
            session.close();
            return piezas;
        } catch (ObjectNotFoundException ignored) {

        }
        tx.commit();
        session.close();
        return new PiezasEntity();
    }

    public static ProveedoresEntity obtenerCodProveedor(String cod) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        ProveedoresEntity prov = new ProveedoresEntity();
        try {
            prov = (ProveedoresEntity) session.get(ProveedoresEntity.class, cod);
            tx.commit();
            session.close();
            return prov;
        } catch (ObjectNotFoundException ignored) {

        }
        tx.commit();
        session.close();
        return new ProveedoresEntity();
    }

    public static int modificarProyecto(ProyectosEntity pro) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        ProyectosEntity p;

        try {
            p = obtenerCodProyecto(pro.getIdproyectos());
        } catch (Exception e) {
            session.close();
            return 1;
        }
        if (p != null) {

            try {
                if (!pro.getNombreProyecto().equals("")) {
                    p.setNombreProyecto(pro.getNombreProyecto());
                }

                if (!pro.getCiudad().equals("")) {
                    p.setCiudad(pro.getCiudad());
                }

                session.update(p);
                tx.commit();
                session.close();
                return 0;

            } catch (Exception ignored) {
            }
            session.close();
            return 2;
        } else {
            session.close();
            return 1;
        }
    }

    public static int modificarProv(ProveedoresEntity prov) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        ProveedoresEntity p;

        try {
            p = obtenerCodProveedor(prov.getIdProveedores());
        } catch (Exception e) {
            session.close();
            return 1;
        }
        if (p != null) {

            try {
                if (!prov.getNombreProv().equals("")) {
                    p.setNombreProv(prov.getNombreProv());
                }

                if (!prov.getApellidosProv().equals("")) {
                    p.setApellidosProv(prov.getApellidosProv());
                }

                if (!prov.getDireccionPostal().equals("")) {
                    p.setDireccionPostal(prov.getDireccionPostal());
                }

                session.update(p);
                tx.commit();
                session.close();
                return 0;

            } catch (Exception ignored) {
            }
            session.close();
            return 2;
        } else {
            session.close();
            return 1;
        }
    }

    public static int modificarPieza(PiezasEntity pieza) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        PiezasEntity p;

        try {
            p = obtenerCodPieza(pieza.getIdPiezas());
        } catch (Exception e) {
            session.close();
            return 1;
        }
        if (p != null) {

            try {
                if (!pieza.getNombrePieza().equals("")) {
                    p.setNombrePieza(pieza.getNombrePieza());
                }

                if (pieza.getPrecioPieza() > 0.0) {
                    p.setPrecioPieza(pieza.getPrecioPieza());
                }

                if (!pieza.getDescripcionPieza().equals("")) {
                    p.setDescripcionPieza(pieza.getDescripcionPieza());
                }

                session.update(p);
                tx.commit();
                session.close();
                return 0;

            } catch (Exception ignored) {
            }
            session.close();
            return 2;
        } else {
            session.close();
            return 1;
        }
    }

    public static int borrarProyecto(ProyectosEntity pro) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        ProyectosEntity p;

        try {
            p = obtenerCodProyecto(pro.getIdproyectos());
        } catch (Exception e) {
            session.close();
            return 1;
        }
        if (p != null) {

            try {
                session.delete(p);
                tx.commit();
                session.close();
                return 0;
            } catch (Exception ignored) {
            }
            session.close();
            return 2;
        } else {
            session.close();
            return 1;
        }
    }

    public static int borrarProveedor(ProveedoresEntity prov) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        ProveedoresEntity p;

        try {
            p = obtenerCodProveedor(prov.getIdProveedores());
        } catch (Exception e) {
            session.close();
            return 1;
        }
        if (p != null) {

            try {
                session.delete(p);
                tx.commit();
                session.close();
                return 0;
            } catch (Exception ignored) {
            }
            session.close();
            return 2;
        } else {
            session.close();
            return 1;
        }
    }

    public static int borrarPieza(PiezasEntity pieza) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        PiezasEntity p;

        try {
            p = obtenerCodPieza(pieza.getIdPiezas());
        } catch (Exception e) {
            session.close();
            return 1;
        }
        if (p != null) {

            try {
                session.delete(p);
                tx.commit();
                session.close();
                return 0;
            } catch (Exception ignored) {
            }
            session.close();
            return 2;
        } else {
            session.close();
            return 1;
        }
    }

    public static ArrayList<PiezasEntity> verPiezas() {
        ArrayList<PiezasEntity> listaP = new ArrayList<PiezasEntity>();
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        for (Object value : session.createSQLQuery("SELECT * FROM piezas ORDER BY idPiezas;").list()) {
            Object[] tupla = (Object[]) value;
            PiezasEntity p = new PiezasEntity();
            p.setIdPiezas((String) tupla[0]);
            p.setNombrePieza((String) tupla[1]);
            p.setPrecioPieza(Double.parseDouble(tupla[2].toString()));
            p.setDescripcionPieza((String) tupla[3]);
            listaP.add(p);
        }

        tx.commit();
        session.close();
        return listaP;
    }

    public static ArrayList<ProyectosEntity> verProyectos() {
        ArrayList<ProyectosEntity> listaP = new ArrayList<ProyectosEntity>();
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        for (Object value : session.createSQLQuery("SELECT * FROM proyectos ORDER BY idProyectos;").list()) {
            Object[] tupla = (Object[]) value;
            ProyectosEntity p = new ProyectosEntity();
            p.setIdproyectos((String) tupla[0]);
            p.setNombreProyecto((String) tupla[1]);
            p.setCiudad((String) tupla[2]);
            listaP.add(p);
        }

        tx.commit();
        session.close();
        return listaP;
    }


    public static ArrayList<ProveedoresEntity> verProveedores() {
        ArrayList<ProveedoresEntity> listaPr = new ArrayList<ProveedoresEntity>();
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        for (Object value : session.createSQLQuery("SELECT * FROM proveedores ORDER BY idProveedores;").list()) {
            Object[] tupla = (Object[]) value;
            ProveedoresEntity pr = new ProveedoresEntity();
            pr.setIdProveedores((String) tupla[0]);
            pr.setNombreProv((String) tupla[1]);
            pr.setApellidosProv((String) tupla[2]);
            pr.setDireccionPostal((String) tupla[3]);
            listaPr.add(pr);
        }

        tx.commit();
        session.close();
        return listaPr;
    }




}
