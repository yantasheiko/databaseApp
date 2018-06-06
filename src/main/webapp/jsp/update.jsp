<%@ page import = "students.logic.*"  %>
<%@ page import = "students.web.*"  %>
<%@ page import = "java.io.*"  %>
<%@ page import = "java.util.*"  %>

<html><body>
	<article>
    		<h2>Update list</h2>
  	</article>
	<UL>
	<% if (request.getAttribute("student") != null) {
	Student st = (Student) request.getAttribute("student");
	out.println("Student at number " + st.getId() + " was updated in DB with following details: " + "<tr><td>" + st.getName() + "</td>" + " " + "<td>" + st.getSurname() + "</td></tr>");
	} %>
	</UL>
</body></html>