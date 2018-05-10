package students.logic;

import javax.servlet.http.*;
import javax.servlet.*;
import org.apache.log4j.Logger;
import students.logic.*;
import students.web.*;
import java.util.*;

public class SessionListener implements HttpSessionListener {

  public void sessionCreated(HttpSessionEvent event) {
	HttpSession session = event.getSession();
	StudentDao daoStudent = new MySqlStudentDao();
	SubjectDao daoSubject = new MySqlSubjectDao();
	Logger logg = Logger.getLogger(SessionListener.class.getName());
	session.setAttribute("student", daoStudent);
	session.setAttribute("subject", daoSubject);
	session.setAttribute("logger", logg);

	System.out.println("Session was CREATED: " + session);
  }

  public void sessionDestroyed(HttpSessionEvent event) {
	HttpSession session = event.getSession();
		StudentDao student = (MySqlStudentDao) session.getAttribute("student");
		SubjectDao subject = (MySqlSubjectDao) session.getAttribute("subject");
		Logger log = (Logger) session.getAttribute("logger");
		try {
			student.close();
			System.out.println("daoSt was closed");
		} catch(DAOException e) {
			log.error(e);
		}
		try {	
			subject.close();
			System.out.println("daoSub was closed");
		} catch(DAOException e) {
			log.error(e);
		}
	System.out.println("Session was DELETED: " + session);
  }

}


//System.out.println("STUDENT HASHCODE" + student.hashCode());
//System.out.println("SUBJECT HASHCODE" + subject.hashCode());
//System.out.println("STUDENT HASHCODE" + daoStudent.hashCode());
//System.out.println("SUBJECT HASHCODE" + daoSubject.hashCode());
//System.out.println("STUDENT HASHCODE" + studentMap.get(session.getId()).hashCode());
//System.out.println("SUBJECT HASHCODE" + subjectMap.get(session.getId()).hashCode());
