<%@ page import = "students.logic.*"  %>
<%@ page import = "students.web.*"  %>
<%@ page import = "java.io.*"  %>
<%@ page import = "java.util.*"  %>

<html><head><title>Lists from Database</title></head>

<script type="text/javascript">
function ajaxAsyncRequest(reqURL){

    var xmlhttp;
    if (window.XMLHttpRequest){
        xmlhttp = new XMLHttpRequest(); //for IE7+, Firefox, Chrome, Opera, Safari
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); //for IE6, IE5
    }

    xmlhttp.open("GET", reqURL, true);

    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4) {
            if (xmlhttp.status == 200)
            {
                document.getElementById("message").innerHTML = xmlhttp.responseText;
            }
            else
            {
		//alert(xmlhttp.responseText);
                alert('Something is wrong !!');
            }
        }
    };
     
    xmlhttp.send(null);
}
</script>
<body>

<br/>
<input type="button" value="Show Server Time" onclick='ajaxAsyncRequest("database/*")'/>
<br/><br/>
	Message from server :: <span id="message"></span>

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