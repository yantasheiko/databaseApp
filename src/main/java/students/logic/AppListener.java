package students.logic;

import javax.servlet.*;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.ContextLoaderListener;
import students.logic.services.*;

public class AppListener implements ServletContextListener {

	private static ApplicationContext appContext; 

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContextListener destroyed");
	}

	public void contextInitialized(final ServletContextEvent event) {
		System.out.println("ServletContextListener started");
		Logger logg = Logger.getLogger(AppListener.class.getName());
		ServletContext sc = event.getServletContext();
		appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
		StudentService studentService = (StudentService) appContext.getBean("studentService");
		SubjectService subjectService = (SubjectService) appContext.getBean("subjectService");
		sc.setAttribute("student", studentService);
		sc.setAttribute("subject", subjectService);
	}

}