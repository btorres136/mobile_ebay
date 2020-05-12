<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ page import="java.util.List" %> <%@ page
import="java.util.ArrayList" %> <%@ page
import="edu.mobile.ebay.DAO.Entities.Products" %> <%@ page
import="edu.mobile.ebay.DAO.Entities.Departments" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>VEXOM-You Marketing Place</title>
    <link rel="shortcut icon" href="/IMG/logo.png" />

    <link rel="stylesheet" href="/CSS/style.css" />
  </head>
  <body>
    <div class="wrapper">
      <%@ include file="Partials/sidebar.jsp" %>
      <main class="content color-tertiary">
        <%@ include file="Partials/navbar.jsp" %> <%@ include
        file="Partials/main-search.jsp" %>
        <div class="main-container text-light">
          <div class="card">
            <div class="row ">
              <% Products prod = (Products) request.getAttribute("prod"); %>
              <img
                class="col-6"
                src="<%= prod.getImagePath() %>"
                alt="Card image cap"
                width="1100"
              />
              <div class="col">
                <h3 class="text-center"><%= prod.getTitle() %></h3>
                <p>Products Status: <%= prod.getState() %></p>
                <p class="">
                  Product Description: <%= prod.getDescription() %>
                </p>
                <p>This Bid Ends: <%= prod.getEndBid() %></p>
                <p>
                  Seller: <%=
                  prod.getProductOwnersID().getCustomerID().getCustomerID() %>
                </p>
                <p>This bid Started on: <%= prod.getStartBid() %></p>
              </div>
            </div>
          </div>
        </div>
      </main>
    </div>
    <div id="overlay" class="overlay"></div>
    <script type="application/javascript" src="/JS/bundle.js"></script>
  </body>
</html>
