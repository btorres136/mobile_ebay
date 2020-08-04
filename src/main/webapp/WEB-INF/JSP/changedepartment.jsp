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
			<form action="/sec/admin/change/department/name" method="POST">
				<div class="form-group">
					<label>Department Name: </label>
					<input type="text" max-lenght="50" name="newdepartmentname">
				</div>
				<div class="form-group">
					<input type="submit" value="change department name" class="btn btn-success" />
				</div>				
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <input type="hidden" name="departmentid" value="<%= (int) request.getAttribute("id") %>" />
            </form>
            
            <form action="/sec/admin/change/department/description" method="POST">
				<div class="form-group">
					<label>Department description: </label>
					<input type="text" max-lenght="50" name="newdepartmentdescription">
				</div>
				<div class="form-group">
					<input type="submit" value="change department description" class="btn btn-success" />
				</div>				
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <input type="hidden" name="departmentid" value="<%= (int) request.getAttribute("id") %>" />
			</form>
		</div>
	  </main>
	 </div>
	<script type="application/javascript" src="/JS/bundle.js"></script>
</body>
</html>
