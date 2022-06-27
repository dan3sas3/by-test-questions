package com.example.testproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class StoreAvailabilityRequest {
    @Getter
    @Setter
    private String storeID;
    @Getter
    @Setter
    private Date requestedDate;
}
