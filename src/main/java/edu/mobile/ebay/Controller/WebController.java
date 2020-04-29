package edu.mobile.ebay.Controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.mobile.ebay.DAO.Entities.Bids;
import edu.mobile.ebay.DAO.Entities.Products;
import edu.mobile.ebay.DAO.Entities.Sales;
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
    CustomersRepo customer;

    @Autowired
    BidsRepo bid;

    @Autowired
    AutomotiveRepo autoRepo;

    @Autowired
    BidsRepo bidRepo;

    @Autowired
    CustomersRepo customerRepo;

    @Autowired
    ElectronicsRepo electronicsRepo;

    @Autowired
    ProductOwnersRepo PORepo;

    @Autowired
    ProductsRepo productsRepo;

    @Autowired
    SalesRepo salesRepo;

    @Autowired
    SportsRepo sportRepo;

    @Autowired
    ProductOwnersRepo productownersrepo;

    LDAPManager ldap = new LDAPManager();

    @GetMapping(value = { "/", "/index" })
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String Login() {
        return "Login";
    }
    @GetMapping("/SignUp")
    public String SignUp(){
        return "SignUp";
    }
    @PostMapping("/SignUp")
    public String SignUp(@RequestParam("username") String User, @RequestParam("password") String Password){
        ldap.create(User, Password);
        return "redirect:/sec/Menu";
    }

    @GetMapping("/sec/Menu")
    public String Menu(Model model, Principal user) {
        model.addAttribute("user", user.getName());
        List<Products> products = productsRepo.findAll();
        model.addAttribute("products", products);

        return "Menu";
    }

    @GetMapping("/sec/Products/Add")
    public String AddProduct() {
        return "AddProduct";
    }

    @PostMapping("/sec/Products/Add")
    public String AddtoProducts(@RequestParam("ProductTitle") String Title, HttpServletRequest request,
            @RequestParam("Description") String Description, @RequestParam("endbid") Date enddate, @RequestParam("img") MultipartFile Img, Principal user)
            throws IllegalStateException, IOException {
        Products product = new Products();
        if (Img != null) {
            UUID uuid = UUID.randomUUID();
            String actualPath = "/UserIMG/" + user.getName() + "/" + uuid.toString() + ".jpg";
            String path = request.getSession().getServletContext()
                    .getRealPath("/UserIMG/" + user.getName() + "/" + uuid.toString() + ".jpg");
            File dirPath = new File(path);
            if (!dirPath.exists()) {
                dirPath.mkdirs();
            }
            product.setImagePath(actualPath);
            Img.transferTo(dirPath);
        }
        long millis = System.currentTimeMillis(); 
        product.setProductOwnersID(productownersrepo.findById(Integer.toUnsignedLong(1235)).get());
        product.setStartBid(new Date(millis));
        product.setQuantity(1);
        product.setDescription(Description);
        product.setEndBid(enddate);
        product.setState("used");
        product.setTitle(Title);
        productsRepo.save(product);
        return "redirect:/sec/Menu";
    }

    @GetMapping("/products")
    public String products(Model model) {
        /*
         * Automotive car = autoRepo.findById(Long.parseLong("1998")).orElse(new
         * Automotive()); model.addAttribute("car", car.getAutoDescription());
         */

        /*
         * List<Customers> customer = customerRepo.findCustomerandProductOwner();
         * model.addAttribute("customer", customer.get(0).getName());
         */

        List<Bids> bids = bidRepo.findBids(112);
        model.addAttribute("bids", bids);

        List<Sales> sales = salesRepo.findSalesByCustomerID(112);
        model.addAttribute("sales", sales);

        List<Products> products = productsRepo.findAll();
        model.addAttribute("products", products);

        List<Products> products2 = productsRepo.findProductByKeyWord("bat");
        model.addAttribute("products2", products2);

        List<Products> product_sport = productsRepo.findSportProductsByKeyWord("bat");
        model.addAttribute("product_sport", product_sport);

        List<Products> product_electronics = productsRepo.findElectronicProductsByKeyWord("Dell Latop");
        model.addAttribute("product_electronics", product_electronics);

        List<Products> product_auto = productsRepo.findAutomotiveProductsByKeyWord("doge");
        model.addAttribute("product_auto", product_auto);
        
        List<Products> product_bids = productsRepo.findProductOwnerPoductBidsByPorudctOwnerId(1111);
        model.addAttribute("product_bids", product_bids);
        return "products";
    }

    /*
     * @GetMapping("/error") public String handleError(Model model,
     * HttpServletRequest request) { Object status =
     * request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
     * 
     * if (status != null) { Integer statusCode =
     * Integer.valueOf(status.toString()); switch (statusCode) { case 404:
     * model.addAttribute("error", 404); break; default: break; } } return "error";
     * }
     */
}