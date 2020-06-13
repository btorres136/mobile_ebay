package edu.mobile.ebay.Controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.mobile.ebay.DAO.Repositories.ProductsRepo;
import edu.mobile.ebay.DAO.Entities.Products;
import edu.mobile.ebay.Controller.MessageTemplates.BidTemplate;
import edu.mobile.ebay.Controller.MessageTemplates.DepartmentTemplate;
import edu.mobile.ebay.Controller.MessageTemplates.ProductTemplate;
import edu.mobile.ebay.DAO.Entities.Bids;
import edu.mobile.ebay.DAO.Entities.Departments;
import edu.mobile.ebay.DAO.Repositories.BidsRepo;
import edu.mobile.ebay.DAO.Repositories.CustomersRepo;
import edu.mobile.ebay.DAO.Repositories.DepartmentsRepo;

@RestController
public class RESTController {

    @Autowired
    private ProductsRepo productsRepo;

    @Autowired
    private DepartmentsRepo departmentsRepo;

    @Autowired
    private BidsRepo bidsRepo;

    @Autowired
    private CustomersRepo customer_repo;

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
            message.get(i).setBid(bidsRepo.getMaxId(product.get(i).getProductsID()));
        }
        return message;
    }

    @GetMapping("/mobile/Departments/Products/{id}")
    public List<ProductTemplate> getDepartmentProducts(@PathVariable("id") Long id) {
        List<Products> p = new ArrayList<>();
        List<ProductTemplate> pT = new ArrayList<>();
        p = productsRepo.findProductbyDepartment(id);

        for (int i = 0; i < p.size(); i++) {
            pT.add(new ProductTemplate());
            pT.get(i).setTitle(p.get(i).getTitle());
            pT.get(i).setState(p.get(i).getState());
            pT.get(i).setOwner(p.get(i).getProductOwnersID().getCustomerID().getCustomerID());
            pT.get(i).setItemPath(p.get(i).getItemPath());
            pT.get(i).setId(p.get(i).getProductsID());
            pT.get(i).setEndBid(p.get(i).getEndBid());
            pT.get(i).setDescription(p.get(i).getDescription());
            pT.get(i).setImagePath(p.get(i).getImagePath());
            pT.get(i).setDepartment(p.get(i).getDepartmentId().getDepartmentId().toString());
            pT.get(i).setBid(bidsRepo.getMaxId(p.get(i).getProductsID()));
        }
        return pT;
    }

    @GetMapping("/mobile/Products/{id}")
    public ProductTemplate GetProduct(@PathVariable("id") String id) {
        Products product = productsRepo.findByproductsID(id);
        ProductTemplate productTemplate = new ProductTemplate();
        if (product != null) {
            productTemplate.setId(product.getProductsID());
            productTemplate.setDescription(product.getDescription());
            productTemplate.setEndBid(product.getEndBid());
            productTemplate.setState(product.getState());
            productTemplate.setImagePath(product.getImagePath());
            productTemplate.setTitle(product.getTitle());
            productTemplate.setItemPath(product.getItemPath());
            productTemplate.setOwner(product.getProductOwnersID().getCustomerID().getCustomerID());
            productTemplate.setDepartment(product.getDepartmentId().getDepartmentId().toString());
            productTemplate.setBid(bidsRepo.getMaxId(product.getProductsID()));
        }
        return productTemplate;
    }

    @GetMapping("/mobile/Departments")
    public List<DepartmentTemplate> Departments() {
        List<DepartmentTemplate> departmentTemplate = new ArrayList<>();
        List<Departments> departments = departmentsRepo.findAll();
        for (int i = 0; i < departments.size(); i++) {
            departmentTemplate.add(new DepartmentTemplate());
            departmentTemplate.get(i).setDepartmentId(departments.get(i).getDepartmentId());
            departmentTemplate.get(i).setDepartmentName(departments.get(i).getDepartmentName());
        }
        return departmentTemplate;
    }

    @GetMapping("/mobile/Products/Search")
    public List<ProductTemplate> GetProductByName(@RequestParam("name") String name) {
        List<Products> product = productsRepo.findProductByKeyWord(name);
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
            message.get(i).setBid(bidsRepo.getMaxId(product.get(i).getProductsID()));
        }
        return message;
    }

    @PostMapping("/mobile/addBid")
    public void addbid() {
        Bids bid = new Bids();
        Long millis = System.currentTimeMillis();
        bid.setBidTimeSet(new Date(millis));
        bid.setBidQuantity(0);
        bid.setProductsID(productsRepo.findByproductsID(""));
        bid.setCustomerID(customer_repo.findByCustomerID(""));
        bidsRepo.save(bid);
    }

    
    @PostMapping("/mobile/addProduct")
    public void addProduct(@RequestParam("startingbid") int startingbid, @RequestParam("ProductTitle") String Title,
            HttpServletRequest request, @RequestParam("Description") String Description,
            @RequestParam("department_search") Long dep_id, @RequestParam("status") String status,
            @RequestParam("endbid") String enddate,
            @RequestParam("img") MultipartFile Img) throws IllegalStateException, IOException {
        Logger log = LoggerFactory.getLogger(RESTController.class);
        log.info("TITLE: SOMETHING");
        Products product = new Products();
        UUID uuid = UUID.randomUUID();
        if (!Img.isEmpty()) {
            String actualPath = "/UserIMG/" + "test" + "/" + uuid.toString() + Img.getOriginalFilename();
            String path = request.getSession().getServletContext()
                    .getRealPath("/UserIMG/" + "test" + "/" + uuid.toString() + Img.getOriginalFilename());
            File dirPath = new File(path);
            if (!dirPath.exists()) {
                dirPath.mkdirs();
            }
            product.setImagePath(actualPath);
            Img.transferTo(dirPath);
        } else {
            product.setImagePath("/IMG/img-not-available.png");
        }
        long millis = System.currentTimeMillis();
        product.setProductsID(uuid.toString());
        product.setProductOwnersID(customer_repo.findByCustomerID("btorres136"/*user.getName()*/).getProductOwnersID());
        product.setStartBid(new Date(millis));
        product.setDescription(Description);
        product.setItemPath("/item/" + uuid);
        product.setEndBid(new Date(enddate));
        product.setState(status);
        product.setTitle(Title);
        product.setDepartmentId(departmentsRepo.finddepartments(dep_id));
        product.setEnable(1);
        productsRepo.save(product);

        Bids bid = new Bids();
        bid.setBidQuantity(startingbid);
        bid.setBidTimeSet(new Date(millis));
        bid.setCustomerID(customer_repo.findByCustomerID("btorres136"));
        bid.setProductsID(productsRepo.findByproductsID(uuid.toString()));
        bidsRepo.save(bid);
    }
}
