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
        <%@ include file="Partials/navbar.jsp" %> 
        <%@ include file="Partials/header-pic.jsp" %>
      </main>
    </div>
    <div id="overlay" class="overlay"></div>
    <script type="application/javascript" src="/JS/bundle.js"></script>
  </body>
</html>
