package com.niles.CAR.dto;

import com.niles.CAR.domain.Passenger;

public class UpdatePassengerDto {
    private String name;

    public UpdatePassengerDto() {
    }

    public UpdatePassengerDto(Passenger passenger) {
        this.name = passenger.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
