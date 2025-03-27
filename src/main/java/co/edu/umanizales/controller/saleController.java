package co.edu.umanizales.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sale")
public class saleController {

    @GetMapping
    public String getSale(){

        return "sale";
    }

}
