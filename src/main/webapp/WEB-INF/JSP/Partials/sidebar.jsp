<nav id="sidebar">
  <div class="sidebar-header">
    <h3>Bootstrap Sidebar</h3>
  </div>
  <ul class="list-unstyled">
    <p>Dummy Heading</p>
    <%if(request.getAttribute("isProductOwner") !=null){ if((boolean)
    request.getAttribute("isProductOwner")){ %>
    <li>
      <a>hello</a>
    </li>
    <li>
      <a href="/sec/ProductOwner/Products/Add">AddProduct</a>
    </li>
    <% }else{ %>
    <li>
      <a>hello</a>
    </li>
    <li>
      <a>Be a seller</a>
    </li>
    <li>
      <a>chacata</a>
    </li>
    <% } }else {%>
    <li>
      <a>hello</a>
    </li>
    <li>
      <a>Be a seller</a>
    </li>
    <li>
      <a>chacata</a>
    </li>
    <% } %>
  </ul>
</nav>
