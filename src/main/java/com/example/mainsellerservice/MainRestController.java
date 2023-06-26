package com.example.mainsellerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {

    @Autowired
    ProductofferRepository productofferRepository;
    public MainRestController(ProductofferRepository productofferRepository) {
        this.productofferRepository = productofferRepository;
    }

    @PostMapping("saveoffer")
    public ResponseEntity<String> createOffer(@RequestParam("sellername") String sellername, @RequestParam("hscode") String hscode, @RequestParam("offername") String offername,  @RequestParam("Qty") Integer qty,  @RequestParam("unit") String unit,  @RequestParam("unitprice") Integer unitprice){
        Productoffer productoffer = new Productoffer();
        productoffer.setId(String.valueOf(((int)(Math.random()*1000))));
        productoffer.setUsername(sellername);
        productoffer.setOffername(offername);
        productoffer.setHscode(hscode);
        productoffer.setUnit(unit);
        productoffer.setQty(qty);
        productoffer.setUnitprice(unitprice);
        productofferRepository.save(productoffer);
        return new ResponseEntity<>("New Offer Created", HttpStatus.OK);



    }

}
