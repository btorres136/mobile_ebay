package edu.mobile.ebay.Controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mobile.ebay.DAO.Entities.Automotive;
import edu.mobile.ebay.DAO.Repositories.AutomotiveRepo;

@Controller
public class WebController {

    @GetMapping(value = {"/", "/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String Login(){
        return "Login";
    }

    @GetMapping("/sec/Menu")
    public String Menu(Model model, Principal user){
        return "Menu";
    }

    AutomotiveRepo autoRepo;
    @GetMapping("/products")
    public ModelAndView products(@RequestParam int AutoId){
        ModelAndView mv = new ModelAndView("products.jsp");
        //Automotive automotive = autoRepo.findById(AutoId);
        return mv;
    }
}