<%@ page import = "students.logic.*"  %>
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
		out.println("<LI>" + "Student at number " + st.getId() + " was deleted from DB" + "</LI>");
		out.println("<LI>" + "----------------------" + "</LI>");
		out.println("<LI>" + "Subject at number " + sub.getId() + " was deleted from DB" + "</LI>");
		} %>
	</UL>
</body></html>