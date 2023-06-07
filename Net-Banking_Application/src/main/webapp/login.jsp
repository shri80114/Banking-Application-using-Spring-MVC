<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="styles.css">
</head>

<body style="background-image: url('https://images.alphacoders.com/665/665091.jpg')">
 

	<div class="container mt-5">
		<div class="row justify-content-center align-items-center">
			<div class="col-md-6 col-lg-5">
				<div class="card shadow-lg">
					<div class="card-body p-5">
						<div class="text-center mb-3">
							<img src="data:image/png;base64,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" alt="User profile"
								class="rounded-circle img-thumbnail">
						</div>
						<h2 class="text-center mb-4">Net Banking</h2>
						<form action="login" method="post">
							<div class="form-floating mb-3">
								<input type="email" class="form-control" id="email" placeholder="Email address"
									name="userName" required> <label
									for="email">Email address</label>
							</div>
							<div class="form-floating mb-3 password-container">
								<input type="password" class="form-control" id="password" name="password"
									placeholder="Password" required> <label for="password">Password</label>
								<div class="password-strength-indicator">
									<div class="progress">
										<div class="progress-bar"></div>
									</div>
								</div>
							</div>
							<div class="d-grid gap-3">
								<button type="submit" class="btn btn-primary">Login</button>
								<a href="createAccount" class="btn btn-outline-primary">Create Account</a>
							</div>
						</form>
						<div >
						<h6>${wrong }</h6>
						</div>
						
						<hr>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Bootstrap JavaScript -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Custom JS -->
	<script src="script.js"></script>
</body>
</html>
