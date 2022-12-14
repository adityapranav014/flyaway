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
	style="background: url(https://images.pexels.com/photos/240524/pexels-photo-240524.jpeg?auto=compress&amp;cs=tinysrgb&amp;w=1260&amp;h=750&amp;dpr=1) no-repeat; height: 100vh; background-position: center; background-size: cover;">

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
					<li class="nav-item active"><a href="home-customer.jsp"
						class="nav-link">Home</a></li>
					<li class="nav-item"><a href="booking-customer.jsp"
						class="nav-link">Book Flight</a></li>
					<li class="nav-item"><a href="login-admin.jsp"
						class="nav-link">Admin Login</a></li>

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

	<!-- content -->
	<div style="margin-top: 121px" class="text-center">
		<h1 class="display-3 text-white">WELCOME TO FLYAWAY</h1>
		<h4 class="text-info font-weight-normal ">Your Journey Is One
			Click Away</h4>
		<button type="button" class="btn btn-light btn-lg mt-3 shadow-lg">
			<a href="booking-customer.jsp">Book Flight</a>
		</button>
		<c:if test="${email !=null}">
			<button type="button" class="btn btn-light btn-lg mt-3 shadow-lg">
				<a href="dashboard-customer.jsp">Dashboard</a>
			</button>
		</c:if>
	</div>
	<!-- content -->

	<!-- Footer -->
	<footer class="page-footer font-small bg-primary fixed-bottom">		
		<div class="footer-copyright text-center py-3">
			© Developed By : Aditya Pranav 
			<a class="ins-ic" href="https://github.com/adityapranav014"><img
				src="https://cdn-icons-png.flaticon.com/512/733/733609.png" width="21" height="21"></a>
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