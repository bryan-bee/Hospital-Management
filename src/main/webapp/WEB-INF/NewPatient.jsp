<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>New Patient</title>
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
		<table class="table table-bordered">
			<form method="post">
				<tr>
					<div class="form-group row">
						<th><label class="col-form-label" for='name'>Name</label></th>
						<div class="col-4">
							<td><input class="form-control" type='text' name='name'
								id='name' placeholder="" required></td>
						</div>
					</div>
				</tr>
				<tr>
					<div class="form-group row">
						<th><label for="vaccine" class="col-form-label">Vaccine</label></th>
						<div class="col-10">
							<td><select name='vaccine' id='vaccine'>
									<c:forEach items="${vaccines}" var="vaccines">
										<c:if test="${vaccines.totalDosesLeft gt 0}">
											<option value="${vaccines.id}">${vaccines.name}</option>
										</c:if>
									</c:forEach>
							</select></td>
						</div>
					</div>
				</tr>
				<tr>
					<div class="form-group row">
						<div class="col-10">
							<td colspan='2'><a href="PatientList"
								class="btn btn-primary mr-3">Back</a>
							<button type="submit" class="btn btn-primary">Add</button></td>
						</div>
					</div>
			</form>
		</table>
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