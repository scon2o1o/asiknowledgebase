<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty user}">
	<c:redirect url="login.jsp"></c:redirect>
</c:if>
<!doctype html>
<html lang="en" class="h-100">
<head>
<!-- icon -->
<link rel="icon" href="https://2f0m6a43zofy3ffa863wmmhv-wpengine.netdna-ssl.com/wp-content/uploads/2018/10/advcance-systems-ireland-favicon-16.png" type="image/png" />
<link rel="shortcut icon" href="https://2f0m6a43zofy3ffa863wmmhv-wpengine.netdna-ssl.com/wp-content/uploads/2018/10/advcance-systems-ireland-favicon-16.png" type="image/png" />
<title>ASI Knowledge Base</title>
<link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/sticky-footer-navbar/">
<!-- Custom styles for this template -->
<link href="simple-sidebar.css" rel="stylesheet">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
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
<link href="sticky-footer-navbar.css" rel="stylesheet">
</head>
<body class="d-flex flex-column h-100">
	<header>
		<!-- Fixed navbar -->
		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
			<button class="btn btn-link" id="menu-toggle" style="margin-right: 20px;">
				<span class="navbar-toggler-icon"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">ASI Knowledge Base</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item">
						<a class="nav-link" href="index.jsp"> Home</a>
					</li>
					<c:if test="${sessionScope.user.getCanadd().equals('Y')}">
						<li class="nav-item active">
							<a class="nav-link" href="add.jsp">
								Add
								<span class="sr-only">(current)</span>
							</a>
						</li>
					</c:if>
					<c:if test="${sessionScope.user.getIsadmin().equals('Y')}">
						<li class="nav-item">
							<a class="nav-link" href="users.jsp">Users</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="admin.jsp">Admin</a>
						</li>
					</c:if>
					<li class="nav-item">
						<a href="maintainuser.jsp" class="nav-link">User: ${sessionScope.user.getUsername()}</a>
					</li>
				</ul>
				<form class="form-inline mt-2 mt-md-0" method="get" action="LogoutServlet">
					<button class="btn btn-danger my-2 my-sm-0" type="submit">Logout</button>
				</form>
			</div>
		</nav>
	</header>
	<div>
		<div class="d-flex" id="wrapper">
			<!-- Sidebar -->
			<div class="bg-light border-right" id="sidebar-wrapper">
				<div class="sidebar-heading">Start Bootstrap</div>
				<div class="list-group list-group-flush">
					<a href="index.jsp" class="list-group-item list-group-item-action bg-light">Close</a>
					<a class="list-group-item list-group-item-action bg-light" onclick="clearAddNewDocForm()">Clear</a>
					<a class="list-group-item list-group-item-action bg-light" onclick="submitAddNewDocForm()">Submit</a>
				</div>
			</div>
			<!-- /#sidebar-wrapper -->
			<!-- Page Content -->
			<div id="page-content-wrapper">
				<nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
					<button class="btn btn-primary" id="menu-toggle">Toggle Menu</button>
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
							<li class="nav-item active">
								<a class="nav-link" href="#">
									Home
									<span class="sr-only">(current)</span>
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#">Link</a>
							</li>
							<li class="nav-item dropdown">
								<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Dropdown </a>
								<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
									<a class="dropdown-item" href="#">Action</a>
									<a class="dropdown-item" href="#">Another action</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item" href="#">Something else here</a>
								</div>
							</li>
						</ul>
					</div>
				</nav>
				<div class="container-fluid" style="padding: 20px;">
					<div style="text-align: center">
						<img class="mb-4" src="https://advancesystems.ie/wp-content/uploads/2018/10/logo-advance-systems.png" alt="login-logo">
					</div>
					<h3>Add New Document</h3>
					<p class="text-muted">
						Use this form to add a new document. Click
						<a href="#">here</a>
						for details of how to do so
					</p>
					<form method="post" action="AddDocServlet" id="AddNewDoc">
					<input value="${sessionScope.user.getUsername()}" type="text" id="user" name="user" hidden>
						<div class="form-group">
							<label for="name">Name</label>
							<input type="text" class="form-control" id="name" name="name" required maxlength="100">
							<small id="urlHelp" class="form-text text-muted">The title of the document</small>
						</div>
						<div class="form-group">
							<label for="details">Details</label>
							<input type="text" class="form-control" id="details" name="details" required maxlength="100">
							<small id="detailsHelp" class="form-text text-muted">A description of the document</small>
						</div>
						<div class="form-group">
							<label for="url">URL</label>
							<input type="text" class="form-control" id="url" name="url" required maxlength="500">
							<small id="urlHelp" class="form-text text-muted">The embedded URL of the document</small>
						</div>
						<div class="form-group">
							<label for="category">Category</label>
							<select id="category" name="category" class="form-control">
								<option value=""></option>
							</select>
						</div>
						<div class="form-group">
							<label for="subcategory">Subcategory</label>
							<select id="subcategory" name="subcategory" class="form-control">
								<option value=""></option>
							</select>
						</div>
						<input hidden type="text" id="author" name="author" value="${sessionScope.user.getFirstnames()} ${sessionScope.user.getSurname()}">
						<button type="submit" hidden id="submitForm">Submit</button>
					</form>
				</div>
			</div>
			<!-- /#page-content-wrapper -->
		</div>
		<!-- /#wrapper -->
	</div>
	<footer class="footer mt-auto py-3">
		<div class="container-fluid">
			<span class="text-muted">&copy Advance Systems 2020</span>
		</div>
	</footer>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="/docs/4.5/assets/js/vendor/jquery.slim.min.js"><\/script>')
	</script>
	<script src="/docs/4.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-LtrjvnR4Twt/qOuYxE721u19sVFLVSA4hf/rRt6PrZTmiPltdZcI7q7PXQBYTKyf" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	<!-- Menu Toggle Script -->
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
	</script>
	<script>
		function submitAddNewDocForm() {
			document.getElementById("submitForm").click();
		}

		function clearAddNewDocForm() {
			document.getElementById("name").value = '';
			document.getElementById("details").value = '';
			document.getElementById("url").value = '';
			document.getElementById("category").value = '';
			document.getElementById("subcategory").value = '';
		}
	</script>
	<script src="js/adddocscript.js" type="text/javascript"></script>
</body>
</html>
