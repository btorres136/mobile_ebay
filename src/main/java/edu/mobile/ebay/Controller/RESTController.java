package edu.mobile.ebay.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mobile.ebay.Controller.MessageTemplates.Greetings;

@RestController
public class RESTController {

    @GetMapping("/test")
    public Greetings test(){
       return new Greetings(1, "hello");
    }

}