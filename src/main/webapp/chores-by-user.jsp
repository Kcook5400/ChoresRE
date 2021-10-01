<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chores Lists</title>
</head>
<body>

<form method = "post" action = "listnavigationServlet">
<table>
<c:forEach items = "${requestScope.allLists}" var = "currentlist">
<tr>
<td><input type="radio" name = "id" value = "${currentlist.id}"></td>
<td><h2> ${currentlist.listName}</h2></td></tr>
<tr><td colspan = "3"> Due Date: ${currentlist.dueDate}</td></tr> 
<tr> <td colspan="3">Assignee: ${currentlist.assignee.assigneeName}</td></tr>
<c:forEach var = "listVal" items = "${currentlist.listOfitems}">
<tr><td></td><td colspan="4">Chore: ${listVal.name}</td></tr>
<tr><td></td><td colspan="4"> Chore Due Date: ${listVal.dueDate}</td></tr>
</c:forEach>
</c:forEach>
</table>
<input type= "submit" value = "edit" name = "doThisToList">
<input type= "submit" value = "delete" name = "doThisToList">
<input type= "submit" value = "add" name = "doThisToList">
</form>
<a href="addItemsForListServlet"> Create new List</a>
<a href="index.html"> Insert a new item </a>

</body>
</html>