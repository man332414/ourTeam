<%@ page contentType="text/html; charset=utf-8" %>
<%@ page isELIgnored="false" %>
<html >
<head>    
   <link rel ="stylesheet" href ="./resources/css/bootstrap.min.css" />
	<title>Welcome</title>
</head>
<body>
<nav class ="navbar navbar-expand navbar-dark bg-dark">
	<div class="container">
		<div class="navbar-header">
			<a class="narbar-brand" href="./home">Home</a>
			<a class="narbar-brand" href="./books">books</a>
		</div>
	</div>
</nav>

<div class="jumbotron">
	<div class="container">
		<h1 class="display-3">${greeting}</h1>
	</div>
</div>
<div class=container">
	<div class="text-center">
		<h3>${strapline}</h3>
	</div>
</div>
<footer class="container">
	<hr>
	<p>&copy; WebMarket</p>
</footer>
	
</body>
</html>
  