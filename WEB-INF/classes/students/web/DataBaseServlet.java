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
				showSubjectsList(req, resp, session); 
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

	private void showSubjectsList(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException, DAOException, IOException {
		SubjectDao subDao = (MySqlSubjectDao) session.getAttribute("subject");
		req.setAttribute("getAllSubjects", subDao.getAll());
		getServletContext().getRequestDispatcher("/jsp/showSubjectsList.jsp").forward(req, resp);
	}

	private void showStudentsList(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException, DAOException, IOException {
		StudentDao stDao = (MySqlStudentDao) session.getAttribute("student");
		req.setAttribute("getAllStudents", stDao.getAll());
		getServletContext().getRequestDispatcher("/jsp/showStudentsList.jsp").forward(req, resp);
	}

	private void update(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException, DAOException, IOException {
		StudentDao stDao = (MySqlStudentDao) session.getAttribute("student");
		SubjectDao subDao = (MySqlSubjectDao) session.getAttribute("subject");
		Subject sub = new Subject("Russian", 8);
		Student st = new Student("Richard", "Prayor", 1);
		subDao.update(sub);
		stDao.update(st);
		req.setAttribute("subject",sub);
		req.setAttribute("student", st);
		getServletContext().getRequestDispatcher("/jsp/update.jsp").forward(req, resp);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException, DAOException, IOException {
		StudentDao stDao = (MySqlStudentDao) session.getAttribute("student");
		SubjectDao subDao = (MySqlSubjectDao) session.getAttribute("subject");
		Subject sub = new Subject();
		Student st = new Student();
		st.setId(5);
		sub.setId(8);
		stDao.delete(st);
		subDao.delete(sub);
		req.setAttribute("subject", sub);
		req.setAttribute("student", st);
		getServletContext().getRequestDispatcher("/jsp/delete.jsp").forward(req, resp);
	}

	private void change(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException, DAOException, IOException {
		StudentDao stDao = (MySqlStudentDao) session.getAttribute("student");
		SubjectDao subDao = (MySqlSubjectDao) session.getAttribute("subject");
		req.setAttribute("studentSchedule", stDao.schedule(2));
		req.setAttribute("subjectScheduleFirst", subDao.schedule(1));
		req.setAttribute("subjectScheduleSecond", subDao.schedule(3));
		getServletContext().getRequestDispatcher("/jsp/change.jsp").forward(req, resp);
	}

}




	//private void showMenu(HttpServletRequest req, HttpServletResponse resp,) throws ServletException, DAOException {
	//		PrintWriter pw = (PrintWriter) req.getAttribute("writer");
	//		pw.println("<HTML><HEAD><TITLE>Lists from Database</TITLE></HEAD>");
        //		pw.println("<BODY>");

	//		pw.println("<header>");
    	//		pw.println("<h1>Lists of students and subjects from database</h1>");
  	//		pw.println("</header>");
	//		pw.println("<article>");
    	//		pw.println("<h2>Welcome!</h2>");
  	//		pw.println("</article>");

	//			pw.println("<MENU>");
	//			pw.println("<UL>");
	//			pw.println("<LI><A HREF=\"/databaseApp/database/subject\">Subject List</A></LI>");
	//			pw.println("<P>");
	//			pw.println("<LI><A HREF=\"/databaseApp/database/student\">Student List</A></LI>");
	//			pw.println("<P>");
	//			pw.println("<LI><A HREF=\"/databaseApp/database/update\">Update List</A></LI>");
	//			pw.println("<P>");
	//			pw.println("<LI><A HREF=\"/databaseApp/database/delete\">Delete List</A></LI>");
	//			pw.println("<P>");
	//			pw.println("<LI><A HREF=\"/databaseApp/database/change\">Change List</A></LI>");
	//			pw.println("<UL>");
	//			pw.println("</MENU>");

	//		pw.println("<footer>");
    	//		pw.println("Copyright Yan Tasheika");
  	//		pw.println("</footer>");
	//		
	//		pw.println("</BODY></HTML>");
	//}

//}






				//pw.println("<form action=\"/databaseApp/database/subject\" method=\"GET\">"); 
        			//pw.println("<B>Subject list:</B>");
        			//pw.println("<input type=\"submit\" value=\"view\" />");
        			//pw.println("</form>");

				//pw.println("<form action=\"/databaseApp/database/student\" method=\"GET\">"); 
        			//pw.println("<B>Student list:</B>");
        			//pw.println("<input type=\"submit\" value=\"view\" />");
        			//pw.println("</form>");

				//pw.println("<form action=\"/databaseApp/database/update\" method=\"GET\">"); 
        			//pw.println("<B>Update list:</B>");
        			//pw.println("<input type=\"submit\" value=\"view\" />");
        			//pw.println("</form>");

				//pw.println("<form action=\"/databaseApp/database/delete\" method=\"GET\">"); 
        			//pw.println("<B>Delete list:</B>");
        			//pw.println("<input type=\"submit\" value=\"view\" />");
        			//pw.println("</form>");
				
				//pw.println("<form action=\"/databaseApp/database/change\" method=\"GET\">"); 
        			//pw.println("<B>Change list:</B>");
        			//pw.println("<input type=\"submit\" value=\"view\" />");
        			//pw.println("</form>");


	//StringBuffer url = req.getRequestURL();
			//session.setAttribute("URL", url);

			//pw.println("My session counter: ");

			//pw.println(String.valueOf(prepareSessionCounter(session)));

			//pw.println("<br> Creation Time : " + new Date(session.getCreationTime()));

			//pw.println("<br> Time of last access : " + new Date(session.getLastAccessedTime()));

			//pw.println("<br> session ID : " + session.getId());

			//pw.println("<br> isNew? : " + session.isNew());

			//pw.println("<br> Your URL: " + url);

			//pw.println("<br>Get max inactive interval : " + session.getMaxInactiveInterval());
			//pw.println("<P>");

		/////////////////////////////////session//////////////////////////


    //private void performTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//try {
			//	daoSt.close();
			//} catch(DAOException e) {
			//	logger.error(e);
			//}
			//try {
			//	daoSub.close();
			//} catch(DAOException e) {
			//	logger.error(e);
			//}
    //	HttpSession session = null;
	//if (flag) {
		//session = req.getSession();
		//int timeLive = 30*60;
		//session.setMaxInactiveInterval(timeLive);
		//flag = false;
	//} else {
	//	session = req.getSession(false);
	//}
	//SessionLogic.printToBrowser(req, resp, session);
    //}
//}



	//String param = getServletConfig().getInitParameter("servletPart");
	//if(param.equals("subject")){
	//return;
	//}

	//pw.println("<form action=\"/databaseApp/subject\" method=\"GET\">"); 
        //pw.println("<p>GRISHA RULEZ:</p>");
        //pw.println("<input type=\"submit\" value=\"Send\" />");
        //pw.println("</form>");
	//RequestDispatcher dispatcher = req.getRequestDispatcher("/subject");
        //String path = req.getPathInfo();
        //req.setAttribute("path", path);
        //dispatcher.forward(req, resp);





	//e.printStackTrace();

	//String filename = "C://apachetomcat/webapps/databaseApp/web-inf/classes/temp.out";

	//try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
	//	oos.writeObject(sbb);
	//} catch (IOException e) {
	//	e.printStackTrace();
	//}

	//try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
	//	sbb = (Subject) ois.readObject();
	//} catch (ClassNotFoundException e) {
	//	e.printStackTrace();
	//} catch (FileNotFoundException e) {
	//	e.printStackTrace();
	//} catch (IOException e) {
	//	e.printStackTrace();
	//}