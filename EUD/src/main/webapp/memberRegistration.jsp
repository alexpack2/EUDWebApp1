<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
</head>
<body>
<% boolean added = (boolean)session.getAttribute("added"); %>
<form action="Register" method=post>

<table>
	<tr><td> Name: </td><td><input type="text" name="name" required></td></tr>
	<tr><td> Surname: </td><td><input type="text" name="surname" required></td></tr>
	<tr><td><label for="gender">Gender:</label></td>
	<td><select name="gender" id="gender" required>
		<option disabled selected value> -- select gender -- </option>
  		<option value="M">M</option>
  		<option value="F">F</option>
	</select></td></tr>
	<tr><td><label for="birthdate" required>Birthdate:</label></td>
	<td><input class="form-control" type="datetime-local" id="birthdate" name ="birthdate" placeholder="select datetime" required></td></tr>
	<tr><td> Work Address: </td><td><input type="text" name="waddress"></td></tr>
	<tr><td> Home Address: </td><td><input type="text" name="haddress"></td></tr>
	<tr><td></td><td><input type="submit" name="register"></td></tr>
	<tr><td></td>
	<td>
		<% String result = (String)session.getAttribute("result"); %>
		<% if (added && result!=null){ %>
			<p><%=result %></p>
		<%} %>
	</td></tr>	
</table>
</form>
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<script>
flatpickr("input[type=datetime-local]",{
	allowInput: true,
});
</script>

</body>
</html>