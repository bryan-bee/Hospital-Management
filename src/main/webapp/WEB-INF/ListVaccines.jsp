<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>List Vaccines</title>
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

	<div class="container p-3 mt-5">
		<p style="font-size: 30px;">
			<a class="btn btn-primary" href='NewVaccine'>New Vaccine</a> | <a
				class="btn btn-primary" href='NewDoses'>New Doses</a>
		</p>
		<table class="table table-bordered">
			<tr>
				<th scope="col">Vaccine</th>
				<th scope="col">Doses Required</th>
				<th scope="col">Days Between Doses</th>
				<th scope="col">Total Doses Received</th>
				<th scope="col">Total Doses Left</th>
				<th></th>
			</tr>
			<c:forEach items="${vaccines}" var="vaccines">
				<tr>
					<td>${vaccines.name}</td>
					<td>${vaccines.dosesRequired}</td>
					<c:choose>
						<c:when test="${vaccines.daysBetweenDoses lt 1  }">
							<td>-</td>
						</c:when>
						<c:otherwise>
							<td>${vaccines.daysBetweenDoses}</td>
						</c:otherwise>
					</c:choose>
					<td>${vaccines.totalDosesReceived}</td>
					<td>${vaccines.totalDosesLeft}</td>
					<td><a class="btn btn-danger"
						href="EditVaccine?id=${vaccines.id}">Edit</a>
				</tr>
			</c:forEach>
		</table>
		<a class="btn btn-primary" href="FrontPage">FrontPage</a>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>