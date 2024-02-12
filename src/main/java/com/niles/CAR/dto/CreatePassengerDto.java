package com.niles.CAR.dto;

import com.niles.CAR.domain.Passenger;

public class CreatePassengerDto {
    private String name;


    public CreatePassengerDto() {
    }

    public CreatePassengerDto(Passenger passenger) {
        this.name = passenger.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
