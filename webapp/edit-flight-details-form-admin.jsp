<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Edit Flight Details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body
	style="background: url(https://images.unsplash.com/photo-1617042375876-a13e36732a04?ixlib=rb-1.2.1&amp;ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&amp;auto=format&amp;fit=crop&amp;w=1170&amp;q=80) no-repeat; height: 100vh; background-position: center; background-size: cover;">

	<!-- Check login or not -->
	<%
	/* Prevent Back Button After Login */
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // For HTTP1.1
	response.setHeader("Pragma", "no-cache"); // For HTTP1.0
	response.setHeader("Expires", "0"); //For Proxies

	if (session.getAttribute("adminEmail") == null) {
		response.sendRedirect("login-admin.jsp");
	}
	%>

	<!-- Navbar -->
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
			<a class="navbar-brand mx-5" href="home-admin.jsp"> <img
				src="https://cdn-icons-png.flaticon.com/512/201/201623.png"
				width="30" height="30" class="d-inline-block align-top" alt="">
				FlyAway
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarTogglerDemo02"
				aria-controls="navbarTogglerDemo02" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse mx-5" id="navbarTogglerDemo02">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a href="home-admin.jsp" class="nav-link">Home</a></li>
					<li class="nav-item"><a href="save-flightdetails-admin.jsp"
						class="nav-link">Add Flight Details</a></li>
					<li class="nav-item active"><a href="FlightDetailsAdmin"
						class="nav-link">All Flight Details</a></li>
					<li class="nav-item"><a href="change-password-admin.jsp"
						class="nav-link">Change Password</a></li>
					<li class="nav-item"><a href="LogoutAdmin" class="nav-link">Logout</a></li>
				</ul>
			</div>
		</nav>
	</header>
	<!-- Navbar -->

	<!-- Form -->
	<div class="container col-md-5 mt-3 pb-5">
		<div class="card shadow-lg">
			<div class="card-body">
				<form action="UpdateFlightDetailsAdmin" method="post">
					<h2 class="card-title">Edit Flight details</h2>

					<fieldset class="form-group">
						<input type="hidden" value="<c:out value='${efd.flightId}'/>"
							name="id"> <label>Flight No</label> <input type="number"
							placeholder="Enter Flight No"
							value="<c:out value='${efd.flightNo}'/>" class="form-control"
							name="fno" required>
					</fieldset>

					<fieldset class="form-group">
						<label>Airline</label> <input type="text"
							placeholder="Enter Airline Name"
							value="<c:out value='${efd.airline}'/>" class="form-control"
							name="airline" required>
					</fieldset>

					<div class="row">
						<div class="col">
							<div class="form-group">
								<label for="exampleFormControlSelect1">Source</label> <select
									class="form-control" id="exampleFormControlSelect1" name="src"
									value="<c:out value='${efd.srcAirportCode}'/>">
									<option selected><c:out value='${efd.srcAirportCode}' /></option>
									<option>DEL (Delhi)</option>
									<option>BOM (Mumbai)</option>
									<option>BLR (Bangaluru)</option>
									<option>HYD (Hyderabad)</option>
									<option>MAA (Chennai)</option>
									<option>CCU (Kolkata)</option>
								</select>
							</div>
						</div>
						<div class="col">
							<div class="form-group">
								<label for="exampleFormControlSelect1">Destination</label> <select
									class="form-control" id="exampleFormControlSelect1" name="dest">
									<option selected><c:out value='${efd.destAirportCode}' /></option>
									<option>DEL (Delhi)</option>
									<option>BOM (Mumbai)</option>
									<option>BLR (Bangaluru)</option>
									<option>HYD (Hyderabad)</option>
									<option>MAA (Chennai)</option>
									<option>CCU (Kolkata)</option>
								</select>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col">
							<label>Select Days</label>
						</div>
						<div class="col">
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox"
									id="inlineCheckbox1" value="Mon" name="weekdays"> <label
									class="form-check-label" for="inlineCheckbox1">Mon</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox"
									id="inlineCheckbox2" value="Tue" name="weekdays"> <label
									class="form-check-label" for="inlineCheckbox2">Tue</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" name="weekdays" type="checkbox"
									id="inlineCheckbox2" value="Wed"> <label
									class="form-check-label" for="inlineCheckbox2">Wed</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox"
									id="inlineCheckbox2" value="Thu" name="weekdays"> <label
									class="form-check-label" for="inlineCheckbox2">Thu</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox"
									id="inlineCheckbox2" value="Fri" name="weekdays"> <label
									class="form-check-label" for="inlineCheckbox2">Fri</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox"
									id="inlineCheckbox2" value="Sat" name="weekdays"> <label
									class="form-check-label" for="inlineCheckbox2">Sat</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox"
									id="inlineCheckbox2" value="Sun" name="weekdays"> <label
									class="form-check-label" for="inlineCheckbox2">Sun</label>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="exampleFormControlSelect1">Travel Class</label> <select
							class="form-control" id="exampleFormControlSelect1" name="class">
							<option selected><c:out value='${efd.classType}' /></option>
							<option>Economy</option>
							<option>Premium</option>
							<option>Business</option>
						</select>
					</div>

					<fieldset class="form-group">
						<label>Fare</label> <input type="number" placeholder="Enter Fare"
							value="<c:out value='${efd.fare}'/>" class="form-control"
							name="fare" required>
					</fieldset>

					<button type="submit" class="btn btn-success">Update
						Flight</button>
				</form>
			</div>
		</div>
	</div>
	<!-- Form -->

	<!-- Footer -->
	<footer class="page-footer font-small bg-primary fixed-bottom">
		<div class="footer-copyright text-center py-3">
			© Developed By : Aditya Pranav <a class="ins-ic"
				href="https://github.com/adityapranav014"><img
				src="https://cdn-icons-png.flaticon.com/512/733/733609.png"
				width="21" height="21"></a>
		</div>
	</footer>
	<!-- Footer -->

	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
</body>
</html>