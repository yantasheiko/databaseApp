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
	StudentService studentService = new StudentService();
	SubjectService subjectService = new SubjectService();
	Logger logg = Logger.getLogger(SessionListener.class.getName());
	session.setAttribute("student", studentService);
	session.setAttribute("subject", subjectService);
	session.setAttribute("logger", logg);

	System.out.println("Session was CREATED: " + session);
  }

  public void sessionDestroyed(HttpSessionEvent event) {
	HttpSession session = event.getSession();
	System.out.println("Session was DELETED: " + session);
  }

}
