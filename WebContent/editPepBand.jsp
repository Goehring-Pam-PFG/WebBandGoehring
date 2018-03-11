<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="myStyle.css">
<title>Edit Pep Band</title>
</head>
<body>
<h2>Edit a Pep Band</h2>
<form action = "editPepBandServlet" method="post">
Band Name: <input type="text" name="bandName" value="${pepBandToEdit.bandName}"><br />
Band Location: <input type="text" name="bandLocation" value="${pepBandToEdit.bandLocation}"><br />
Number of Members: <input type="text" name="numOfMembers" value="${pepBandToEdit.numOfMembers}"><br />
Type of Event: <select name="event">
         <option value="1">Girl's Basketball</option>
         <option value="2">Boy's Basketball</option> 
         <option value="3">Football</option>
         <option value="4">Wrestling</option>
         <option value="5">Homecoming</option>
         <option value="6">District Finals</option>
         <option value="7">Red Ribbon Week</option>
     
        </select><br />
<input type="hidden" name="id" value="${pepBandToEdit.bandId}">
<input type="submit" value="Save Edited Pep Band">
</form>
</body>
</html>