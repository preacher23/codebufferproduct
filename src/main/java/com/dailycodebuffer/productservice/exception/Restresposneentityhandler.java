package com.dailycodebuffer.productservice.exception;

import com.dailycodebuffer.productservice.model.Errorresponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class Restresposneentityhandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Productservicecustomexception.class)
    public ResponseEntity<Errorresponse> handleproductexception(Productservicecustomexception productservicecustomexception){
        return new ResponseEntity<>(new Errorresponse().builder().errormessage(productservicecustomexception.getMessage()).errorcode(productservicecustomexception.getErrorcode()).build(), HttpStatus.NOT_FOUND);
    }
}
