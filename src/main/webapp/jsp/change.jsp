<%@ page import = "students.logic.*"  %>
<%@ page import = "students.web.*"  %>
<%@ page import = "java.io.*"  %>
<%@ page import = "java.util.*"  %>

<html><body>
	<article>
    		<h2>List of changes</h2>
  	</article>
	<UL>
		<% if (request.getAttribute("studentSchedule") != null) {
		Student st = (Student) request.getAttribute("studentSchedule");
		out.println("<LI>" + "Student: " + st.toString() + "</LI>");
		} %>
	</UL>
</body></html>