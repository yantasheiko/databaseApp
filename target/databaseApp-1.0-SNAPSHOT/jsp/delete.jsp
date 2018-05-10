<%@ page import = "students.logic.*"  %>
<%@ page import = "students.web.*"  %>
<%@ page import = "java.io.*"  %>
<%@ page import = "java.util.*"  %>

<html><body>
	<article>
    		<h2>Deletion list</h2>
  	</article>
	<UL>
		<% if ((request.getAttribute("subject") != null) && (request.getAttribute("student") != null)) {
		Subject sub = (Subject) request.getAttribute("subject");
		Student st = (Student) request.getAttribute("student");
		out.println("<LI>" + "Subject at number " + sub.getId() + " was deleted from DB" + "</LI>");
		out.println("<LI>" + "----------------------" + "</LI>");
		out.println("<LI>" + "Student at number " + st.getId() + " was deleted from DB" + "</LI>");
		} %>
	</UL>
</body></html>