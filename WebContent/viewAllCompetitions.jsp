<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="myStyle.css">
<title>Competition List</title>
</head>
<body>
<img src="https://www.wilsontrophy.com/assets/1/18/dimregular/43120-g.png">
<h2>View All Competitions</h2>
<form method = "post" action = "modifyCompetitionServlet">
		<table>
		<tr> 
			<th> </th>
			<th>Competition Name</th>
			<th>Band ID</th> 
		</tr>
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<tr>
					<td><input type="radio" name="competitionId" value="${currentitem.competitionId}">${currentitem.competitionId}</td>
					<td>${currentitem.getCompetitionName()}</td>
					<td>${currentitem.bandId}</td> 
				</tr>
			</c:forEach>
		</table>  
		<input type = "submit" value = "Add Band to Competition" name = "doThisToCompetition">
	</form> 
<a href="index.html"> Back to Band Home</a>
</body>
</html>