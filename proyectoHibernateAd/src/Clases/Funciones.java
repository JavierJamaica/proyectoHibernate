package Clases;

import Entidades.PiezasEntity;
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
                if (!p.getNombrePieza().equals("")) {
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

}
