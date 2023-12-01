package com.dailycodebuffer.productservice.service;

import com.dailycodebuffer.productservice.exception.Productservicecustomexception;
import com.dailycodebuffer.productservice.model.Productdto;
import com.dailycodebuffer.productservice.model.Productresponsedto;
import com.dailycodebuffer.productservice.repo.Productrepo;
import com.dailycodebuffer.productservice.entity.Product;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class Productservice {
  @Autowired
  Productrepo productrepo;
    public long addproduct(Productdto productdto) {
        log.info("add product");
        Product product=Product.builder().productname(productdto.getProductname())
                .price(productdto.getPrice()).quantity(productdto.getQuantity()).build();
          productrepo.save(product);
          log.info("product saved");
          return product.getProductid();
    }

    public Productresponsedto getproductbyid(long productid) {
      log.info("get product by id");
      Product product=productrepo.findById(productid).orElseThrow(()->new Productservicecustomexception("product not here","PRODUCT NOT FOUND"));
      Productresponsedto product1= new Productresponsedto().builder().productname(product.getProductname()).price(product.getPrice()).quantity(product.getQuantity())
              .productid(product.getProductid()).build();
      return product1;
//      Productresponsedto productresponsedto=new Productresponsedto();
//      BeanUtils.copyProperties(product,productresponsedto);


    }

  public void getreducequantity(long productid, long quantity) {
    log.info("reduce quantity");
    Product product=productrepo.findById(productid).orElseThrow(()->new Productservicecustomexception("product not found","PRODUCT_NOT_FOUND"));
    if (product.getQuantity()<quantity){
      throw new Productservicecustomexception("quantity not enough",
              "INSUFFICIENT QUANTITY");
    }
    product.setQuantity(product.getQuantity()-quantity);

    productrepo.save(product);
    log.info("product saved");
  }
}
