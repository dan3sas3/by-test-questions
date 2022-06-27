package com.example.testproject.service;

import com.example.testproject.model.Availability;
import com.example.testproject.model.Capacity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class TestService  {

    @Async
    public CompletableFuture<Double> getAvailability(List<Availability> availabilityList, String storeNo, Date reqDate) throws Exception{
        Double result = availabilityList.stream().filter(availability ->
            availability.getDate() == reqDate && availability.getStoreNo() == storeNo
        ).map(a -> a.getAvailQty()).findAny().orElseThrow(Exception::new);
        return CompletableFuture.completedFuture(result);
    }

    @Async
    public CompletableFuture<Double> getCapacity(List<Capacity> capacityList, String storeNo, Date reqDate) throws Exception{
        Double result = capacityList.stream().filter(capacity ->
                capacity.getDate() == reqDate && capacity.getStoreNo() == storeNo
        ).map(capacity -> capacity.getNoOfOrdersAccepted()).findAny().orElseThrow(Exception::new);
        return CompletableFuture.completedFuture(result);
    }
}
