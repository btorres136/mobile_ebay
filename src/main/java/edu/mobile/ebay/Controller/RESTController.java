package edu.mobile.ebay.Controller;

import java.util.ArrayList;
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
        List<Products> list = new ArrayList<Products>(); 
        List<Products> response = ProductsRepo.findAllProducts();
        for(int i = 0; i< response.size(); i++){
            list.add(new Products());
            list.get(i).setProductsID(response.get(i).getProductsID());
            list.get(i).setDescription(response.get(i).getDescription());
            list.get(i).setStartBid(response.get(i).getStartBid());
            list.get(i).setEndBid(response.get(i).getEndBid());
            list.get(i).setState(response.get(i).getState());
            list.get(i).setImagePath(response.get(i).getImagePath());
            list.get(i).setTitle(response.get(i).getTitle());
            list.get(i).setItemPath(response.get(i).getItemPath());
            list.get(i).setProductOwnersIdStr(response.get(i).getProductOwnersID().getProductOwnerID().toString());
            list.get(i).setDepartmentIdStr(response.get(i).getDepartmentId().getDepartmentId().toString());
            //list.get(i).setProductsBidsStr(response.get(i).getProductsBids().getBidID().toString());

            if(response.get(i).getProductsBids() == null){
                list.get(i).setProductsBidsStr("none");
            }else{
                list.get(i).setProductsBidsStr(response.get(i).getProductsBids().getBidID().toString());
            }
        }
        
        return list;
    }

    @GetMapping("/Departmentss")
    List<Departments> all_dep(){
        List<Departments> response = departmentsRepo.findAll(); 
        List<Departments> list = new ArrayList<Departments>();

        for(int i = 0; i< response.size(); i++){
            list.add(new Departments());
            list.get(i).setDepartmentId(response.get(i).getDepartmentId());
            list.get(i).setDepartmentName(response.get(i).getDepartmentName());
            list.get(i).setDescription(response.get(i).getDescription());
        }
        return list;
    }
    
    @GetMapping("/Customerss")
    List<Customers> all_cus(){
        return customersRepo.findAllCustomers();
    }

    @GetMapping("/Bidss")
    List<Bids> all_bids(){
        List<Bids> response = bidsRepo.findAllBids(); 
        List<Bids> list = new ArrayList<Bids>();

        for(int i = 0; i< response.size(); i++){
            list.add(new Bids());
            list.get(i).setBidID(response.get(i).getBidID());
            list.get(i).setBidQuantity(response.get(i).getBidQuantity());
            list.get(i).setBidTimeSet(response.get(i).getBidTimeSet());
            list.get(i).setCustomerIdStr(response.get(i).getCustomerID().getCustomerID());
            list.get(i).setProductsIdStr(response.get(i).getProductsID().getProductsID());
        }
        return list;
    }

    @GetMapping("/POS")
    List<ProductOwners> all_pos(){

        List<ProductOwners> response = PO_Repo.findAll();
        List<ProductOwners> list = new ArrayList<ProductOwners>();

        for(int i = 0; i< response.size(); i++){
            list.add(new ProductOwners());
            list.get(i).setProductOwnerID(response.get(i).getProductOwnerID());
            list.get(i).setRating(response.get(i).getRating());
            list.get(i).setDescription(response.get(i).getDescription());
            list.get(i).setCustomerIdStr(response.get(i).getCustomerID().getCustomerID());
        }
        return list;
    }

    @GetMapping("/Saless")
    List<Sales> all_salles(){
        List<Sales> response = salesRepo.findAll();
        List<Sales> list = new ArrayList<Sales>();

        for(int i = 0; i< response.size(); i++){
            list.add(new Sales());
            list.get(i).setSalesID(response.get(i).getSalesID());
            list.get(i).setTransactionTime(response.get(i).getTransactionTime());
            list.get(i).setSelledProductIdStr(response.get(i).getSelledProduct().getProductsID());
            list.get(i).setSellerIdStr(response.get(i).getSeller().getProductOwnerID().toString());
            list.get(i).setBuyerIdStr(response.get(i).getBuyer().getCustomerID());
        }
        return list; 
    }
}