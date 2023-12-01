package com.dailycodebuffer.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Productresponsedto {

    private String productname;
    private long productid;
    private long price;
    private long quantity;
}
