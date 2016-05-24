package com.isw.dom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.isw.dao.PacienteDao;
import com.isw.model.Paciente;

public class PacienteDaoImpl implements PacienteDao, Serializable{
	
	private static final long serialVersionUID = 1L;
    private SessionFactory sessionFactory;

    
	@Override
	public void create(Paciente obj) {
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
	public boolean update(Paciente obj) {
		Transaction tx = null;
        Session session = this.sessionFactory.openSession();
        try {
            tx = session.beginTransaction();
            session.update(obj);
            session.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.flush();
            session.close();
        }
		
	}

	@Override
	public Paciente findOne(Paciente obj) {
		Paciente user = null;
        Transaction tx = null;
        Session session = this.sessionFactory.openSession();
        try {
            tx = session.beginTransaction();
            String queryString = "from Paciente where id = :id";
            Query query = session.createQuery(queryString);
            query.setLong("id", obj.getId());
            user = (Paciente) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return user;
	}

	@Override
	public List<Paciente> findAll() {
		List<Paciente> users = new ArrayList<Paciente>();
        Transaction tx = null;
        Session session = this.sessionFactory.openSession();
        try {
            tx = session.beginTransaction();
            users = session.createQuery("from Paciente").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
	}

	@Override
	public boolean delete(Paciente obj) {
		Transaction trns = null;
        Session session = this.sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            Paciente user = (Paciente) session.load(Paciente.class, new Long(obj.getId()));
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
	public void login(Paciente obj) {
		// TODO Auto-generated method stub
		
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


}
