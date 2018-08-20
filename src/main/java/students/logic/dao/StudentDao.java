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

public class StudentDao implements StudentDaoImpl {

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

	public Student findById(Integer id) {
		currentSession = getSessionFactory().openSession();
        	Student student = (Student) getCurrentSession().get(Student.class, id);
		currentSession.close();
        	return student;
    	}

	public List<Student> findAll() {
		currentSession = getSessionFactory().openSession();
        	List<Student> students = (List<Student>) getCurrentSession().createQuery("from Student").list();
		currentSession.close();
        	return students;
    	}

	public void update(Student entity) {
		currentSession = getSessionFactory().openSession();
		Transaction currentTransaction = getCurrentSession().beginTransaction();
        	getCurrentSession().update(entity);
		currentTransaction.commit();
		currentSession.close();
    	}

	public void delete(Student entity) {
		currentSession = getSessionFactory().openSession();
		Transaction currentTransaction = getCurrentSession().beginTransaction();
        	getCurrentSession().delete(entity);
		currentTransaction.commit();
		currentSession.close();
    	}

	public void close(){
		sessionFactory.close();
	}

}

