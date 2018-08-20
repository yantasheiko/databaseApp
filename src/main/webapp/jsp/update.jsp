<%@ page import = "students.logic.dao.*"  %>
<%@ page import = "students.logic.dto.*"  %>
<%@ page import = "students.logic.services.*"  %>
<%@ page import = "students.web.*"  %>
<%@ page import = "java.io.*"  %>
<%@ page import = "java.util.*"  %>

<html><body>
	<article>
    		<h2>Update list</h2>
  	</article>
	<UL>
	<% if ((request.getAttribute("student") != null) && (request.getAttribute("subject") != null)) {
	Student st = (Student) request.getAttribute("student");
	Subject sub = (Subject) request.getAttribute("subject");
	out.println("Student at number " + st.getStudentId() + " was updated in DB with following details: " + "<tr><td>" + st.getName() + "</td>" + " " + "<td>" + st.getSurname() + "</td></tr>");
	out.println("<P>");
	out.println("----------------------");
	out.println("<P>");
	out.println("Subject at number: " + sub.getSubjectId() + " was updated in the DB with following details: " + sub.getSubject());
	} %>
	</UL>
</body></html>