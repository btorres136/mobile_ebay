package edu.mobile.ebay.Controller;

import java.security.Principal;
import java.util.List;

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

    @GetMapping(value = {"/", "/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String Login() {
        return "Login";
    }

    @GetMapping("/sec/Menu")
    public String Menu(Model model, Principal user) {
        model.addAttribute("user", user.getName());
        List<Products> products = productsRepo.findAll();
        model.addAttribute("products", products);
        return "Menu";
    }

    @GetMapping("/sec/Products/Add")
    public String AddProduct(){
        return "AddProduct";
    }

    @PostMapping("/sec/Products/Add")
    public String AddtoProducts(
        @RequestParam("ProductTitle") String Title, 
        @RequestParam("Description") String Description,
        @RequestParam("img") MultipartFile Img
    ){
    
        return "AddProduct";
    }
 
    @GetMapping("/products")
    public String products(Model model){
        /*Automotive car = autoRepo.findById(Long.parseLong("1998")).orElse(new Automotive());
        model.addAttribute("car", car.getAutoDescription());*/
        
        /*List<Customers> customer = customerRepo.findCustomerandProductOwner();
        model.addAttribute("customer", customer.get(0).getName());*/
        
        List<Bids> bids = bidRepo.findBids(112);
        model.addAttribute("bids", bids);

        List<Sales> sales = salesRepo.findSalesByCustomerID(112);
        model.addAttribute("sales", sales);

        List<Products> products = productsRepo.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    /*@GetMapping("/error")
    public String handleError(Model model, HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            switch (statusCode) {
                case 404:
                    model.addAttribute("error", 404);
                    break;
                default:
                    break;
            }
        }
        return "error";
    }*/
}