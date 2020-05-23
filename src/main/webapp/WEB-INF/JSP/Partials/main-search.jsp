<div class="main-search">
  <form class="form-inline" action="/Search" method="GET">
    <div class="form-search">
      <input
        class="form-control form-search_search-box"
        type="text"
        placeholder="Search"
        aria-label="Search"
        name="product"
        required="true"
      />
      <select class="selectpicker" name="department_search" >
        <option value="0"> Select a Department</option>
        <% List<Departments> dep = (List<Departments>) request.getAttribute("dep");
          for(int i =0; i < dep.size(); i++){
          %>
          <option value="<%= dep.get(i).getDepartmentId() %>"><%= dep.get(i).getDepartmentName() %></option>
          <% } %>
      </select>      
      <button class="btn btn-info form-search_button">Search</button>
    </div>
  </form>
  <div class="categories">
    <% for(int i =0; i < dep.size(); i++){ %>
      <a href="/category/<%= dep.get(i).getDepartmentId() %>"><%= dep.get(i).getDepartmentName() %></a> 
    <% } %>
  </div>
</div>
