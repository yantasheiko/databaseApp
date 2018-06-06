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

    private Transaction currentTransaction;

    //public MySqlStudentDao() {
    //}

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
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

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

	public Student findById(Integer id) {
        	Student student = (Student) getCurrentSession().get(Student.class, id);
        	return student;
    	}

	public List<Student> findAll() {
        	List<Student> students = (List<Student>) getCurrentSession().createQuery("from Student").list();
        	return students;
    	}

	public void update(Student entity) {
        	getCurrentSession().update(entity);
    	}

	public void delete(Student entity) {
        	getCurrentSession().delete(entity);
    	}

}

