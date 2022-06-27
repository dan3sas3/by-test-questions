package com.example.testproject.model;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductResponse {
    @Getter
    @Setter
    private String storeNo;

    @Getter
    @Setter
    private String productId;

    @Getter
    @Setter
    private Double reqQty;

    @Getter
    @Setter
    private Date reqDate;

    @Getter
    @Setter
    private String status;
}
