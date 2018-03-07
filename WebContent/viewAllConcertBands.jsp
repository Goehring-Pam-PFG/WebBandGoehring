<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="myStyle.css">
<title>List of Bands</title>
</head>
<body>
<img src="http://hddfhm.com/images/concert-band-clipart-18.png">
<h2>View All Concert Bands</h2>
<form method = "post" action = "modifyBandServlet">
	<table>

		<tr>
			<th>Band Id</th>
			<th>Band Name</th>
			<th>Band Location</th>
			<th>Number of Members</th>
			<th>Cost Of Participation</th>
		</tr>

		<c:forEach items="${requestScope.allBands}" var="currentBand">
			<tr>
				<td><input type="radio" name="id" value="${currentBand.bandId}">${currentBand.bandId}</td>
				<td>${currentBand.bandName}</td>
				<td>${currentBand.bandLocation}</td>
				<td>${currentBand.numOfMembers}</td>
				<td>${currentBand.costOfParticipation}</td>
			</tr>
		</c:forEach>

	</table>
	<input type="submit" value="Edit Selected Band" name="doThisToItem">
	<input type="submit" value="Delete Selected Band" name="doThisToItem">
	<input type="submit" value="Add New Band" name="doThisToItem">
	</form>
	<a href="index.html"> Back to Band Home</a>
</body>
</html>