<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Booking Details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<!-- Check login or not -->
	<%
	/* Prevent Back Button After Login */
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // For HTTP1.1
	response.setHeader("Pragma", "no-cache"); // For HTTP1.0
	response.setHeader("Expires", "0"); //For Proxies

	if (session.getAttribute("email") == null) {
		response.sendRedirect("login-customer.jsp");
	}
	%>

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
					<li class="nav-item"><a href="booking-customer.jsp"
						class="nav-link active">Book Flight</a></li>
					<li class="nav-item"><a href="login-admin.jsp"
						class="nav-link">Admin Login</a></li>
					<li class="nav-item"><a href="LogoutCustomer" class="nav-link">Logout</a></li>
				</ul>
			</div>
		</nav>
	</header>
	<!-- Navbar -->


	<div class="row mt-4">


		<!-- Ticket -->
		<div class="col-sm-6 col-md-6 mb-3">

			<div class="container">
				<div class="card shadow-lg m-auto" style="width: 21rem;">
					<h5 class="card-header text-center">Ticket</h5>
					<img class="card-img-top"
						src="https://images.pexels.com/photos/358319/pexels-photo-358319.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
						alt="Card image cap">
					<div class="table-responsive">
						<table class="table table-borderless table-sm table-dark ">
							<tbody>

								<!-- Code to fetch Ticket data  -->
								<c:forEach var="td" items="${ListTicketDetails}">
									<tr>
										<td>From :</td>
										<td><c:out value="${td.source}" /></td>
									</tr>
									<tr>
										<td>To :</td>
										<td><c:out value="${td.destination}" /></td>
									</tr>
									<tr>
										<td>Date</td>
										<td><c:out value="${td.date}" /></td>
									</tr>
									<tr>
										<td>Flight No :</td>
										<td><c:out value="${td.flightNo}" /></td>
									</tr>
									<tr>
										<td>Airline :</td>
										<td><c:out value="${td.airline}" /></td>
									</tr>
									<tr>
										<td>No of Passenger :</td>
										<td><c:out value="${td.noOfPassenger}" /></td>
									</tr>
									<tr>
										<td>Travel Class :</td>
										<td><c:out value="${td.travelClass}" /></td>
									</tr>
									<tr>
										<td>Total Fare :</td>
										<td><c:out value="${td.totalFare}" /></td>
									</tr>
									<tr class="bg-primary">
										<td>First Name :</td>
										<td><c:out value="${td.firstName}" /></td>
									</tr>
									<tr class="bg-primary">
										<td>Last Name :</td>
										<td><c:out value="${td.lastName}" /></td>
									</tr>
									<tr class="bg-primary">
										<td>Email :</td>
										<td><c:out value="${td.email}" /></td>
									</tr>
									<tr class="bg-primary">
										<td>Mobile No :</td>
										<td><c:out value="${td.mobileNo}" /></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
					<div class="card-footer text-muted text-center">Enjoy the
						journey!</div>
				</div>
			</div>
		</div>
		<!-- Ticket -->

		<!-- Payment Form -->
		<div class="col-sm-6 col-md-6 mb-3 d-print-none pb-5">
			<div class="card px-4 shadow-lg m-auto" style="width: 21rem;">
				<p class="h2 py-3">Payment Details</p>
				<div class="row gx-3">
					<form action="DashboardAllBookingCustomer">
						<div class="col-12">
							<div class="d-flex flex-column">
								<p class="text mb-1">Person Name</p>
								<input class="form-control mb-3" type="text" placeholder="Name"
									value="">
							</div>
						</div>
						<div class="col-12">
							<div class="d-flex flex-column">
								<p class="text mb-1">Card Number</p>
								<input class="form-control mb-3" type="text"
									placeholder="1234 5678 435678">
							</div>
						</div>
						<div class="col-6">
							<div class="d-flex flex-column">
								<p class="text mb-1">Expiry</p>
								<input class="form-control mb-3" type="text"
									placeholder="MM/YYYY">
							</div>
						</div>
						<div class="col-6">
							<div class="d-flex flex-column">
								<p class="text mb-1">CVV/CVC</p>
								<input class="form-control mb-3 pt-2 " type="password" x
									placeholder="***">
							</div>
						</div>
						<div class="col-12">
							<button onclick="window.print()" type="submit"
								class="btn btn-primary mb-3">
								Pay
								<c:out value="${td.totalFare}" />
								& Download Ticket
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- Payment Form -->
	</div>

	<!-- Footer -->
	<footer class="page-footer font-small bg-primary fixed-bottom d-print-none">
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