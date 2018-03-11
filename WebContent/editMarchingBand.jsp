<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="myStyle.css">
<title>Edit Marching Band</title>
</head>
<body>
<h2>Edit a Marching Band</h2>
<form action = "editMarchingBandServlet" method="post">

Band Name: <input type="text" name="bandName" value="${marchingBandToEdit.bandName}"><br />
Band Location: <input type="text" name="bandLocation" value="${marchingBandToEdit.bandLocation}"><br />
Number of Members: <input type="text" name="numOfMembers" value="${marchingBandToEdit.numOfMembers}"><br />
Types of Props: <input type="text" name="TypeofProps" value="${marchingBandToEdit.typesOfProps}"> <br />

<input type="hidden" name="id" value="${marchingBandToEdit.bandId}">
<input type="submit" value="Save Edited Marching Band">
</form>
</body>
</html>