<%@ page import="java.util.List" %> <%@ page
import="edu.mobile.ebay.DAO.Entities.Products" %>
<%@ page import="java.util.List" %> <%@ page
import="edu.mobile.ebay.DAO.Entities.Departments" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>VEXON Admin</title>
    <link rel="shortcut icon" href="/IMG/logo.png" />

    <link rel="stylesheet" href="/CSS/style.css" />
  </head>
  <body>
    <div class="wrapper">
      <%@ include file="Partials/sidebar.jsp" %>
      <main class="content">
        <%@ include file="Partials/navbar.jsp" %>
        <div class="main-container text-light mt-5">
          <!-- change title-->
          <form action="/sec/admin/change/product/title" method="POST">
            <div class="form-group">
              <label>Product ID: </label>
              <input type="text" max-lenght="50" name="productid" />
            </div>
            <div class="form-group">
              <label>New title: </label>
              <input type="text" max-lenght="50" name="newproducttitle" />
            </div>
            <div class="form-group">
              <input
                type="submit"
                value="Change Title"
                class="btn btn-success"
              />
            </div>
            <input
              type="hidden"
              name="${_csrf.parameterName}"
              value="${_csrf.token}"
            />
          </form>
          <!-- change image -->
          <form
            action="/sec/admin/change/product/image"
            method="POST"
            enctype="multipart/form-data"
          >
            <div class="form-group">
              <label>Product ID: </label>
              <input type="text" max-lenght="50" name="productid" />
            </div>
            <div class="form-group">
            <input
                type="file"
                accept="img/*"
                class="btn btn-info"
                name="newproductimage"
              />
            </div>
            <div class="form-group">
              <input
                type="submit"
                value="change image"
                class="btn btn-success"
              />
            </div>
            <input
              type="hidden"
              name="${_csrf.parameterName}"
              value="${_csrf.token}"
            />
          </form>

          <!-- change end_bid -->
          <form action="/sec/admin/change/product/end_bid" method="POST">
            <div class="form-group">
              <label>Product ID: </label>
              <input type="text" max-lenght="50" name="productid" />
            </div>
            <div class="form-group">
              <label>new End date: </label>
              <input type="date" name="newproductend_bid" />
            </div>
            <div class="form-group">
              <input
                type="submit"
                value="Change end date"
                class="btn btn-success"
              />
            </div>
            <input
              type="hidden"
              name="${_csrf.parameterName}"
              value="${_csrf.token}"
            />
          </form>


            <!-- change department -->
            <form action="/sec/admin/change/product/department" method="POST">
                <div class="form-group">
                    <label>Product ID: </label>
                    <input type="text" max-lenght="50" name="productid" />
                </div>

                <div class="form-group">
                    <label>Select a Department</label>
                    <select class="selectpicker" name="newdepartment">
                        <% List<Departments> dep = (List<Departments>) request.getAttribute("dep");
                            for(int i =0; i < dep.size(); i++){
                        %>
                        <option value="<%= dep.get(i).getDepartmentId() %>"><%= dep.get(i).getDepartmentName() %></option>
                        <% } %>
                    </select>
                </div>
                <div class="form-group">
                    <input
                        type="submit"
                        value="Change department"
                        class="btn btn-success"
                    />
                </div>
                <input
                    type="hidden"
                    name="${_csrf.parameterName}"
                    value="${_csrf.token}"
                />
            </form>

        <!-- change description -->
          <form action="/sec/admin/change/product/description" method="POST">
            <div class="form-group">
              <label>Product ID: </label>
              <input type="text" max-lenght="50" name="productid" />
            </div>
            <div class="form-group">
                <label for="ProductDescription">Product Description</label>
                <textarea
                  class="form-control"
                  id="ProductDescription"
                  rows="3"
                  placeholder="Description"
                  name="newdescription"
                  maxlength="200"
                ></textarea>
              </div>
            <div class="form-group">
              <input
                type="submit"
                value="Change description"
                class="btn btn-success"
              />
            </div>
            <input
              type="hidden"
              name="${_csrf.parameterName}"
              value="${_csrf.token}"
            />
          </form>




        </div>
      </main>
    </div>
    <script type="application/javascript" src="/JS/bundle.js"></script>
  </body>
</html>
