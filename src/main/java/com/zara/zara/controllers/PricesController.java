package com.zara.zara.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/prices")
public class PricesController {
    @GetMapping("/get-prices")
    public ResponseEntity<String> getPrices (){
        return  ResponseEntity.ok("Hola Manito");
    }

}

