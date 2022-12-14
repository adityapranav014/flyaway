<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>User Registration</title>
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
					<li class="nav-item"><a href="home-customer.jsp"
						class="nav-link">Home</a></li>
					<li class="nav-item"><a href="booking-customer.jsp"
						class="nav-link">Book Flight</a></li>
					<li class="nav-item"><a href="login-admin.jsp"
						class="nav-link">Admin Login</a></li>
					<li class="nav-item active"><a href="login-customer.jsp"
						class="nav-link">Customer Login</a></li>
				</ul>
			</div>
		</nav>
	</header>
	<!-- Navbar -->

	<!-- Form -->
	<div class="container col-md-5 mt-5 pb-5">
		<div class="card shadow-lg">
			<div class="card-body">
				<form action="RegisterCustomer">

					<h2 class="card-title">
						<a class="navbar-brand"> <img
							src="https://cdn-icons-png.flaticon.com/512/201/201623.png"
							width="45" height="45" class="d-inline-block " alt="">
						</a>Registration Form
					</h2>

					<div class="form-row">
						<div class="col">
							<fieldset class="form-group">
								<label>First Name</label> <input type="text"
									class="form-control" placeholder="First name" name="fname"
									required>
							</fieldset>
						</div>
						<div class="col">
							<fieldset class="form-group">
								<label>Last Name</label> <input type="text" class="form-control"
									placeholder="Last name" name="lname" required>
							</fieldset>
						</div>
					</div>

					<fieldset class="form-group">
						<label>Email</label> <input type="email" class="form-control"
							id="inputEmail4" placeholder="Email" name="email" required>
					</fieldset>

					<fieldset class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" id="inputPassword4" placeholder="Password"
							name="pass" required>
					</fieldset>

					<fieldset class="form-group">
						<label>Mobile No</label> <input type="text" class="form-control"
							placeholder="Enter Mobile No" name="mobileno" required>
					</fieldset>


					<button type="submit" value="submit"
						class="btn btn-primary btn-block mt-4">Register</button>

					<label class="font-weight-lighter mt-3"><a
						href="login-customer.jsp">Already Have Account</a></label>
					<button type="button" class="btn btn-secondary  btn-block">
						<a class="text-decoration-none text-light"
							href="login-customer.jsp">Login</a>
					</button>

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