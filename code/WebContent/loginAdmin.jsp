<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/main.css"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<title>Login</title>
</head>
<body>

<header class="p-3 bg-primary text-white mb-3">
	<h1>ME LO PIDO</h1>
</header>

<div class="container">

	<h3>Identifícate</h3>
	
	<form action="ServletLogIn" method="post">
		<div class="form-row">
			<div class="form-group col-md-2">
				<label>Pass </label>
				<input  class="form-control" type="password" name="pass"/>   ${error} 
			</div>
			<div class="form-group col-md-4 d-flex align-items-center">
				<button class="btn btn-primary ml-2" type="submit">Entrar</button>
			</div>
		</div>
	</form>

</div>
</body>
</html>