package edu.mobile.ebay.Controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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

    @GetMapping("/products")
    public String products(@RequestParam int AutoId){
        //Automotive automotive = autoRepo.findById(AutoId);
        return "products";
    }
}