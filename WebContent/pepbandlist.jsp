<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Pep Bands</title>
</head>
<body>
<form method = "post" action = "modifyPepBandServlet">
	<table>

		<tr>
			<th>Band Id</th>
			<th>Band Name</th>
			<th>Band Location</th>
			<th>Number of Members</th>
			<th>Playing Position</th>
		</tr>

		<c:forEach items="${requestScope.allPepBands}" var="currentPepBand">
			<tr>
				<td><input type="radio" name="id" value="${currentPepBand.bandId}">${currentPepBand.bandId}</td>
				<td>${currentPepBand.bandName}</td>
				<td>${currentPepBand.bandLocation}</td>
				<td>${currentPepBand.numOfMembers}</td>
				<td>${currentPepBand.playingPosition}</td>
			</tr>
		</c:forEach>

	</table>
	<input type="submit" value="Edit Selected Pep Band" name="doThisToItem">
	<input type="submit" value="Delete Selected Pep Band" name="doThisToItem">
	<input type="submit" value="Add New Pep Band" name="doThisToItem">
	</form>
</body>
</html>