package students.web;
 
import java.util.*;
import java.io.*;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.*;
import java.net.URL;
import org.apache.log4j.Logger;

import students.logic.dto.*;
import students.logic.dao.*;
import students.logic.services.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.*;
import org.springframework.web.context.*;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class DataBaseServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(DataBaseServlet.class.getName());
    private static final String DB_URL = "/databaseApp/database";
    private static final String SUB_URL = "/databaseApp/database/subject";
    private static final String ST_URL = "/databaseApp/database/student";
    private static final String UP_URL = "/databaseApp/database/update";
    private static final String DEL_URL = "/databaseApp/database/delete";
    private static final String CHANGE_URL = "/databaseApp/database/change";
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private StudentService studentService;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}


   	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	HttpSession session = req.getSession();
	resp.setContentType("text/html; charset = utf-8"); 
	String url = req.getRequestURI().toString();
	resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");
        PrintWriter out = resp.getWriter();
        Date currentTime = new Date();
        String message = String.format("Currently time is %tr on %tD.",currentTime, currentTime);
	out.print(message);

	try {

			if(DB_URL.equals(url)){
				showMenu(req, resp);
			} else if(SUB_URL.equals(url)){
				showSubjectsList(req, resp); 
			} else if(ST_URL.equals(url)) {
				showStudentsList(req, resp); 
			} else if(UP_URL.equals(url)) {
				update(req, resp); 
			} else if(DEL_URL.equals(url)) {
				delete(req, resp); 
			} else if(CHANGE_URL.equals(url)) {
				change(req, resp); 
			}
	
	} catch(DAOException e) {
		logger.error(e);
      		notify(req, resp);
	}


	}

	private void showMenu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, DAOException, IOException {
		resp.sendRedirect("/databaseApp");
	}


	private void notify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/jsp/notifyError.jsp").forward(req, resp);
	}

	private void showSubjectsList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, DAOException, IOException {
		req.setAttribute("getAllSubjects", subjectService.findAll());
		getServletContext().getRequestDispatcher("/jsp/showSubjectsList.jsp").forward(req, resp);
	}

	private void showStudentsList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, DAOException, IOException {
		req.setAttribute("getAllStudents", studentService.findAll());
		getServletContext().getRequestDispatcher("/jsp/showStudentsList.jsp").forward(req, resp);
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, DAOException, IOException {
		Student st = new Student("Richard", "Prayor", 1);
		Subject sub = new Subject("Russian", 7);
		studentService.update(st);
		subjectService.update(sub);
		req.setAttribute("student", st);
		req.setAttribute("subject", sub);
		getServletContext().getRequestDispatcher("/jsp/update.jsp").forward(req, resp);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, DAOException, IOException {
		Student st = new Student();
		Subject sub = new Subject();
		st.setStudentId(5);
		sub.setSubjectId(8);
		studentService.delete(st.getStudentId());
		subjectService.delete(sub.getSubjectId());
		req.setAttribute("student", st);
		req.setAttribute("subject", sub);
		getServletContext().getRequestDispatcher("/jsp/delete.jsp").forward(req, resp);
	}

	private void change(HttpServletRequest req, HttpServletResponse resp) throws ServletException, DAOException, IOException {
		req.setAttribute("studentSchedule", studentService.findById(2));
		req.setAttribute("subjectScheduleFirst", subjectService.findById(1));
		req.setAttribute("subjectScheduleSecond", subjectService.findById(3));
		getServletContext().getRequestDispatcher("/jsp/change.jsp").forward(req, resp);
	}

}
