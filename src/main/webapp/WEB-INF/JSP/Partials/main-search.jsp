<div class="main-search">
  <form class="form-inline" action="#" method="POST">
    <div class="form-search">
      <input
        class="form-control form-search_search-box"
        type="text"
        placeholder="Search"
        aria-label="Search"
      />
      <button class="btn btn-info form-search_button">Search</button>
    </div>
  </form>
  <div class="categories">
    <% List<Departments> dep = (List<Departments>) request.getAttribute("dep");
      for(int i =0; i < dep.size(); i++){
      %>
         <a href="#"><%= dep.get(i).getDepartmentName() %></a> 
      <% } %>
  </div>
</div>
