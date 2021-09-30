<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>shopping list </title>
</head>
<body>
<form method= "post" action = "NavigationServlet">
<table>
<c:forEach items = "${requestScope.allItems}" var ="currentitem">
<tr>
<td> <input type = "radio" name = "ID" value="${currentitem.ID}"></td>
<td><strong>Name:</strong> ${currentitem.name}</td>&emsp; 
<td><strong>Assigned:</strong> ${currentitem.assigned}</td>
<td><strong>Due Date:</strong> ${currentitem.dueDate}</td>
</tr>
</c:forEach>

</table>

<input type = "submit" value = "edit" name = "doThisToItem">
<input type = "submit" value = "delete" name = "doThisToItem">
<input type = "submit" value = "add" name = "doThisToItem">

</form>


</body>
</html>