<div class="row">
    <% List<Products> products = (List<Products>) request.getAttribute("products");
        for(int i =0; i< products.size(); i++){ %>
        <div class="col-sm-3 pb-3">
            <div class="card color-primary-light">
                <img class="card-img-top" src="<%= products.get(i).getImagePath() %>" alt="Card image cap" height="200" width="200">
                <div class="card-body text-light pr-5 pl-5">
                    <h5 class="card-title mb-3 text-center"><%=  products.get(i).getTitle() %></h5>
                    <p class="card-text"><%= products.get(i).getDescription() %></p>
                    <p>End: <%= products.get(i).getEndBid() %> </p>
                    <a href="#" class="btn btn-primary">Go somewhere</a>
                </div>
            </div>
        </div>
    <% } %>
</div>