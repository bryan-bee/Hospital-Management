<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>New Doses</title>
<style>
body {
  .logout {
    position: absolute;
    top: 0;
    right: 0;
    margin: 10px;
    }
</style>
</head>
<body>
	<span class="logout ml-1">Hello ${user.name}<a class="btn btn-primary" href ="Profile?id=${user.id}">Edit Profile</a>   <a class="btn btn-primary" href ="Logout">Logout</a></span>

	<div style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%)" class="container mt-5 p-3">
		<table class="table table-bordered">
			<form method='post'>
				<tr>
					<th><label for='name'>Vaccine</label></th>
					<td><select name='name' id='name'>
						<c:forEach items="${vaccines}" var = "vaccines">
						<option value= "${vaccines.id}">${vaccines.name}</option>
						</c:forEach>
						</select>
					</td>
				</tr>
		
				<tr>
					<th><label for='received'>New Doses Received</label></th>
					<td><input type='text' name='received' id='received' required></td>
				</tr>
		
				<tr>
				<td colspan='2'><a href="ListVaccines" class="btn btn-primary mr-3">Back</a><button class="btn btn-primary">Add</button></td>
				</tr>
			</form>
		</table>
	</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>