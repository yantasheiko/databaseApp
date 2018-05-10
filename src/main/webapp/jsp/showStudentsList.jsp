<%@ page import = "students.logic.*"  %>
<%@ page import = "students.web.*"  %>
<%@ page import = "java.io.*"  %>
<%@ page import = "java.util.*"  %>

<html><body>
		<article>
    		 	<h2>List of students</h2>
  		</article>

		<table>
		<tr><th>Name</th><th>Surname</th></tr>  
		<% if (request.getAttribute("getAllStudents") != null) {
		Student st = new Student();
		List<Student> list = (List<Student>) request.getAttribute("getAllStudents");
	   	Iterator<Student> i = list.iterator();
         	for (int a = 0; i.hasNext();) {
		st = i.next();
		out.println("<tr><td>" + st.getName() + "</td><td>" + st.getSurname() + "</td></tr>"); 
            	}
		} %>
		</table>  
</body></html>