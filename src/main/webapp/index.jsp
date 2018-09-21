<%@ page import = "students.logic.*"  %>
<%@ page import = "students.web.*"  %>
<%@ page import = "java.io.*"  %>
<%@ page import = "java.util.*"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lists from Database</title>

<script src="http://code.jquery.com/jquery-latest.js">   
        </script>
        <script>
            $(document).ready(function() {                        
                $('#submit').click(function(event) {  
                    var username=$('#user').val();
                 $.get('database/*',{user:username},function(responseText) { 
                        $('#welcometext').text(responseText);         
                    });
                });
            });
        </script>
</head>

<body>

<form id="form1">
<h1>AJAX Demo using Jquery in JSP and Servlet</h1>
Enter your Name:
<input type="text" id="user"/>
<input type="button" id="submit" value="Ajax Submit"/>
 
<div id="welcometext"></div>
</form>

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