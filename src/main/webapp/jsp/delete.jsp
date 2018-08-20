<%@ page import = "students.logic.dao.*"  %>
<%@ page import = "students.logic.dto.*"  %>
<%@ page import = "students.logic.services.*"  %>
<%@ page import = "students.web.*"  %>
<%@ page import = "java.io.*"  %>
<%@ page import = "java.util.*"  %>

<html><body>
	<article>
    		<h2>Deletion list</h2>
  	</article>
	<UL>
		<% if ((request.getAttribute("student") != null) && (request.getAttribute("subject") != null)) {
		Student st = (Student) request.getAttribute("student");
		Subject sub = (Subject) request.getAttribute("subject");
		out.println("<LI>" + "Student at number " + st.getStudentId() + " was deleted from DB" + "</LI>");
		out.println("<LI>" + "----------------------" + "</LI>");
		out.println("<LI>" + "Subject at number " + sub.getSubjectId() + " was deleted from DB" + "</LI>");
		} %>
	</UL>
</body></html>