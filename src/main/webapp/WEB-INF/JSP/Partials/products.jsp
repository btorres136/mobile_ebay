<% List<Products> products = (List<Products>) request.getAttribute("products");
if(products.size() != 0){
    for(int i = 0; i< products.size(); i++){ %>
        <div class="row"></div>
            <div class="col-sm-3 pb-3">
                <div class="card product-card">
                    <img class="product-card__img card-img-top" src="<%= products.get(i).getImagePath() %>" alt="Card image cap" height="200" width="200">
                    <div class="card-body text-dark pr-5 pl-5">
                        <h5 class="product-card__title card-title mb-3"><%=  products.get(i).getTitle() %></h5>
                        <p class="product-card__endbid">End: <%= products.get(i).getEndBid() %> </p>
                        <a href="<%= products.get(i).getItemPath() %>" class="product-card__btn btn btn-info">Go somewhere</a>
                    </div>
                </div>
            </div>
        </div>
    <% } 
}else{ %>
    <div>
        <i class="fas fa-exclamation"></i>
        <p>No Produts have been found</p>
    </div>
<% } %>
