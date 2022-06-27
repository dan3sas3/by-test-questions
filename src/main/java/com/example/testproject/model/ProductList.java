package com.example.testproject.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductList {
    @Getter
    @Setter
    private List<Product> productList;
}
