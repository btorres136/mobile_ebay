package edu.mobile.ebay.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mobile.ebay.Controller.MessageTemplates.Greetings;
import edu.mobile.ebay.DAO.Repositories.ProductsRepo;
import edu.mobile.ebay.DAO.Entities.Products;

@RestController
public class RESTController {
    
    @Autowired
    private ProductsRepo productsRepo;

    /*@GetMapping("/test")
    public Greetings test(){
       return new Greetings(1, "hello");
    }*/

    @GetMapping("/test")
    public Products prod(){
        Pageable pageable = PageRequest.of(0, 1);
        Page<Products> products = productsRepo.findAll(pageable);
        List<Products> prod = products.getContent();
        return prod.get(0);
    }

}