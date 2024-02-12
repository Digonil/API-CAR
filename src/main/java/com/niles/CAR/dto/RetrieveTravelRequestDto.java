package com.niles.CAR.dto;

import com.niles.CAR.domain.Passenger;
import com.niles.CAR.domain.TravelRequest;

public class RetrieveTravelRequestDto {

    private Long id;
    private Passenger passenger;
    private String origin;
    private String destination;

    public RetrieveTravelRequestDto() {
    }

    public RetrieveTravelRequestDto(Long id, Passenger passenger, String origin, String destination) {
        this.id = id;
        this.passenger = passenger;
        this.origin = origin;
        this.destination = destination;
    }

    public RetrieveTravelRequestDto(TravelRequest travelRequest) {
        this.id = travelRequest.getId();
        this.passenger = travelRequest.getPassenger();
        this.origin = travelRequest.getOrigin();
        this.destination = travelRequest.getDestination();
    }

    public Long getId() {
        return id;
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
