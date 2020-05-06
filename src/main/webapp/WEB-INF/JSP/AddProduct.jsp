<%@ page import="java.util.List" %> <%@ page
import="edu.mobile.ebay.DAO.Entities.Products" %>
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
            <div class="form-check">
              <input
                class="form-check-input"
                type="radio"
                name="exampleRadios"
                id="exampleRadios1"
                value="option1"
                name="new"
                checked
              />
              <label class="form-check-label" for="exampleRadios1">
                New
              </label>
            </div>
            <div class="form-check">
              <input
                class="form-check-input"
                type="radio"
                name="exampleRadios"
                id="exampleRadios2"
                value="option2"
                name="used"
              />
              <label class="form-check-label" for="exampleRadios2">
                Used
              </label>
            </div>
            <div class="form-group">
              <input type="date" name="endbid" />
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
