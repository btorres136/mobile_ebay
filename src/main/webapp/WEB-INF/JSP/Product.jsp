<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> 
<%@ page import="java.util.List" %> 
<%@ page import="java.util.ArrayList" %> 
<%@ page import="edu.mobile.ebay.DAO.Entities.Products" %>
<%@ page import="edu.mobile.ebay.DAO.Entities.Departments" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>VEXOM-You Marketing Place</title>
    <link rel="shortcut icon" href="/IMG/logo.png">

    <link rel="stylesheet" href="/CSS/style.css" />
  </head>
  <body>
    <div class="wrapper">
      <%@ include file="Partials/sidebar.jsp" %>
      <main class="content color-tertiary">
        <%@ include file="Partials/navbar.jsp" %> <%@ include
        file="Partials/main-search.jsp" %>
        <div class="main-container text-light">
            <% Products prod = (Products) request.getAttribute("prod"); %>
            <img class="" src="<%= prod.getImagePath() %>" alt="Card image cap" height="200" width="200">
            <div class="text-light pr-5 pl-5">
                <h5 class="text-center"><%=  prod.getTitle() %></h5>
                <p class=""><%= prod.getDescription() %></p>
                <p>End: <%= prod.getEndBid() %> </p>
            </div>
        </div>
      </main>
    </div>
    <div id="overlay" class="overlay"></div>
    <script type="application/javascript" src="/JS/bundle.js"></script>
  </body>
</html>
