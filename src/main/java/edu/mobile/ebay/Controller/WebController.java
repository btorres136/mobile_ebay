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
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.mobile.ebay.DAO.Entities.Customers;
import edu.mobile.ebay.DAO.Entities.Products;
import edu.mobile.ebay.DAO.LDAP.LDAPManager;
import edu.mobile.ebay.DAO.Repositories.AutomotiveRepo;
import edu.mobile.ebay.DAO.Repositories.BidsRepo;
import edu.mobile.ebay.DAO.Repositories.CustomersRepo;
import edu.mobile.ebay.DAO.Repositories.ElectronicsRepo;
import edu.mobile.ebay.DAO.Repositories.ProductOwnersRepo;
import edu.mobile.ebay.DAO.Repositories.ProductsRepo;
import edu.mobile.ebay.DAO.Repositories.SalesRepo;
import edu.mobile.ebay.DAO.Repositories.SportsRepo;


@Controller
public class WebController {
    @Autowired
    private CustomersRepo customer;

    @Autowired
    private BidsRepo bid;

    @Autowired
    private AutomotiveRepo autoRepo;

    @Autowired
    private BidsRepo bidRepo;

    @Autowired
    private CustomersRepo customerRepo;

    @Autowired
    private ElectronicsRepo electronicsRepo;

    @Autowired
    private ProductOwnersRepo PORepo;

    @Autowired
    private ProductsRepo productsRepo;

    @Autowired
    private SalesRepo salesRepo;

    @Autowired
    private SportsRepo sportRepo;

    @Autowired
    private ProductOwnersRepo productownersrepo;

    @Autowired
    private LDAPManager ldap;


    @GetMapping(value = { "/", "/index" })
    public String index(Model model,@Nullable Principal user,@Nullable Authentication auth) {
        if(user != null && auth.isAuthenticated()){
            model.addAttribute("user", user.getName());
            boolean isProductOwner = auth.getAuthorities().stream().anyMatch((authority -> authority.getAuthority().equals("ROLE_PRODUCTOWNER")));
            model.addAttribute("isProductOwner", isProductOwner);
        }
        List<Products> products = productsRepo.findAll();
        model.addAttribute("products", products);
        return "Menu";
    }

    @GetMapping("/login")
    public String Login() {
        return "Login";
    }

    @GetMapping("/SignUp")
    public String SignUp() {
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
        if (!Img.isEmpty()) {
            UUID uuid = UUID.randomUUID();
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
        product.setProductOwnersID(customerRepo.findByCustomerID(user.getName()).getProductOwnersID());
        product.setStartBid(new Date(millis));
        product.setQuantity(1);
        product.setDescription(Description);
        product.setEndBid(enddate);
        product.setState("used");
        product.setTitle(Title);
        productsRepo.save(product);
        return "redirect:/";
    }
}