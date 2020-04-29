<%@ page import="java.util.List" %>
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
    <div class="wrapper">
      <%@ include file="Partials/sidebar.jsp" %>
      <main class="content color-tertiary">
        <%@ include file="Partials/navbar.jsp" %>
        <%@ include file="Partials/main-search.jsp" %>
        <%@ include file="Partials/products.jsp" %>
      </main>
    </div>
  </body>
  <script type="application/javascript" src="/JS/bundle.js"></script>
</html>
