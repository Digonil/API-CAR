package com.niles.CAR.domain;

import com.niles.CAR.dto.CreateDriverDto;
import com.niles.CAR.dto.CreateTravelRequestDto;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_travel_request")
public class TravelRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne
    private Passenger passenger;
    private String origin;
    private String destination;

    public TravelRequest() {
    }

    public TravelRequest(Passenger passenger, String origin, String destination) {
        this.passenger = passenger;
        this.origin = origin;
        this.destination = destination;
    }

    public TravelRequest(CreateTravelRequestDto dto) {
        this.passenger = dto.getPassenger();
        this.origin = dto.getOrigin();
        this.destination = dto.getDestination();
    }

    public Long getId() {
        return Id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelRequest that = (TravelRequest) o;
        return Objects.equals(Id, that.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    @Override
    public String toString() {
        return "TravelRequest{" +
                "Id=" + Id +
                ", passenger=" + passenger +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
