package com.isw.dom;

import java.io.Serializable;
import java.util.List;

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
        session.persist(obj);
        tx.commit();
        session.close();
		
	}

	@Override
	public void update(Operador obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Operador findOne(Operador obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Operador> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Operador obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void login(Operador obj) {
		// TODO Auto-generated method stub
		
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
