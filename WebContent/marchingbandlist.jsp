<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Marching Bands</title>
</head>
<body>
<form method = "post" action = "modifyMarchingBandServlet">
	<table>

		<tr>
			<th>Band Id</th>
			<th>Band Name</th>
			<th>Band Location</th>
			<th>Number of Members</th>
			<th>Types of Props</th>
			<th>Color Guard?</th>
		</tr>

		<c:forEach items="${requestScope.allMarchingBands}" var="currentMarchingBand">
			<tr>
				<td><input type="radio" name="id" value="${currentMarchingBand.bandId}">${currentMarchingBand.bandId}</td>
				<td>${currentMarchingBand.bandName}</td>
				<td>${currentMarchingBand.bandLocation}</td>
				<td>${currentMarchingBand.numOfMembers}</td>
				<td>${currentMarchingBand.typesOfProps}</td>
				<td>${currentMarchingBand.hasColorGuard}</td>
			</tr>
		</c:forEach>

	</table>
	<input type="submit" value="Edit Selected Marching Band" name="doThisToItem">
	<input type="submit" value="Delete Selected Marching Band" name="doThisToItem">
	<input type="submit" value="Add New Marching Band" name="doThisToItem">
	</form>
</body>
</html>