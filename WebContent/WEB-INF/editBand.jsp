<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "editBandServlet" method="post">
Band Name: <input type="text" name="bandName" value="${bandToEdit.bandName}">
Band Location: <input type="text" name="bandLocation" value="${bandToEdit.bandLocation}">
Number of Members: <input type="text" name="numOfMembers" value="${bandToEdit.numOfMembers}">
<input type="hidden" name="id" value="${bandToEdit.bandId}">
<input type="submit" value="Save Edited Band">
</form>
</body>
</html>