package com.example.testproject.model;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Capacity {

    @Getter
    @Setter
    private String storeNo;

    @Getter
    @Setter
    private String productId;

    @Getter
    @Setter
    private Date date;

    @Getter
    @Setter
    private Double noOfOrdersAccepted;
}
