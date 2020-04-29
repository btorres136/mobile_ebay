package edu.mobile.ebay.Controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mobile.ebay.DAO.Entities.Bids;
import edu.mobile.ebay.DAO.Entities.Customers;
import edu.mobile.ebay.DAO.Repositories.BidsRepo;
import edu.mobile.ebay.DAO.Repositories.CustomersRepo;

@Controller
public class WebController {
    @Autowired
    CustomersRepo customer;

    @Autowired
    BidsRepo bid;

    @GetMapping(value = { "/", "/index" })
    public String index(Model model) {
        List<Customers> cus = customer.findCustomerandProductOwner();
        model.addAttribute("cus", cus);
        List<Bids> bid1 = bid.ListAllBidsFromCustomer(112);
        model.addAttribute("bid", bid1);
        return "index";
    }

    @GetMapping("/login")
    public String Login() {
        return "Login";
    }

    @GetMapping("/sec/Menu")
    public String Menu(Model model, Principal user) {
        model.addAttribute("user", user.getName());
        return "Menu";
    }

    @GetMapping("/products")
    public String products(@RequestParam int AutoId) {
        // Automotive automotive = autoRepo.findById(AutoId);
        return "products";
    }

    @GetMapping("/error")
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
    }
}