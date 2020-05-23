<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>VEXON Admin</title>
    <link rel="shortcut icon" href="/IMG/logo.png">

    <link rel="stylesheet" href="/CSS/style.css" />	
</head>
<body>
	<div class="wrapper">
      <%@ include file="Partials/sidebar.jsp" %>
      <main class="content">
        <%@ include file="Partials/navbar.jsp" %> 
        <div class="main-container text-light mt-5">
			<form action="/sec/admin/add/department" method="POST">
				<div class="form-group">
					<label>Deparment Name: </label>
					<input type="text" max-lenght="10" name="departmentname">
				</div>
				<div class="form-group">
					<label>Department Description: </label>
					<input type="text-area" max-length="50" name="departmentdescription"/>
				</div>
				<div class="form-group">
					<input type="submit" value="Add Department" class="btn btn-success" />
				</div>				
            	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</div>
	  </main>
	 </div>
    <script type="application/javascript" src="/JS/bundle.js"></script>
</body>
</html>
