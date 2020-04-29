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
    
    <h1>Products2</h1>
    <% List<Products> products2 = (List<Products>) request.getAttribute("products2");
      for(int i =0; i< products2.size(); i++){ %>
        <p> <%= products2.get(i).getDescription() %> </p>
        <p> <%= products2.get(i).getTitle() %> </p>
      <% } %>

    <h1>Products_elctronics</h1>
    <% List<Products> product_electronics = (List<Products>) request.getAttribute("product_electronics");
      for(int i =0; i< product_electronics.size(); i++){ %>
        <p> <%= product_electronics.get(i).getDescription() %> </p>
        <p> <%= product_electronics.get(i).getTitle() %> </p>
      <% } %>
    
    <h1>Products Sport</h1>
    <% List<Products> product_sport = (List<Products>) request.getAttribute("product_sport");
      for(int i =0; i< product_sport.size(); i++){ %>
        <p> <%= product_sport.get(i).getDescription() %> </p>
        <p> <%= product_sport.get(i).getTitle() %> </p>
      <% } %>
    
    <h1>Products Auto</h1>
    <% List<Products> product_auto = (List<Products>) request.getAttribute("product_auto");
      for(int i =0; i< product_auto.size(); i++){ %>
        <p> <%= product_auto.get(i).getDescription() %> </p>
        <p> <%= product_auto.get(i).getTitle() %> </p>
      <% } %>
    <h1>Products Bids</h1>
    <% List<Products> product_bids = (List<Products>) request.getAttribute("product_bids");
      for(int i =0; i< product_bids.size(); i++){ %>
        <p> <%= product_bids.get(i).getDescription() %> </p>
        <p> <%= product_bids.get(i).getTitle() %> </p>
      <% } %>
    

  </body>
  <script type="application/javascript" src="/JS/dist/bundle.js"></script>
</html>
