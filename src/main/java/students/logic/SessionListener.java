package students.logic;

import javax.servlet.http.*;
import javax.servlet.*;
import org.apache.log4j.Logger;
import students.logic.dto.*;
import students.logic.dao.*;
import students.logic.services.*;
import students.web.*;
import java.util.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SessionListener implements HttpSessionListener {

  public void sessionCreated(HttpSessionEvent event) {
	HttpSession session = event.getSession();
	System.out.println("Session was CREATED: " + session);
  }

  public void sessionDestroyed(HttpSessionEvent event) {
	HttpSession session = event.getSession();
	StudentService studentService = (StudentService) session.getAttribute("student");
	SubjectService subjectService = (SubjectService) session.getAttribute("subject");
	studentService.close();
	subjectService.close();
	System.out.println("Session was DELETED: " + session);
  }

}
