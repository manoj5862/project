<!DOCTYPE html>
<html lang="en">
<head>
<title>Vaccination Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-light" style="background-color: #e5fde3;">
		<a class="navbar-brand" href="#">Vaccination</a> <a
			class="navbar-brand" class="float-right" href="#">About</a>
	</nav>

	<h4 style="color: Orange;">Vaccination Application</h4>
	<form action="GetOtp.do">
		<div class="container-fluid">
			<div class="w-50">
				<label for="orderFrom">Email :</label> <input type="email"
					class="form-control" id="email" name="email"
					placeholder="Enter your EMail Id" required="required">
			</div>
		</div>
	</br> </br>
	<button type="submit" class="btn btn-success btn-sm">GetOTP</button>
	</br> </br>
	</form>
	<footer style="background: #e5fde3;"
		class="page-footer font-small black">
		<div class="footer-copyright text-center py-3">© 2021 Copyright</div>
	</footer>
</body>
</html>
