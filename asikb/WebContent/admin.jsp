<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty user}">
	<c:redirect url="login.jsp"></c:redirect>
</c:if>
<!doctype html>
<html lang="en" class="h-100">
<head>
<title>ASI Knowledge Base</title>
<script src="https://kit.fontawesome.com/ca0a2f6bf8.js"
	crossorigin="anonymous"></script>
<!-- icon -->
<link rel="icon"
	href="https://2f0m6a43zofy3ffa863wmmhv-wpengine.netdna-ssl.com/wp-content/uploads/2018/10/advcance-systems-ireland-favicon-16.png"
	type="image/png" />
<link rel="shortcut icon"
	href="https://2f0m6a43zofy3ffa863wmmhv-wpengine.netdna-ssl.com/wp-content/uploads/2018/10/advcance-systems-ireland-favicon-16.png"
	type="image/png" />
<link rel="canonical"
	href="https://getbootstrap.com/docs/4.5/examples/sticky-footer-navbar/">
<!-- Custom styles for this template -->
<link href="simple-sidebar.css" rel="stylesheet">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
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
			<button class="btn btn-link" id="menu-toggle"
				style="margin-right: 20px;">
				<span class="navbar-toggler-icon"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">ASI Knowledge Base</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarCollapse" aria-controls="navbarCollapse"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link" href="index.jsp">
							Home</a></li>
					<c:if test="${sessionScope.user.getCanadd().equals('Y')}">
						<li class="nav-item"><a class="nav-link" href="add.jsp">Add</a>
						</li>
					</c:if>
					<c:if test="${sessionScope.user.getIsadmin().equals('Y')}">
						<li class="nav-item"><a class="nav-link" href="users.jsp">Users</a>
						</li>
						<li class="nav-item active"><a class="nav-link"
							href="admin.jsp"> Admin <span class="sr-only">(current)</span>
						</a></li>
					</c:if>
					<li class="nav-item"><a href="maintainuser.jsp"
						class="nav-link">User: ${sessionScope.user.getUsername()}</a></li>
				</ul>
				<form class="form-inline mt-2 mt-md-0" method="get"
					action="LogoutServlet">
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
				<div class="list-group list-group-flush" id="sidebar">
					<a href="index.jsp"
						class="list-group-item list-group-item-action bg-light">Close</a>
				</div>
			</div>
			<!-- /#sidebar-wrapper -->
			<!-- Page Content -->
			<div id="page-content-wrapper">
				<nav
					class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
					<button class="btn btn-primary" id="menu-toggle">Toggle
						Menu</button>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
							<li class="nav-item active"><a class="nav-link" href="#">
									Home <span class="sr-only">(current)</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
								role="button" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> Dropdown </a>
								<div class="dropdown-menu dropdown-menu-right"
									aria-labelledby="navbarDropdown">
									<a class="dropdown-item" href="#">Action</a> <a
										class="dropdown-item" href="#">Another action</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item" href="#">Something else here</a>
								</div></li>
						</ul>
					</div>
				</nav>
				<div class="container-fluid" style="padding: 20px;">
					<div style="text-align: center">
						<img class="mb-4"
							src="https://advancesystems.ie/wp-content/uploads/2018/10/logo-advance-systems.png"
							alt="login-logo">
						<h3>Administrator Dashboard</h3>
					</div>
					<div class="row" style="text-align: center; margin-top: 30px;">
						<div class="col">
							<a href="addcategory.jsp" type="button" id=""
								class="btn btn-outline-link btn-lg" data-toggle="tooltip" title="Add a new category"> <i class="fa fa-plus"
								aria-hidden="true"></i> <br> Add Category
							</a>
						</div>
						<div class="col">
							<a href="editcategory.jsp" type="button" id=""
								class="btn btn-outline-link btn-lg" data-toggle="tooltip" title="Edit the name of an existing category"> <i class="far fa-edit"
								aria-hidden="true"></i> <br> Edit Category
							</a>
						</div>
						<div class="col">
							<a href="deletecategory.jsp" type="button" id=""
								class="btn btn-outline-link btn-lg" data-toggle="tooltip" title="Delete a category"> <i
								class="fas fa-trash-alt" aria-hidden="true"></i> <br>
								Delete Category
							</a>
						</div>
						<div class="col">
							<a href="addsubcategory.jsp" type="button" id=""
								class="btn btn-outline-link btn-lg" data-toggle="tooltip" title="Add a new subcategory"> <i
								class="fas fa-plus-circle" aria-hidden="true"></i> <br> Add
								Subcategory
							</a>
						</div>
						<div class="col">
							<a href="editsubcategory.jsp" type="button" id=""
								class="btn btn-outline-link btn-lg" data-toggle="tooltip" title="Edit the name of an existing subcategory"> <i
								class="fas fa-pencil-alt" aria-hidden="true"></i> <br> Edit
								Subcategory
							</a>
						</div>
						<div class="col">
							<a href="deletesubcategory.jsp" type="button" id=""
								class="btn btn-outline-link btn-lg" data-toggle="tooltip" title="Delete a subcategory"> <i
								class="fas fa-eraser" aria-hidden="true"></i> <br> Delete
								Subcategory
							</a>
						</div>
					</div>
					<div class="row" style="text-align: center; margin-top: 30px;">
						<div class="col">
							<a href="users.jsp" type="button" id=""
								class="btn btn-outline-link btn-lg" data-toggle="tooltip" title="Maintain user accounts"> <i class="fas fa-users"
								aria-hidden="true"></i> <br> Maintain Users
							</a>
						</div>
						<div class="col">
							<a href="adduser.jsp" type="button" id=""
								class="btn btn-outline-link btn-lg" data-toggle="tooltip" title="Add a new user"> <i
								class="fas fa-user-plus" aria-hidden="true"></i> <br> Add
								New User
							</a>
						</div>
						<div class="col">
							<a href="audit.jsp" type="button" id=""
								class="btn btn-outline-link btn-lg" data-toggle="tooltip" title="View system audit log"> <i
								class="fas fa-history" aria-hidden="true"></i> <br> Audit
								Log
							</a>
						</div>
						<div class="col">
							<a href="smtp.jsp" type="button" id=""
								class="btn btn-outline-link btn-lg" data-toggle="tooltip" title="Edit SMTP account details"> <i class="fas fa-at"
								aria-hidden="true"></i> <br> SMTP Settings
							</a>
						</div>
						<div class="col">
							<a href="sysadmin.jsp" type="button" id=""
								class="btn btn-outline-link btn-lg" data-toggle="tooltip" title="Edit the system administrator account"> <i
								class="fas fa-user-shield" aria-hidden="true"></i> <br>
								System Administrator
							</a>
						</div>
						<div class="col">
							<a href="LogoutServlet" type="button" id=""
								class="btn btn-outline-link btn-lg" data-toggle="tooltip" title="Logout of the system"> <i
								class="fas fa-sign-out-alt" aria-hidden="true"></i> <br>
								Logout
							</a>
						</div>
					</div>
					<div class="row" style="text-align: center; margin-top: 30px;">
						<div class="col"></div>
						<div class="col"></div>
						<div class="col"></div>
						<div class="col"></div>
						<div class="col"></div>
						<div class="col"></div>
					</div>
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
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="/docs/4.5/assets/js/vendor/jquery.slim.min.js"><\/script>')
	</script>
	<script src="/docs/4.5/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-LtrjvnR4Twt/qOuYxE721u19sVFLVSA4hf/rRt6PrZTmiPltdZcI7q7PXQBYTKyf"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
	<!-- Menu Toggle Script -->
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
	</script>
	<script>
		$(document).ready(function() {
			$('[data-toggle="tooltip"]').tooltip();
		});
	</script>
</body>
</html>
