<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- icon -->
<link rel="icon" href="https://2f0m6a43zofy3ffa863wmmhv-wpengine.netdna-ssl.com/wp-content/uploads/2018/10/advcance-systems-ireland-favicon-16.png" type="image/png" />
<link rel="shortcut icon" href="https://2f0m6a43zofy3ffa863wmmhv-wpengine.netdna-ssl.com/wp-content/uploads/2018/10/advcance-systems-ireland-favicon-16.png" type="image/png" />

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<title>ASI Knowledgebase</title>

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<link href="signin.css" rel="stylesheet">

</head>
<body class="text-center">
	<form class="form-signin" method="post" action="LoginServlet">
		<img class="mb-4" src="https://advancesystems.ie/wp-content/uploads/2018/10/logo-advance-systems.png" alt="login-logo">
		<label for="inputEmail" class="sr-only">Username</label> 
		<input class="form-control" placeholder="Username" name="username" required>
		<label for="inputPassword" class="sr-only">Password</label>
		<input type="password" class="form-control" placeholder="Password" name="password" required>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	</form>
</body>
</html>