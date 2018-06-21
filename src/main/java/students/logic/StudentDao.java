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


public class StudentDao implements StudentDaoImpl {

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

	public Student findById(Integer id) {
		openCurrentSession();
        	Student student = (Student) getCurrentSession().get(Student.class, id);
		closeCurrentSession();
        	return student;
    	}

	public List<Student> findAll() {
		openCurrentSession();
        	List<Student> students = (List<Student>) getCurrentSession().createQuery("from Student").list();
		closeCurrentSession();
        	return students;
    	}

	public void update(Student entity) {
		openCurrentSession();
		Transaction currentTransaction = getCurrentSession().beginTransaction();
        	getCurrentSession().update(entity);
		currentTransaction.commit();
		closeCurrentSession();
    	}

	public void delete(Student entity) {
		openCurrentSession();
		Transaction currentTransaction = getCurrentSession().beginTransaction();
        	getCurrentSession().delete(entity);
		currentTransaction.commit();
		closeCurrentSession();
    	}

}

