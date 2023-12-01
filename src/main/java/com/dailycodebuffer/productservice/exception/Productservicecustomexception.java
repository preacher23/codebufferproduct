package com.dailycodebuffer.productservice.exception;

import lombok.Data;

@Data
public class Productservicecustomexception extends RuntimeException{
    private String errorcode;
    public Productservicecustomexception(String message,String errorcode){
        super(message);
        this.errorcode=errorcode;
    }
}
