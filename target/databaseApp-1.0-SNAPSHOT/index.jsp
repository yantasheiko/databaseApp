<%@ page import = "students.logic.*"  %>
<%@ page import = "students.web.*"  %>
<%@ page import = "java.io.*"  %>
<%@ page import = "java.util.*"  %>

<html><head><title>Lists from Database</title></head><body>
<header>
    	<h1>Lists of students and subjects from database</h1>
</header>
<article>
    	<h2>Welcome!</h2>
</article>
<MENU>
	<UL>
		<LI><A HREF="/databaseApp/database/subject">Subject List</A></LI>
	<P>
		<LI><A HREF="/databaseApp/database/student">Student List</A></LI>
	<P>
		<LI><A HREF="/databaseApp/database/update">Update List</A></LI>
	<P>
		<LI><A HREF="/databaseApp/database/delete">Delete List</A></LI>
	<P>
		<LI><A HREF="/databaseApp/database/change">Change List</A></LI>
	<UL>
</MENU>
<footer>
	Copyright Yan Tasheika
</footer>
</body></html>