<%@ page import="java.util.List" %>
<%@ page import="edu.mobile.ebay.DAO.Entities.Customers" %>
<%@ page import="edu.mobile.ebay.DAO.Entities.Bids" %>
<%@ page import="edu.mobile.ebay.DAO.Entities.Sales" %>
<%@ page import="edu.mobile.ebay.DAO.Entities.Products" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Products:Cars</title>

    <link rel="stylesheet" href="/CSS/style.css" />
  </head>
  <body>

    <h1>Bids</h1>
    <% List<Bids> bids = (List<Bids>) request.getAttribute("bids");
      for(int i =0; i< bids.size(); i++){ %>
        <p> <%= bids.get(i).getCustomerID().getName() %> </p>
        <p> <%= bids.get(i).getBidQuantity() %> </p>

      <% } %>

    <h1>Sales</h1>

    <% List<Sales> sales = (List<Sales>) request.getAttribute("sales");
      for(int i =0; i< sales.size(); i++){ %>
        <p> <%= sales.get(i).getTransactionTime() %> </p>
        <p> <%= sales.get(i).getSelledProduct().getDescription() %> </p>
        <p> <%= sales.get(i).getSelledProduct().getProductsBids().getBidQuantity() %> </p>

      <% } %>
    <h1>Products</h1>
    <% List<Products> products = (List<Products>) request.getAttribute("products");
      for(int i =0; i< products.size(); i++){ %>
        <p> <%= products.get(i).getDescription() %> </p>
        

      <% } %>
  </body>
  <script type="application/javascript" src="/JS/dist/bundle.js"></script>
</html>
