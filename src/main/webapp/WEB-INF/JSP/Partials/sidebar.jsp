<nav id="sidebar">
  <div class="sidebar-header">
    <img src="/IMG/logo.png" height="150" width="150" />
    <p class="sidebar-header--text">Your Market Place</p>
  </div>
  <hr />
  <ul class="list-unstyled">
    <%if(request.getAttribute("isAdmin") !=null){ if((boolean)
    request.getAttribute("isAdmin")){ %>
    <li class="sidebar-item">
      <a class="btn" href="/sec/admin">
        <i class="fas fa-users-cog"></i>
        Administrate App
      </a>
    </li>
    <% } } %>
    <li class="sidebar-item">
      <a class="btn" href="/">
        <i class="fas fa-home"></i>
        Home
      </a>
    </li>
    <li class="sidebar-item">
      <a class="btn" href="/Products">
        <i class="fas fa-th-list"></i>
        See all Products
      </a>
    </li>
    <%if(request.getAttribute("isProductOwner") !=null){ if((boolean)
    request.getAttribute("isProductOwner")){ %>
    <li class="sidebar-item">
      <a class="btn" href="/sec/ProductOwner/Products/Add">
        <i class="far fa-plus-square"></i>
        AddProduct
      </a>
    </li>
    <% }else{ %>
    <li class="sidebar-item">
      <a class="btn" href="/BeASeller">Be a seller</a>
    </li>
    <% } } %>
  </ul>
</nav>
