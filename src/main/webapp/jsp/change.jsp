<%@ page import = "students.logic.dao.*"  %>
<%@ page import = "students.logic.dto.*"  %>
<%@ page import = "students.logic.services.*"  %>
<%@ page import = "students.web.*"  %>
<%@ page import = "java.io.*"  %>
<%@ page import = "java.util.*"  %>

<html><body>
	<article>
    		<h2>List of changes</h2>
  	</article>
	<UL>
		<% if ((request.getAttribute("studentSchedule") != null) && (request.getAttribute("subjectScheduleFirst") != null)) {
		Student st = (Student) request.getAttribute("studentSchedule");
		out.println("<LI>" + "Student: " + st.toString() + "</LI>");
		out.println("<LI>" + " was assigned an : " + request.getAttribute("subjectScheduleFirst") + " at 10.00 am" + "</LI>");
		} %>
	</UL>
	<UL>
		<% if ((request.getAttribute("studentSchedule") != null) && (request.getAttribute("subjectScheduleSecond") != null)) {
		out.println("<LI>" + "Student: " + request.getAttribute("studentSchedule") + "</LI>");
		out.println("<LI>" + " was assigned an : " + request.getAttribute("subjectScheduleSecond") + " at 11.45 am" + "</LI>"); 
		} %>
	</UL>
</body></html>