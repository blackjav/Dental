package com.isw.dom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.isw.dao.OperadorDao;
import com.isw.model.Operador;

public class OperadorDaoImpl implements Serializable, OperadorDao{

	private static final long serialVersionUID = 1L;
    private SessionFactory sessionFactory;

    
	@Override
	public void create(Operador obj) {
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(obj);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
                System.out.println(e);
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
		
	}

	@Override
	public void update(Operador obj) {
		Transaction tx = null;
        Session session = this.sessionFactory.openSession();
        try {
            tx = session.beginTransaction();
            session.update(obj);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
		
	}

	@Override
	public Operador findOne(Operador obj) {
		Operador user = null;
        Transaction tx = null;
        Session session = this.sessionFactory.openSession();
        try {
            tx = session.beginTransaction();
            String queryString = "from Operador where id = :id";
            Query query = session.createQuery(queryString);
            query.setLong("id", obj.getId());
            user = (Operador) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return user;
	}

	@Override
	public List<Operador> findAll() {
		List<Operador> users = new ArrayList<Operador>();
        Transaction tx = null;
        Session session = this.sessionFactory.openSession();
        try {
            tx = session.beginTransaction();
            users = session.createQuery("from Operador").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
	}

	@Override
	public boolean delete(Operador obj) {
		Transaction trns = null;
        Session session = this.sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            Operador user = (Operador) session.load(Operador.class, new Long(obj.getId()));
            session.delete(user);
            session.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.flush();
            session.close();
        }
	}

	@Override
	public void login(Operador obj) {
		// TODO Auto-generated method stub
		
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
