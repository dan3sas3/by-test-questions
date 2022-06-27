package com.example.testproject.model;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Availability {
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
    private Double availQty;

}
