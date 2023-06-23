<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>List Patient</title>
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

	<div class="container mt-5">
		<div>
			<a class="btn btn-primary" href="NewPatient">New Patient</a>
		</div>
		<br>
		<div>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Name</th>
						<th scope="col">Vaccine</th>
						<th scope="col">1st Dose</th>
						<th scope="col">2nd Dose</th>
					</tr>
				</thead>
				<form method="post">
					<tbody>
						<c:forEach items="${patients}" var="patients">
							<tr>
								<td>${patients.id}</td>
								<td>${patients.peopleName}</td>
								<td>${patients.givenVaccine.name}</td>
								<td><fmt:formatDate value="${patients.firstDate}"
										pattern="M/d/yyyy" /></td>
								<c:choose>
									<c:when test="${empty patients.secondDate}">
										<c:choose>
											<c:when test="${patients.givenVaccine.dosesRequired le 1}">
												<td>-</td>
											</c:when>

											<c:when test="${patients.givenVaccine.totalDosesLeft le 0}">
												<td>Out of Stock</td>
											</c:when>

											<c:when test="${patients.givenVaccine.totalDosesLeft gt 0}">
												<td><a href="Received?id=${patients.id}">Received</a></td>
											</c:when>
										</c:choose>
									</c:when>
									<c:otherwise>
										<td><fmt:formatDate value="${patients.secondDate}"
												pattern="M/d/yyyy" /></td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
				</form>
				</tbody>

			</table>
		</div>
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