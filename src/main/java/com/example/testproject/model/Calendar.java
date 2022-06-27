package com.example.testproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
public class Calendar {
    @Getter
    @Setter
    private String locationID;

    @Getter
    @Setter
    private String Day;

    @Getter
    @Setter
    private LocalTime cutOffTime;
}
