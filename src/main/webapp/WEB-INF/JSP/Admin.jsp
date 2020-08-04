<%@ page import="java.util.List" %> 
<%@ page import="java.util.ArrayList" %> 
<%@ page import="edu.mobile.ebay.DAO.Entities.ProductOwners" %>
<%@ page import="edu.mobile.ebay.DAO.Entities.Customers" %>
<%@ page import="edu.mobile.ebay.DAO.Entities.Departments" %>
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
			<h3>Products</h3>
			<a href="/sec/admin/change/product" class="btn btn-success text-center">Change product info</a>
			<div class="row">
				<div class="col">
				  <h3 class="text-center">Customers</h3>
				  <a class="btn btn-success text-center mb-5" href="/sec/admin/add/customer">Add new Customer</a>
				  <% List<Customers> customers = (List<Customers>) request.getAttribute("customers");
					for(int i = 0; i < customers.size(); i++){ %>
					<div class="card text-dark mb-5">
						<p> Customer id: <%= customers.get(i).getCustomerID() %></p>
						<% if(customers.get(i).getProductOwnersID() != null) { %>
						<p> Product Owner ID: <%= customers.get(i).getProductOwnersID().getProductOwnerID() %></p>
						<% }else{ %>
						<p>This customer is not a Seller</p>
						<% } %>
						<p>Customer Name: <%= customers.get(i).getName() %></p>
						<p>Account created on: <%= customers.get(i).getAccountCreated() %></p>
						<% if(customers.get(i).getEnable() == 1) { %>
							<form method="POST" action="/sec/admin/disable/customer">
								<input type="hidden" name="customerid" value="<%= customers.get(i).getCustomerID() %>">
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								<input type="submit" value="Disable" class="btn btn-danger"/>
							</form>
							<% }else{ %>
							<form method="POST" action="/sec/admin/enable/customer">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							<input type="hidden" name="customerid" value="<%= customers.get(i).getCustomerID() %>">	
							<input type="submit" value="Enable" class="btn btn-success"/>
							</form>
						<% } %>
					</div>
					<% } %>
				</div>
				<div class="col">
					<h3 class="text-center">Departments</h3>
					<a class="btn btn-success text-center mb-5" href="/sec/admin/add/department">Add new Department</a>
					<% List<Departments> departments = (List<Departments>) request.getAttribute("departments");
					for(int i = 0; i < departments.size(); i++){ %>
					<div class="card text-dark mb-5">
						<p>Department ID: <%= departments.get(i).getDepartmentId() %></p>
						<p>Department Name: <%= departments.get(i).getDepartmentName() %></p>
						<p>Department Description: <%= departments.get(i).getDescription() %> </p>
						<% if(departments.get(i).getEnable() == 1) { %>
							<form method="POST" action="/sec/admin/disable/department">
								<input type="hidden" name="departmentid" value="<%= departments.get(i).getDepartmentId() %>" />
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								<input type="submit" value="Disable" class="btn btn-danger"/>
							</form>
							<% }else{ %>
							<form method="POST" action="/sec/admin/enable/department">
								<input type="hidden" name="departmentid" value="<%= departments.get(i).getDepartmentId() %>" />
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								<input type="submit" value="Enable" class="btn btn-success"/>
							</form>
						<% } %>
						<a href="/sec/admin/change/department/<%= departments.get(i).getDepartmentId() %>" class="btn btn-success">Change department info</a>
					</div>
					<% } %>
				</div>
				<div class="col">
					<h3 class="text-center">ProductOwners</h3>
					<a class="btn btn-success text-center mb-5" href="/sec/admin/add/productowner">Add new ProductOwner</a>
					<% List<ProductOwners> productOwners = (List<ProductOwners>) request.getAttribute("productowners");
					for(int i = 0; i < productOwners.size(); i++){ %>
					<div class="card text-dark mb-5">
						<p> Product Owner ID: <%= productOwners.get(i).getProductOwnerID() %></p>
						<p>Product Owner Description: <%= productOwners.get(i).getDescription() %></p>
						<p>Sales made: <%= productOwners.get(i).getSalesMade() %></p>
						<p>Customer ID: <%= productOwners.get(i).getCustomerID().getCustomerID()%></p>
						<% if(productOwners.get(i).getEnable() == 1) { %>
							<form method="POST" action="/sec/admin/disable/productOwner">
									<input type="hidden" name="productownerid" value="<%= productOwners.get(i).getProductOwnerID() %>" />	
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								<input type="submit" value="Disable" class="btn btn-danger"/>
							</form>
							<% }else{ %>
							<form method="POST" action="/sec/admin/enable/productOwner">
								<input type="hidden" name="productownerid" value="<%= productOwners.get(i).getProductOwnerID() %>">
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								<input type="submit" value="Enable" class="btn btn-success"/>
							</form>
						<% } %>
					</div>
					<% } %>
				</div>
			</div>
        </div>
      </main>
    </div>
    <div id="overlay" class="overlay"></div>
    <script type="application/javascript" src="/JS/bundle.js"></script>
  </body>
</html>
