<%@ page import="java.util.List" %>
<%@ page import="edu.mobile.ebay.DAO.Entities.Customers" %>
<%@ page import="edu.mobile.ebay.DAO.Entities.Bids" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Products:Cars</title>

    <link rel="stylesheet" href="/CSS/style.css" />
  </head>
  <body>
    <% List<Bids> bids = (List<Bids>) request.getAttribute("bids");
      for(int i =0; i< bids.size(); i++){ %>
        <p> <%= bids.get(i).getCustomerID().getName() %> </p>
        <p> <%= bids.get(i). %> </p>

      <% } %>
  </body>
  <script type="application/javascript" src="/JS/dist/bundle.js"></script>
</html>
