<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action = "editChoreServlet" method = "post">

<p>Chore you want to re-assign:<strong>${choreToEdit.name }</strong></p><br>

<p>Currently Assigned: <strong>${choreToEdit.assigned }</strong></p><br>

Reassign to: <input type = "text" name = "assigned"><br>
<input type= "hidden" name = "ID" value = "${choreToEdit.ID }"><br>

<input type="submit" value ="Save Edited Item"><br>



</form>

</body>
</html>