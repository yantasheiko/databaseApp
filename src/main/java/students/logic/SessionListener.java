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
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.*;

public class SessionListener implements HttpSessionListener {

  public void sessionCreated(HttpSessionEvent event) {
	HttpSession session = event.getSession();
	System.out.println("Session was CREATED: " + session);
  }

  public void sessionDestroyed(HttpSessionEvent event) {
	HttpSession session = event.getSession();
	ServletContext servletContext = session.getServletContext();
	WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
	StudentService studentService = (StudentService) context.getBean("studentService");
	SubjectService subjectService = (SubjectService) context.getBean("subjectService");
	studentService.close();
	subjectService.close();
	System.out.println("Session was DELETED: " + session);
  }

}
