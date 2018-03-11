<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="myStyle.css">
<title>Edit Concert Band</title>
</head>
<body>
<h2>Edit a Concert Band</h2>
<form action = "editBandServlet" method="post">
Band Name: <input type="text" name="bandName" value="${bandToEdit.bandName}"><br />
Band Location: <input type="text" name="bandLocation" value="${bandToEdit.bandLocation}"> <br />
Number of Members: <input type="text" name="numOfMembers" value="${bandToEdit.numOfMembers}"> <br />
Band Level: 
<input type="radio" name="level" value="1"> Elementary
<input type="radio" name="level" value="2"> Junior High
<input type="radio" name="level" value="3"> High School
<br />
<input type="hidden" name="id" value="${bandToEdit.bandId}">
<br />
<input type="submit" value="Save Edited Band">
</form>
</body>
</html>