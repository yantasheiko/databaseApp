package students.logic;

import students.logic.*;

import java.sql.*;
import java.util.*;
import java.io.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SubjectDao implements SubjectDaoImpl {

	private Session currentSession;

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }
 
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

	public Subject findById(Integer id) {
		openCurrentSession();
        	Subject subject = (Subject) getCurrentSession().get(Subject.class, id);
		closeCurrentSession();
        	return subject;
    	}

	public void update(Subject entity) {
		openCurrentSession();
		Transaction currentTransaction = getCurrentSession().beginTransaction();
        	getCurrentSession().update(entity);
		currentTransaction.commit();
		closeCurrentSession();
    	}

	public void delete(Subject entity) {
		openCurrentSession();
		Transaction currentTransaction = getCurrentSession().beginTransaction();
        	getCurrentSession().delete(entity);
		currentTransaction.commit();
		closeCurrentSession();
    	}

	public List<Subject> findAll() {
		openCurrentSession();
        	List<Subject> subjects = (List<Subject>) getCurrentSession().createQuery("from Subject").list();
		closeCurrentSession();
        	return subjects;
    	}


}
