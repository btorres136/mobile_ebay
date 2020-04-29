<%@ page import="java.util.List" %>
<%@ page import="edu.mobile.ebay.DAO.Entities.Customers" %>
<%@ page import="edu.mobile.ebay.DAO.Entities.Bids" %>
<%@ page import="edu.mobile.ebay.DAO.Entities.Products" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>

    <link rel="stylesheet" href="/CSS/style.css" />
  </head>
  <body>
    <% List<Customers> cus = (List<Customers>) request.getAttribute("cus");
      for(int i =0; i< cus.size(); i++){ %>
        <p> <%= cus.get(i).getName() %> </p>
        <p> <%= cus.get(i).getRating() %> </p>
        <p> <%= cus.get(i).getProductOwnersID().getDescription() %> </p>
      <% } %>

      <% List<Bids> data = (List<Bids>) request.getAttribute("bid");
        for(int i =0; i < data.size(); i++){ %>
          <p> <%= data.get(i).getCustomerID().getName() %> </p>
        <% } %>
  </body>
  <script type="application/javascript" src="/JS/bundle.js"></script>
</html>
