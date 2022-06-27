package com.example.testproject.model;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    @Getter
    @Setter
    private String productId;

    @Getter
    @Setter
    private String productName;

    @Getter
    @Setter
    private String unitOfMeasure;

    @Getter
    @Setter
    private Date launchDate;


}
