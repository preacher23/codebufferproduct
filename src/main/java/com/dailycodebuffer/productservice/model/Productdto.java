package com.dailycodebuffer.productservice.model;

import lombok.Data;

@Data
public class Productdto {
    private String productname;
    private long price;
    private long quantity;
}
