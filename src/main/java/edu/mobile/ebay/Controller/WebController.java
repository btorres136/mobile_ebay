package edu.mobile.ebay.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.mobile.ebay.DAO.Entities.Customers;
import edu.mobile.ebay.DAO.Entities.Departments;
import edu.mobile.ebay.DAO.Entities.Products;
import edu.mobile.ebay.DAO.LDAP.LDAPManager;
import edu.mobile.ebay.DAO.Repositories.BidsRepo;
import edu.mobile.ebay.DAO.Repositories.CustomersRepo;
import edu.mobile.ebay.DAO.Repositories.DepartmentsRepo;
import edu.mobile.ebay.DAO.Repositories.ProductOwnersRepo;
import edu.mobile.ebay.DAO.Repositories.ProductsRepo;
import edu.mobile.ebay.DAO.Repositories.SalesRepo;

@Controller
public class WebController {
    @Autowired
    private CustomersRepo customer;

    @Autowired
    private BidsRepo bid;

    @Autowired
    private BidsRepo bidRepo;

    @Autowired
    private CustomersRepo customerRepo;

    @Autowired
    private ProductsRepo productsRepo;

    @Autowired
    private SalesRepo salesRepo;

    @Autowired
    private ProductOwnersRepo productownersrepo;

    @Autowired
    private LDAPManager ldap;

    @Autowired
    private DepartmentsRepo departments_repo;


    @GetMapping(value = { "/", "/index" })
    public String index(Model model, Principal user, Authentication auth) {
        if(user != null && auth.isAuthenticated()){
            model.addAttribute("user", user.getName());
            boolean isProductOwner = auth.getAuthorities().stream().anyMatch((authority -> authority.getAuthority().equals("ROLE_PRODUCTOWNER")));
            model.addAttribute("isProductOwner", isProductOwner);
        }
        List<Departments> dep = departments_repo.findAll();
        model.addAttribute("dep", dep);
        return "Menu";
    }

    @GetMapping("/login")
    public String Login(Principal user) {
        if (user!=null && ((Authentication)user).isAuthenticated()) {
            return "redirect:/";
        }
        return "Login";
    }

    @GetMapping("/SignUp")
    public String SignUp(Principal user) {
        if (user!=null && ((Authentication)user).isAuthenticated()) {
            return "redirect:/";
        }
        return "SignUp";
    }

    @PostMapping("/SignUp")
    public String SignUp(@RequestParam("username") String username, @RequestParam("lastname") String lastname,
            @RequestParam("uid") String uid, @RequestParam("email") String email,
            @RequestParam("password") String password) {
        if (!customerRepo.existsByCustomerID(uid)) {
            Customers customer = new Customers();
            customer.setCustomerID(uid);
            customer.setName(username);
            customer.setRating(0);
            long millis = System.currentTimeMillis();
            customer.setAccountCreated(new Date(millis));
            customerRepo.save(customer);
            ldap.create(username, lastname, uid, email, password);
        }
        return "redirect:/login";
    }

    @GetMapping("/sec/ProductOwner/Products/Add")
    public String AddProduct(Principal user, Model model, Authentication auth) {
        boolean isProductOwner = auth.getAuthorities().stream().anyMatch((authority -> authority.getAuthority().equals("ROLE_PRODUCTOWNER")));
        model.addAttribute("user", user.getName());
        model.addAttribute("isProductOwner", isProductOwner);
        return "AddProduct";
    }

    @PostMapping("/sec/ProductOwner/Products/Add")
    public String AddtoProducts(@RequestParam("ProductTitle") String Title, HttpServletRequest request,
            @RequestParam("Description") String Description, @RequestParam("endbid") Date enddate,
            @RequestParam("img") MultipartFile Img, Principal user) throws IllegalStateException, IOException {
        Products product = new Products();
        UUID uuid = UUID.randomUUID();
        if (!Img.isEmpty()) {
            String actualPath = "/UserIMG/" + user.getName() + "/" + uuid.toString() + Img.getOriginalFilename();
            String path = request.getSession().getServletContext()
                    .getRealPath("/UserIMG/" + user.getName() + "/" + uuid.toString() + Img.getOriginalFilename());
            File dirPath = new File(path);
            if (!dirPath.exists()) {
                dirPath.mkdirs();
            }
            product.setImagePath(actualPath);
            Img.transferTo(dirPath);
        }else{
            product.setImagePath("/IMG/img-not-available.png");
        }
        long millis = System.currentTimeMillis();
        product.setProductsID(uuid.toString());
        product.setProductOwnersID(customerRepo.findByCustomerID(user.getName()).getProductOwnersID());
        product.setStartBid(new Date(millis));
        product.setDescription(Description);
        product.setItemPath("/item/"+uuid);
        product.setEndBid(enddate);
        product.setState("used");
        product.setTitle(Title);
        product.setDepartmentId(departments_repo.getOne((long) 1));
        productsRepo.save(product);
        return "redirect:/Products";
    }

    @GetMapping("/item/{id}")
    private String showItem(@PathVariable("id") String id, Model model, @Nullable Principal user, @Nullable Authentication auth){
        Products prod = productsRepo.findByproductsID(id);
        model.addAttribute("prod", prod);
        if(user != null && auth.isAuthenticated()){
            model.addAttribute("user", user.getName());
            boolean isProductOwner = auth.getAuthorities().stream().anyMatch((authority -> authority.getAuthority().equals("ROLE_PRODUCTOWNER")));
            model.addAttribute("isProductOwner", isProductOwner);
        }
        List<Departments> dep = departments_repo.findAll();
        model.addAttribute("dep", dep);
        return "Product";
    }


    @GetMapping("/Search")
    private String Search(@RequestParam("product") String product, Model model,@Nullable Principal user, @Nullable Authentication auth){
        if(user != null && auth.isAuthenticated()){
            model.addAttribute("user", user.getName());
            boolean isProductOwner = auth.getAuthorities().stream().anyMatch((authority -> authority.getAuthority().equals("ROLE_PRODUCTOWNER")));
            model.addAttribute("isProductOwner", isProductOwner);
        }
        List<Products> products = productsRepo.findProductByKeyWord(product);
        model.addAttribute("products", products);
        List<Departments> dep = departments_repo.findAll();
        model.addAttribute("dep", dep);
        return "All_Products";
    }

    @GetMapping("/Products")
    private String Products(Model model,@Nullable Principal user, @Nullable Authentication auth){
        if(user != null && auth.isAuthenticated()){
            model.addAttribute("user", user.getName());
            boolean isProductOwner = auth.getAuthorities().stream().anyMatch((authority -> authority.getAuthority().equals("ROLE_PRODUCTOWNER")));
            model.addAttribute("isProductOwner", isProductOwner);
        }
        Pageable pageable = PageRequest.of(0, 5);
        Page<Products> products = productsRepo.findAll(pageable);
        List<Products> prod = products.getContent();
        model.addAttribute("products", prod);
        List<Departments> dep = departments_repo.findAll();
        model.addAttribute("dep", dep);
        return "All_Products";
    }

}