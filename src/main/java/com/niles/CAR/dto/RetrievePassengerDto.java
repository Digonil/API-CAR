package com.niles.CAR.dto;

import com.niles.CAR.domain.Passenger;

import java.util.Date;

public class RetrievePassengerDto {

    private Long id;
    private String name;


    public RetrievePassengerDto() {
    }

    public RetrievePassengerDto(Passenger passenger) {
        this.id = passenger.getId();
        this.name = passenger.getName();

    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
