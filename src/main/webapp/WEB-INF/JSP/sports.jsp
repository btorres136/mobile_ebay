<%@ page import="java.util.List" %>
<%@ page import="edu.mobile.ebay.DAO.Entities.Products" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Sports</title>

    <link rel="stylesheet" href="/CSS/style.css" />
  </head>
  <body>
    

    <h1>Sport Products </h1>
    <table style="width:100%">
        <tr>
            <th>Product id</th>
            <th>Description</th>
            <th>End bid</th>
            <th>image_path</th>
            <th>Quantity</th>
            <th>start_bid</th>
            <th>state</th>
            <th>title</th>
            <th>product_ownerId</th>
            <th>sports id</th>
        </tr>
        <% List<Products> product_sport = (List<Products>) request.getAttribute("product_sport");
        for(int i =0; i< product_sport.size(); i++){ %>
            <tr>
                <td> <%= product_sport.get(i).getProductsID() %></td>
                <td> <%= product_sport.get(i).getDescription() %></td>
                <td> <%= product_sport.get(i).getEndBid() %></td>
                <td> <%= product_sport.get(i).getImagePath() %></td>
                <td> <%= product_sport.get(i).getQuantity() %></td>
                <td> <%= product_sport.get(i).getStartBid() %></td>
                <td> <%= product_sport.get(i).getState() %></td>
                <td> <%= product_sport.get(i).getTitle() %></td>
                <td> <%= product_sport.get(i).getProductOwnersID().getProductOwnerID() %></td>
                <td> <%= product_sport.get(i).getSportsProducts().iterator().next().getSportsID() %></td>
                
            </tr>
            
        <% } %>
    </table>
    
  </body>
  <script type="application/javascript" src="/JS/bundle.js"></script>
</html>