<%@ page import = "students.logic.dao.*"  %>
<%@ page import = "students.logic.dto.*"  %>
<%@ page import = "students.logic.services.*"  %>
<%@ page import = "students.web.*"  %>
<%@ page import = "java.io.*"  %>
<%@ page import = "java.util.*"  %>


<html><body>
	<article>
    		<h2>List of subjects</h2>
  	</article>

	<table>
	<tr><th>Subject</th></tr> 
        <% if (request.getAttribute("getAllSubjects") != null) {
	Subject sub = new Subject();
	List<Subject> l = (List<Subject>) request.getAttribute("getAllSubjects");
	Iterator<Subject> i = l.iterator();
	for (int a = 0; i.hasNext();) {
	sub = i.next();
	out.println("<tr><td>" + sub.getSubject() + "</td></tr>");
	}
	} %>
	</table>  
</body></html>