<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>FlyAway</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body
	style="background: url(https://images.pexels.com/photos/2026324/pexels-photo-2026324.jpeg) no-repeat; height: 100vh; background-position: center; background-size: cover;">

	<!-- Navbar -->
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
			<a class="navbar-brand mx-5" href="home-customer.jsp"> <img
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
					<li class="nav-item"><a href="home-customer.jsp"
						class="nav-link">Home</a></li>
					<li class="nav-item"><a href="dashboard-customer.jsp"
						class="nav-link">Dashboard</a></li>
					<li class="nav-item"><a
						href="all-booking-details-customer.jsp" class="nav-link">All
							Booking Details</a></li>
					<li class="nav-item active"><a
						href="change-password-customer.jsp" class="nav-link">Change
							Password</a></li>
					<li class="nav-item"><a href="booking-customer.jsp"
						class="nav-link">Book Flight</a></li>

					<c:choose>
						<c:when test="${email ==null}">
							<li class="nav-item"><a href="login-customer.jsp"
								class="nav-link">Customer Login</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a href="LogoutCustomer"
								class="nav-link">Logout</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</nav>
	</header>
	<!-- Navbar -->

	<!-- Form -->
	<div class="container col-md-5 mt-5">
		<div class="card shadow-lg">
			<div class="card-body px-4 pb-5">
				<form action="ChangePasswordCustomer" method="post">
					<caption>
						<h2 class="card-title text-center">
							<a class="navbar-brand"> <img
								src="https://cdn-icons-png.flaticon.com/512/201/201623.png"
								width="45" height="45" class="d-inline-block " alt="">
							</a>Change Password Customer
						</h2>
					</caption>

					<fieldset class="form-group">
						<label>Email</label> <input type="email" class="form-control"
							id="inputEmail4" placeholder="Email" name="email"
							value="${email}" required>
					</fieldset>

					<fieldset class="form-group">
						<label>New Password</label> <input type="password"
							class="form-control" id="inputPassword4"
							placeholder="Enter New Password" name="newpass" required>
					</fieldset>

					<button type="submit" class="btn btn-primary  btn-block mt-4">Save
						New Password</button>

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