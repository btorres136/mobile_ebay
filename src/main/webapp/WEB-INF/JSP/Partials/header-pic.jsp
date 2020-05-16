<div class="main-header">
    <div class="header-logo">
        <img class="" src="/IMG/logo.png" />
    </div>
    <div class="header-search">
        <form class="form-inline" action="/Search" method="GET">
            <div class="form-search">
              <input
                class="form-control form-search_search-box"
                type="text"
                placeholder="Search"
                aria-label="Search"
                name="product"
              />
              <button class="btn btn-info form-search_button">Search</button>
            </div>
          </form>
          <div class="categories">
            <% List<Departments> dep = (List<Departments>) request.getAttribute("dep");
              for(int i =0; i < dep.size(); i++){
              %>
                 <a class="categories" href="/category/<%= dep.get(i).getDepartmentId() %>"><%= dep.get(i).getDepartmentName() %></a> 
              <% } %>
          </div>
    </div>
</div>