package com.dailycodebuffer.productservice.controller;

import com.dailycodebuffer.productservice.model.Productresponsedto;
import com.dailycodebuffer.productservice.model.Productdto;
import com.dailycodebuffer.productservice.service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    Productservice productservice;
    @PostMapping("/post")
    public ResponseEntity<Long> addlong(@RequestBody Productdto productdto){
        long productid=productservice.addproduct(productdto);
        return new ResponseEntity<>(productid, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Productresponsedto> getproductbyid(@PathVariable("id")long productid){
        Productresponsedto productresponsedto=productservice.getproductbyid(productid);
        return new ResponseEntity<>(productresponsedto,HttpStatus.OK);
    }
    @PutMapping("/reduce/{id}")
    public ResponseEntity<Void> reducequantity(@PathVariable("id") long productid,@RequestParam long quantity){
        productservice.getreducequantity(productid,quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
