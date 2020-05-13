package edu.mobile.ebay.Controller;

import java.util.List;

import javax.annotation.Resources;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import edu.mobile.ebay.Controller.MessageTemplates.Greetings;
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

import org.springframework.data.domain.PageRequest;

@RestController
public class RESTController {

    private final ProductsRepo ProductsRepo;
    private final BidsRepo bidsRepo;
    private final CustomersRepo customersRepo;
    private final DepartmentsRepo departmentsRepo;
    private final ProductOwnersRepo PO_Repo;
    private final SalesRepo salesRepo;

    public RESTController(edu.mobile.ebay.DAO.Repositories.ProductsRepo productsRepo, BidsRepo bidsRepo,
            CustomersRepo customersRepo, DepartmentsRepo departmentsRepo, ProductOwnersRepo pO_Repo,
            SalesRepo salesRepo) {
        ProductsRepo = productsRepo;
        this.bidsRepo = bidsRepo;
        this.customersRepo = customersRepo;
        this.departmentsRepo = departmentsRepo;
        PO_Repo = pO_Repo;
        this.salesRepo = salesRepo;
    }

    @GetMapping("/Productss")
    List<Products> all_prod(){
        return ProductsRepo.findAllProducts();
    }

    @GetMapping("/Departmentss")
    List<Departments> all_dep(){
        return departmentsRepo.findAll();
    }
    
    @GetMapping("/Customerss")
    List<Customers> all_cus(){
        return customersRepo.findAllCustomers();
    }

    @GetMapping("/Bidss")
    List<Bids> all_bids(){
        return bidsRepo.findAllBids();
    }

    @GetMapping("/POS")
    List<ProductOwners> all_pos(){
        return PO_Repo.findAll();
    }

    @GetMapping("/Saless")
    List<Sales> all_salles(){
        return salesRepo.findAll();
    }
}