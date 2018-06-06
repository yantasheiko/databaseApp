package students.web;
 
import java.util.*;
import java.io.*;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.*;
import java.net.URL;
import org.apache.log4j.Logger;

import students.logic.*;
import students.web.*;

public class DataBaseServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(DataBaseServlet.class.getName());
    private static final String DB_URL = "/databaseApp/database";
    private static final String SUB_URL = "/databaseApp/database/subject";
    private static final String ST_URL = "/databaseApp/database/student";
    private static final String UP_URL = "/databaseApp/database/update";
    private static final String DEL_URL = "/databaseApp/database/delete";
    private static final String CHANGE_URL = "/databaseApp/database/change";

   	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	HttpSession session = req.getSession();
	resp.setContentType("text/html; charset = utf-8");
	String url = req.getRequestURI().toString();

	try {

			if(DB_URL.equals(url)){
				showMenu(req, resp);
			} else if(SUB_URL.equals(url)){
			//	showSubjectsList(req, resp, session); 
			} else if(ST_URL.equals(url)) {
				showStudentsList(req, resp, session); 
			} else if(UP_URL.equals(url)) {
				update(req, resp, session); 
			} else if(DEL_URL.equals(url)) {
				delete(req, resp, session); 
			} else if(CHANGE_URL.equals(url)) {
				change(req, resp, session); 
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

	//private void showSubjectsList(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException, DAOException, IOException {
	//	SubjectDao subDao = (MySqlSubjectDao) session.getAttribute("subject");
	//	req.setAttribute("getAllSubjects", subDao.getAll());
	//	getServletContext().getRequestDispatcher("/jsp/showSubjectsList.jsp").forward(req, resp);
	//}

	private void showStudentsList(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException, DAOException, IOException {
		StudentService studentService = (StudentService) session.getAttribute("student");
		req.setAttribute("getAllStudents", studentService.findAll());
		getServletContext().getRequestDispatcher("/jsp/showStudentsList.jsp").forward(req, resp);
	}

	private void update(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException, DAOException, IOException {
		StudentService studentService = (StudentService) session.getAttribute("student");
		Student st = new Student("Richard", "Prayor", 1);
		studentService.update(st);
		req.setAttribute("student", st);
		getServletContext().getRequestDispatcher("/jsp/update.jsp").forward(req, resp);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException, DAOException, IOException {
		StudentService studentService = (StudentService) session.getAttribute("student");
		Student st = new Student();
		st.setId(5);
		studentService.delete(st.getId());
		req.setAttribute("student", st);
		getServletContext().getRequestDispatcher("/jsp/delete.jsp").forward(req, resp);
	}

	private void change(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException, DAOException, IOException {
		StudentService studentService = (StudentService) session.getAttribute("student");
		req.setAttribute("studentSchedule", studentService.findById(2));
		getServletContext().getRequestDispatcher("/jsp/change.jsp").forward(req, resp);
	}

}
