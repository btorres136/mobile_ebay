package edu.mobile.ebay.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.mobile.ebay.DAO.Repositories.ProductsRepo;
import edu.mobile.ebay.DAO.Entities.Products;
import edu.mobile.ebay.Controller.MessageTemplates.BidTemplate;
import edu.mobile.ebay.Controller.MessageTemplates.DepartmentTemplate;
import edu.mobile.ebay.Controller.MessageTemplates.ProductTemplate;
import edu.mobile.ebay.DAO.Entities.Bids;
import edu.mobile.ebay.DAO.Entities.Customers;
import edu.mobile.ebay.DAO.Entities.Departments;
import edu.mobile.ebay.DAO.Entities.ProductOwners;
import edu.mobile.ebay.DAO.Entities.Products;
import edu.mobile.ebay.DAO.Entities.Sales;
import edu.mobile.ebay.DAO.Repositories.BidsRepo;
import edu.mobile.ebay.DAO.Repositories.CustomersRepo;
import edu.mobile.ebay.DAO.Repositories.DepartmentsRepo;
import edu.mobile.ebay.DAO.Repositories.ProductOwnersRepo;
import edu.mobile.ebay.DAO.Repositories.ProductsRepo;
import edu.mobile.ebay.DAO.Repositories.SalesRepo;

@RestController
public class RESTController {

    @Autowired
    private ProductsRepo productsRepo;

    @Autowired
    private DepartmentsRepo departmentsRepo;

    @Autowired
    private BidsRepo bidsRepo;

    @GetMapping("/mobile/Products")
    public List<ProductTemplate> all_prod() {
        List<Products> product = productsRepo.findAllProducts();
        List<ProductTemplate> message = new ArrayList<>();
        for (int i = 0; i < product.size(); i++) {
            message.add(new ProductTemplate());
            message.get(i).setId(product.get(i).getProductsID());
            message.get(i).setDescription(product.get(i).getDescription());
            message.get(i).setEndBid(product.get(i).getEndBid());
            message.get(i).setState(product.get(i).getState());
            message.get(i).setImagePath(product.get(i).getImagePath());
            message.get(i).setTitle(product.get(i).getTitle());
            message.get(i).setItemPath(product.get(i).getItemPath());
            message.get(i).setOwner(product.get(i).getProductOwnersID().getCustomerID().getCustomerID());
            message.get(i).setDepartment(product.get(i).getDepartmentId().getDepartmentId().toString());
            List<Bids> bids = bidsRepo.findAll();
            List<BidTemplate> prod_bids = new ArrayList<>();
            for (int y = 0; y < bids.size(); y++) {
                prod_bids.add(new BidTemplate());
                prod_bids.get(y).setEndDate(bids.get(y).getBidTimeSet());
                prod_bids.get(y).setProduct(bids.get(y).getProductsID().getProductsID());
                prod_bids.get(y).setQuantity(bids.get(y).getBidQuantity());
            }
            message.get(i).setBids(prod_bids);
        }
        return message;
    }

    @GetMapping("/mobile/Products/{id}")
    public ProductTemplate GetProduct(@PathVariable("id") String id) {
        Products product = productsRepo.findByproductsID(id);
        ProductTemplate productTemplate = new ProductTemplate();

        productTemplate.setId(product.getProductsID());
        productTemplate.setDescription(product.getDescription());
        productTemplate.setEndBid(product.getEndBid());
        productTemplate.setState(product.getState());
        productTemplate.setImagePath(product.getImagePath());
        productTemplate.setTitle(product.getTitle());
        productTemplate.setItemPath(product.getItemPath());
        productTemplate.setOwner(product.getProductOwnersID().getCustomerID().getCustomerID());
        productTemplate.setDepartment(product.getDepartmentId().getDepartmentId().toString());
        List<Bids> bids = bidsRepo.findAll();
        List<BidTemplate> prod_bids = new ArrayList<>();
        for (int y = 0; y < bids.size(); y++) {
            prod_bids.add(new BidTemplate());
            prod_bids.get(y).setEndDate(bids.get(y).getBidTimeSet());
            prod_bids.get(y).setProduct(bids.get(y).getProductsID().getProductsID());
            prod_bids.get(y).setQuantity(bids.get(y).getBidQuantity());
        }
        productTemplate.setBids(prod_bids);
        return productTemplate;
    }

}