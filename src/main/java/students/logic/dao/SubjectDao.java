package students.logic.dao;

import students.logic.dto.*;

import java.sql.*;
import java.util.*;
import java.io.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public class SubjectDao implements SubjectDaoImpl {

	private Session currentSession;
	private static SessionFactory sessionFactory;

    private static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        	this.sessionFactory = sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }
 
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

	public Subject findById(Integer id) {
		currentSession = getSessionFactory().openSession();
        	Subject subject = (Subject) getCurrentSession().get(Subject.class, id);
		currentSession.close();
        	return subject;
    	}

	public void update(Subject entity) {
		currentSession = getSessionFactory().openSession();
		Transaction currentTransaction = getCurrentSession().beginTransaction();
        	getCurrentSession().update(entity);
		currentTransaction.commit();
		currentSession.close();
    	}

	public void delete(Subject entity) {
		currentSession = getSessionFactory().openSession();
		Transaction currentTransaction = getCurrentSession().beginTransaction();
        	getCurrentSession().delete(entity);
		currentTransaction.commit();
		currentSession.close();
    	}

	public List<Subject> findAll() {
		currentSession = getSessionFactory().openSession();
        	List<Subject> subjects = (List<Subject>) getCurrentSession().createQuery("from Subject").list();
		currentSession.close();
        	return subjects;
    	}

	public void close(){
		sessionFactory.close();
	}


}
