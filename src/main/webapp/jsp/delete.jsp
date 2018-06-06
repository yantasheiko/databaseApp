<%@ page import = "students.logic.*"  %>
<%@ page import = "students.web.*"  %>
<%@ page import = "java.io.*"  %>
<%@ page import = "java.util.*"  %>

<html><body>
	<article>
    		<h2>Deletion list</h2>
  	</article>
	<UL>
		<% if (request.getAttribute("student") != null) {
		Student st = (Student) request.getAttribute("student");
		out.println("<LI>" + "Student at number " + st.getId() + " was deleted from DB" + "</LI>");
		} %>
	</UL>
</body></html>