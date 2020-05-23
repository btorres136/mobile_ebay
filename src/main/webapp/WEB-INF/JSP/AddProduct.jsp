<%@ page import="java.util.List" %> <%@ page
import="edu.mobile.ebay.DAO.Entities.Products" %>
<%@ page import="java.util.List" %> <%@ page
import="edu.mobile.ebay.DAO.Entities.Departments" %>
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
        <div class="main-container text-light">
          <form
            method="post"
            action="/sec/ProductOwner/Products/Add"
            enctype="multipart/form-data"
          >
            <div class="form-group">
              <label for="ProductTitle">Product Title</label>
              <input
                type="text"
                class="form-control"
                id="ProductTitle"
                maxlength="30"
                placeholder="Enter Product Title"
                name="ProductTitle"
              />
            </div>
            <div class="form-group">
              <label for="ProductDescription">Product Description</label>
              <textarea
                class="form-control"
                id="ProductDescription"
                rows="3"
                placeholder="Description"
                name="Description"
                maxlength="200"
              ></textarea>
            </div>
            <div class="form-group">
              <input
                type="file"
                accept="img/*"
                class="btn btn-info"
                name="img"
              />
            </div>
            <div class="form-group">
              <label>Select a Department</label>
            <select class="selectpicker" name="department_search">
              <% List<Departments> dep = (List<Departments>) request.getAttribute("dep");
                for(int i =0; i < dep.size(); i++){
                %>
                <option value="<%= dep.get(i).getDepartmentId() %>"><%= dep.get(i).getDepartmentName() %></option>
                <% } %>
            </select>
          </div>
            <div class="form-group">
              <label>Product Condition</label>
              <select class="selectpicker" name="status">
                <option value="New">New</option>
                <option value="used">used</option>
              </select>
            </div>
            <div class="form-group">
              <input type="date" name="endbid" />
            </div>
            <div class="form-group">
              <input type="number" name="startingbid">
            </div>
            <input
              type="hidden"
              name="${_csrf.parameterName}"
              value="${_csrf.token}"
            />
            <button type="submit" class="btn btn-primary">Submit</button>
          </form>
        </div>
      </main>
    </div>
    <div id="overlay" class="overlay"></div>
    <script type="application/javascript" src="/JS/bundle.js"></script>
  </body>
</html>
