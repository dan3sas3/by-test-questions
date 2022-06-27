package com.example.testproject.controller;

import com.example.testproject.model.*;
import com.example.testproject.model.Calendar;
import com.example.testproject.service.TestService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@RestController
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/sortProducts")
    ProductList sortProducts(@RequestBody ProductList productList) {
        ProductList finalList = new ProductList();
        finalList.setProductList(productList.getProductList().stream()
                .sorted(
                        Comparator.comparing(Product::getProductId)
                                .thenComparing(Product::getLaunchDate)
                                .reversed()
                )
                .collect(Collectors.toList()));
        return finalList;
    }

    @PostMapping("/getProdAvailability")
    ProductResponse getProdAvailability(@RequestBody ProductRequest productRequest) throws Exception{
        List<Availability> availabilityList = new ArrayList<Availability>();
        availabilityList.add(
                new Availability("Store001", "Prod1", new Date(2021-02-19), 1.0)
        );
        availabilityList.add(
                new Availability("Store001", "Prod1", new Date(2021-02-20), 3.0)
        );
        availabilityList.add(
                new Availability("Store001", "Prod1", new Date(2021-02-21), 0.0)
        );
        List<Capacity> capacityList = new ArrayList<Capacity>();
        capacityList.add(
                new Capacity("Store001", "Prod1", new Date(2021-02-19), 0.0)
        );
        capacityList.add(
                new Capacity("Store001", "Prod1", new Date(2021-02-20), 2.0)
        );
        capacityList.add(
                new Capacity("Store001", "Prod1", new Date(2021-02-21), 2.0)
        );
        CompletableFuture<Double> availability = testService.getAvailability(availabilityList, productRequest.getStoreNo(), productRequest.getReqDate());
        CompletableFuture<Double> capacity = testService.getCapacity(capacityList, productRequest.getStoreNo(), productRequest.getReqDate());
        CompletableFuture.allOf(availability, capacity).join();
        ProductResponse productResponse = new ProductResponse(
                productRequest.getStoreNo(),
                productRequest.getProductId(),
                productRequest.getReqQty(),
                productRequest.getReqDate(),
                "No Capacity");
        if (capacity.get() == 0 || availability.get() == 0) {
            return productResponse;
        } else {
            productResponse.setStatus("Available");
            return productResponse;
        }
    }

    @PostMapping("/findStoreAvailability")
    StoreAvailabilityResponse findStoreAvailabity(@RequestBody StoreAvailabilityRequest storeRequest) {
        List<Calendar> calendars = new ArrayList<Calendar>();
        calendars.add(new Calendar("STORE001", "ALL", LocalTime.parse("13:30")));
        calendars.add(new Calendar("STORE002", "SUNDAY", LocalTime.parse("13:30")));
        calendars.add(new Calendar("STORE003", "MONDAY", LocalTime.parse("13:30")));
        StoreAvailabilityResponse storeResponse = new StoreAvailabilityResponse(
                storeRequest.getStoreID(),
                storeRequest.getRequestedDate(),
                "Not Available");
        calendars.stream().filter(
                calendar -> calendar.getLocationID() == storeRequest.getStoreID()
        );
        return storeResponse;
    }

}
