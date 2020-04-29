<div class="text-light">
    <% List<Products> products = (List<Products>) request.getAttribute("products");
        for(int i =0; i< products.size(); i++){ %>
          <p> <%= products.get(i).getDescription() %> </p>
          <p> <%= products.get(i).getEndBid() %> </p>
    <% } %>
</div>