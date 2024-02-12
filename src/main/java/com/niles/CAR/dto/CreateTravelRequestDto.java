package com.niles.CAR.dto;

import com.niles.CAR.domain.Passenger;

public class CreateTravelRequestDto {

    private Passenger passenger;
    private String origin;
    private String destination;

    public CreateTravelRequestDto() {
    }

    public CreateTravelRequestDto(Passenger passenger, String origin, String destination) {
        this.passenger = passenger;
        this.origin = origin;
        this.destination = destination;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
