package co.edu.umanizales.controller;

import co.edu.umanizales.model.Location;
import co.edu.umanizales.model.Seller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/seller")
public class SellerControler {

    @GetMapping
    public Seller getSeller(){
        Location manizales = new Location("17001", "Manizales");
        Location pereira = new Location("66001", "Pereira");

        Seller juan = new Seller("1128901454","juan","perez", 'm', (byte) 22 ,manizales);
        Seller maria = new Seller("1514728602","maria","gomez", 'f', (byte) 31, pereira);
        Seller pepe = new Seller("1412549231","pepe","miranda", 'm', (byte) 39, manizales);
        Seller pedro = new Seller("6451213047","pedro","lopez", 'm', (byte) 45, manizales);
        Seller camila = new Seller("4578120312","camila","mejia", 'f', (byte) 25,  manizales);


        return camila;
    }
}
